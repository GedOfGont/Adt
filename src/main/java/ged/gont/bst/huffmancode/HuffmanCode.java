package ged.gont.bst.huffmancode;

import java.util.BitSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanCode {

    private Node root;
    Map<Character, String> charMap = new LinkedHashMap<>();

    /**
     * Encodes string in which most used characters have min codeword length
     * 
     * @param inputString compressed string
     * @return encoded string
     * @throws IllegelArgumentException if inputString contains invalid ASCII character 
     */
    public BitSet encode(String inputString) {

        char[] letters = inputString.toCharArray();
        Map<Character, Integer> charFreq = new LinkedHashMap<>();
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        String encodedString = "";

        for (char c : letters) {
            if ((int) c > 255) {
                throw new IllegalArgumentException("Input contains invalid ASCII character");
            }

            if (charFreq.containsKey(c)) {
                charFreq.put(c, charFreq.get(c) + 1);
            } else {
                charFreq.put(c, 1);
            }
        }

        for (Character c : charFreq.keySet()) {
            priorityQueue.offer(new Node(c, charFreq.get(c), null, null));
        }

        while (priorityQueue.size() > 1) {
            Node leftChild = priorityQueue.remove();
            Node rightChild = priorityQueue.remove();
            priorityQueue.offer(new Node(Character.MIN_VALUE, leftChild.getFreq() + rightChild.getFreq(), leftChild, rightChild));
        }

        root = priorityQueue.remove();
        generatePrefix(root, "");

        for (int i = 0; i < inputString.length(); i++) {
            encodedString += (charMap.get(inputString.charAt(i)));
        }
        return convertBitSet(encodedString);

    }

    /**
     * Generates prefix code in bit string format
     * 
     * @param root
     * @param prefix
     */
    private void generatePrefix(Node root, String prefix) {
        if (!root.isLeaf()) {
            generatePrefix(root.getLeftChild(), prefix.concat("0"));
            generatePrefix(root.getRightChild(), prefix.concat("1"));
        } else {
            charMap.put(root.getLetter(), prefix);
        }
    }


    /**
     * 
     * @param encodedString
     * @return bitset that converted from encodedString
     */
    private BitSet convertBitSet(String encodedString){
        BitSet bitSet = new BitSet();
        int index = 0;
        for (char i : encodedString.toCharArray()) {
            if(i == '0'){
                bitSet.set(index++, false);
            }else{
                bitSet.set(index++, true);
            }
        }
        return bitSet;
    }

    /**
     * Decodes the given encoded string
     * 
     * @param encodedString
     * @return decoded string
     */
    public String decode(BitSet encodedString) {
        String decodedString = "";
        Node currentNode = root;

        for (int i = 0; i < encodedString.length(); i++) {

            if (encodedString.get(i) == false) {
                currentNode = currentNode.getLeftChild();
            } else if (encodedString.get(i) == true) {
                currentNode = currentNode.getRightChild();
            }
            if (currentNode.isLeaf()) {
                decodedString += currentNode.getLetter();
                currentNode = root;
            }
        }

        return decodedString;
    }
}