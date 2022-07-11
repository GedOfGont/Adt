package ged.gont.bst;

public class Node<T> {
    private T value;
    private Node<T> leftChild;
    private Node<T> rightChild;
    
    public Node(final T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(final T value) {
        this.value = value;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(final Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(final Node<T> rightChild) {
        this.rightChild = rightChild;
    }
}
