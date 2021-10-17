package question_two.Integer;

import question_two.Node;

public class StorageIntegerImpl implements StorageIntegerInterface {

    Node<Integer> root;
    int numberOfNullsAdded = 0;

    @Override
    public boolean add(Integer x) {
        if (x == null) {
            numberOfNullsAdded++;
            return true;
        }
        root = addR(root, x);
        return true;
    }

    private Node<Integer> addR(Node<Integer> root, Integer key) {
        if (root == null) {
            root = new Node<>(key);
            return root;
        }
        if (key.compareTo(root.key) <= 0) {
            root.left = addR(root.left, key);
        } else if (key.compareTo(root.key) > 0) {
            root.right = addR(root.right, key);
        }
        return root;
    }

    @Override
    public boolean find(Integer x) {
        return findR(root, x);
    }

    private boolean findR(Node<Integer> currentNode, Integer key) {
        if (currentNode == null) {
            return false;
        }
        if (key.compareTo(currentNode.key) == 0) {
            return true;
        }
        if (key.compareTo(currentNode.key) < 0) {
            return findR(currentNode.left, key);
        }
        return findR(currentNode.right, key);
    }

    @Override
    public boolean includesNull() {
        return this.numberOfNullsAdded > 0;
    }

    @Override
    public boolean delete(Integer x) {
        return false;
    }
}
