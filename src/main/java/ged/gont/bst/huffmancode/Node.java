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

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public int getFreq() {
        return freq;
    }

    public void setFreq(int freq) {
        this.freq = freq;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public boolean isLeaf(){
        return leftChild == null && rightChild == null;
    }

    @Override
    public int compareTo(Node arg0) {
        return this.freq-arg0.freq;
    }
    
}
