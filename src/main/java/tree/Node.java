package tree;

public class Node<T extends Comparable<T>> {
    private T key;
    private Node<T> left;
    private Node<T> right;
    private Node<T> parent;

    public Node(T key) {
        this(key, null, null, null);
    }

    public Node(T key, Node<T> left, Node<T> right, Node<T> parent) {
        this.key = key;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
        if (left!=null) {
            left.setParent(this);
        }
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
        if (right!=null) {
            right.setParent(this);
        }
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }
}