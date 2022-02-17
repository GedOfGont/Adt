package ged.gont.bst.huffmancode;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class HuffmanCode {
    private Node root;
    private String compressedString = "";

    public String encode(String inputString) {

        char[] letters = inputString.toCharArray();
        Map<Character, Integer> charFreq = new TreeMap<>();
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();

        for (char c : letters) {
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
            priorityQueue.offer(new Node('x', leftChild.getFreq() + rightChild.getFreq(), leftChild, rightChild));
        }

        root = priorityQueue.remove();
        return generateCode(root, "");
    }

    public String generateCode(Node root, String code) {
        if (!root.isLeaf()) {
            generateCode(root.getLeftChild(), code.concat("0"));
            generateCode(root.getRightChild(), code.concat("1"));
        } else {
            compressedString += code;
        }
        return compressedString;
    }

    public String decode(String compressedData) {
        String string = "";
        Node currentNode = root;

        for (int i = 0; i < compressedData.length(); i++) {

            if (compressedData.charAt(i) == '0') {
                currentNode = currentNode.getLeftChild();
                if (currentNode.isLeaf()) {
                    string += currentNode.getLetter();
                    currentNode = root;
                }
            } else if (compressedData.charAt(i) == '1') {
                currentNode = currentNode.getRightChild();
                if (currentNode.isLeaf()) {
                    string += currentNode.getLetter();
                    currentNode = root;
                }
            }
        }

        return string;
    }

    public static void main(String[] args) {
        HuffmanCode huffmanCode = new HuffmanCode();
        System.out.println(huffmanCode.decode(huffmanCode.encode("A_DEAD_DAD_CEDED_A_BAD_BABE_A_BEADED_ABACA_BED")));
    }
}
