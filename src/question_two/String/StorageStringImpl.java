package question_two.String;

import question_two.Node;

public class StorageStringImpl implements StorageStringInterface {
    Node<String> root;
    int numberOfNullsAdded = 0;

    @Override
    public boolean add(String x) {
        if (x == null) {
            numberOfNullsAdded++;
            return true;
        }
        root = addR(root, x);
        return true;
    }

    private Node<String> addR(Node<String> root, String key) {
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
    public boolean find(String x) {
        if (x == null) {
            return this.numberOfNullsAdded > 0;
        }
        return findR(root, x);
    }

    private boolean findR(Node<String> currentNode, String key) {
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
    public boolean delete(String x) {
        if (x == null) {
            if (numberOfNullsAdded == 0) {
                return false;
            }
            else {
                numberOfNullsAdded--;
                return true;
            }
        }
        if (find(x)) {
            root = deleteR(root, x);
            return true;
        }
        return false;
    }

    private Node<String> deleteR(Node<String> currentNode, String key) {
        if (currentNode == null) {
            return null;
        }
        if (currentNode.key.compareTo(key) == 0) {
            if (currentNode.left == null && currentNode.right == null) {
                return null;
            }
            if (currentNode.left == null) {
                return currentNode.right;
            }
            if (currentNode.right == null) {
                return currentNode.left;
            }
            String smallestValue = findSmallestValue(currentNode.right);
            currentNode.key = smallestValue;
            currentNode.right = deleteR(currentNode.right, smallestValue);
            return currentNode;
        }

        if (currentNode.key.compareTo(key) > 0) {
            currentNode.left = deleteR(currentNode.left, key);
        } else if (currentNode.key.compareTo(key) < 0) {
            currentNode.right = deleteR(currentNode.right, key);
        }
        return currentNode;
    }

    /**
     * This method helps to handle the case when we need to delete the node with two child nodes
     *
     * @param root currentNode
     * @return the value of the node with smallest value
     */
    private String findSmallestValue(Node<String> root) {
        if (root.left == null) {
            return root.key;
        }
        return findSmallestValue(root.left);
    }
}
