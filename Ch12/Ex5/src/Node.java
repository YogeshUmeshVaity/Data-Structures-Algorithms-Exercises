/**
 * Represent a node in a binary tree.
 */
public class Node {
    private int key;
    private Node parent;
    private Node rightChild;
    private Node leftChild;

    public Node(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
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

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
}
