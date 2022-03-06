package ged.gont.bst.huffmancode;

public class Node implements Comparable<Node> {

    private char letter;
    private int freq;
    private Node leftChild;
    private Node rightChild;

    public Node(char letter, int freq, Node leftChild, Node rightChild) {
        this.letter = letter;
        this.freq = freq;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public char getLetter() {
        return letter;
    }

    public int getFreq() {
        return freq;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public boolean isLeaf() {
        return this.leftChild == null && this.rightChild == null;
    }

    @Override
    public int compareTo(Node arg0) {
        return this.freq - arg0.freq;
    }

}
