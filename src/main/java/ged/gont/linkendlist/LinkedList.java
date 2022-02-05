package ged.gont.linkendlist;

import java.util.NoSuchElementException;

public class LinkedList<T extends Comparable<T>> {
    public class Node {
        private Node next;
        private Node previous;
        private T value;

        public Node(T value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }

    private Node root = null;
    private int size = 0;

    public void append(T value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
        } else {
            Node lastElement = getLastElement();
            lastElement.setNext(newNode);
            newNode.setPrevious(lastElement);

        }
        size++;
    }

    public void insert(int index, T value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
        } else {
            Node nextNode = findByIndex(index);
            nextNode.getPrevious().setNext(newNode);
            newNode.setPrevious(nextNode.getPrevious());
            newNode.setNext(nextNode);
        }
    }

    public void remove(T value) {
        Node removedNode = findByValue(value);
        removedNode.getPrevious().setNext(removedNode.getNext());
        size--;
    }

    public Node findByValue(T value) {
        Node currentNode = root;
        while (currentNode != null) {
            if (currentNode.getValue().compareTo(value) == 0) {
                return currentNode;
            }
            currentNode = currentNode.getNext();
        }
        throw new NoSuchElementException();
    }

    public Node findByIndex(int index) {
        if (index > size()) {
            throw new ArrayIndexOutOfBoundsException();
        }

        Node currentNode = root;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }

        return currentNode;
    }

    private Node getLastElement() {
        Node currentNode = root;
        while (currentNode.next != null) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    public int size() {
        return size;
    }
}
