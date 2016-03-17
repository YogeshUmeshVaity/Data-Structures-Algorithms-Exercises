/** Represents a node in a binary tree data structure */
public class Node {
    private Character character;
    private int frequency;
    private Node leftChild;
    private Node rightChild;

    public Node(Character character, int frequency) {
        this.character = character;
        this.frequency = frequency;
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

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public Character getCharacter() {
        return character;
    }

    /** Returns a String representation of this node. */
    @Override
    public String toString() {
        if(character == null) {
            return "" + frequency;
        } else {
            return "" + character + ":" + frequency;
        }

    }
}
