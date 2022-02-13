package ged.gont.bst;

public class BinarySearchTree<T extends Comparable<T>> {

    private Node<T> root;

    public BinarySearchTree() {
        root = null;
    }

    public Node<T> getRoot() {
        return root;
    }

    public void insert(T value) {
        root = insert(root, value);
    }

    private Node<T> insert(Node<T> root, T value) {
        if (root == null) {
            root = new Node<T>(value);
        } else if (root.getValue().compareTo(value) > 0) {
            root.setLeftChild(insert(root.getLeftChild(), value));
        } else {
            root.setRightChild(insert(root.getRightChild(), value));
        }
        return root;
    }

    public Node<T> find(T value) {
        return find(root, value);
    }

    private Node<T> find(Node<T> root, T value) {
        if (root == null) {
            throw new NullPointerException("Not found");
        } else if (root.getValue() == value) {
            return root;
        } else if (root.getValue().compareTo(value) > 0) {
            return find(root.getLeftChild(), value);
        } else {
            return find(root.getRightChild(), value);
        }
    }

    public Node<T> getRSubTreeMin(Node<T> root) {
        while (root.getLeftChild() != null) {
            root = root.getLeftChild();
        }
        return root;
    }

    public Node<T> getParent(T value) {
        return getParent(root, root, value);
    }

    private Node<T> getParent(Node<T> parent, Node<T> currentNode, T value) {
        if (currentNode == null) {
            throw new NullPointerException("Not found");
        } else if (currentNode.getValue().compareTo(value) == 0) {
            return parent;
        } else if (currentNode.getValue().compareTo(value) > 0) {
            return getParent(currentNode, currentNode.getLeftChild(), value);
        } else {
            return getParent(currentNode, currentNode.getRightChild(), value);
        }
    }

    public void delete(T value) {
        root = delete(root, value);
    }

    private Node<T> delete(Node<T> root, T value) {
        if (root == null) {
            return root;
        } else if (root.getValue().compareTo(value) > 0) {
            root.setLeftChild(delete(root.getLeftChild(), value));
        } else if (root.getValue().compareTo(value) < 0) {
            root.setRightChild(delete(root.getRightChild(), value));
        } else {
            if (root.getLeftChild() == null) {
                return root.getRightChild();
            } else if (root.getRightChild() == null) {
                return root.getLeftChild();
            }
            root.setValue(getRSubTreeMin(root.getRightChild()).getValue());
            root.setRightChild(delete(root.getRightChild(), root.getValue()));
        }
        return root;
    }

    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(Node<T> root) {
        if (root == null) {
            return -1;
        }
        int leftHeight = getHeight(root.getLeftChild());
        int rightHeight = getHeight(root.getRightChild());
        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }

    public void inOrder(Node<T> root) {
        if (root != null) {
            inOrder(root.getLeftChild());
            System.out.println(root.getValue());
            inOrder(root.getRightChild());
        }
    }
}
