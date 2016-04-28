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

    public void setKey(int key) {
        this.key = key;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
        if (leftChild != null) {
            leftChild.setParent(this);
        }
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
        if (rightChild != null) {
            rightChild.setParent(this);
        }
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "" + key;
    }
}
