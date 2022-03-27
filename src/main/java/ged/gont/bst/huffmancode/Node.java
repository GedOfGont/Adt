package ged.gont.bst.huffmancode;

class Node implements Comparable<Node> {

    private final char letter;
    private final int freq;
    private final Node leftChild;
    private final Node rightChild;

    public Node(final char letter,final int freq,final Node leftChild,final Node rightChild) {
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
    public int compareTo(Node otherNode) {
        return this.freq - otherNode.freq;
    }

}
