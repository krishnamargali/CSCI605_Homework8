package question_two;
/*
 * Node.java
 */

/**
 * This class provides the needed data structure for the binary search tree
 *
 * @author Minh Le
 * @author Krishna
 */
public class Node<T> {
    public T key;
    public Node<T> left;
    public Node<T> right;

    public Node(T key) {
        this.key = key;
        left = null;
        right = null;
    }
}