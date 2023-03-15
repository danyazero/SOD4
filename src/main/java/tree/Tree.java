package tree;

import java.util.Comparator;


public class Tree<T extends Comparable<T>> {
    private Node<T> root;
    private Comparator<T> comparator;

    public boolean add(T value) {
        if(root == null) {
            root = new Node<T>(value);
            return true;
        }
        return addInSubTree(value, root);
    }

    public Tree (Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public Tree() {
        this.comparator = Comparator.naturalOrder();
    }

    private boolean addInSubTree(T value, Node<T> root) {
        if (value.equals(root.getKey())) {
            return false;
        }
        if ((comparator.compare(value, root.getKey ()) < 0)) {
            if (root.getLeft()==null) {
                root.setLeft(new Node<T>(value));
                return true;
            } else {
                return addInSubTree(value, root.getLeft());
            }
        } else {
            if (root.getRight() == null) {
                root.setRight(new Node<T>(value));
                return true;
            } else {
                return addInSubTree(value, root.getRight());
            }
        }
    }

    public void traverse() {
        traverse(root);
    }

    private void traverse(Node<T> root) {
        if (root != null) {
            traverse(root.getLeft());
            visit(root);
            traverse(root.getRight());
        }
    }

    public int getHeight(){
        return height(root);
    }

    public boolean getTreeBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node<T> node){
        int leftBranchHeight = height(root.getLeft());
        int rightBranchHeight = height(root.getRight());

        return Math.abs(leftBranchHeight - rightBranchHeight) <= 1;
    }

    private int height(Node myRoot) {
        if (myRoot == null) {
            return 0;
        }
        return 1 + Math.max(height(myRoot.getLeft()), height(myRoot.getRight()));
    }

    private void visit(Node<T> node) {
        System.out.println(node.getKey());
    }

    private Node<T> find(T key) {
        if (root == null) {
            return null;
        }
        return findInSubTree(key, root);
    }

    private Node<T> findInSubTree(T key, Node<T> root) {
        if (root==null || key.equals(root.getKey())) {
            return root;
        }
        if ((comparator.compare(key, root.getKey ()) < 0)) {
            return findInSubTree(key, root.getLeft());
        } else {
            return findInSubTree(key, root.getRight());
        }
    }

    public boolean contains(T key) {
        return find(key)!=null;
    }
}



