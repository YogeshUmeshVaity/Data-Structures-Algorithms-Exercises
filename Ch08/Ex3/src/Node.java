/** Represents a node in a binary tree data structure */
public class Node {
    private char letter;
    private Node leftChild;
    private Node rightChild;

    public Node(char letter) {
        this.letter = letter;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    /** Returns a String representation of this node. */
    @Override
    public String toString() {
        return "" + letter;
    }
}
