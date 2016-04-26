/**
 * Write a program that implements the tree heap (the tree-based implementation
 * of the heap) discussed in the text. Make sure you can remove the largest item,
 * insert items, and change an item’s key. The tree heap operates in O(logN) time.
 * As in the array-based heap the time is mostly spent doing the trickle-up and
 * trickle-down operations, which take time proportional to the height of the tree.
 */
public class TreeHeap {
    private Node root;
    private int numNodes;

    public TreeHeap() {
        numNodes = 0;
    }

    private Node findLastNode() {
        if(root == null) return null;
        String binaryPath = convertToBinary(numNodes);
        Node lastNode = root;
        for(int i = 1; i < binaryPath.length(); i++) {
            if(binaryPath.charAt(i) == 0) {
                lastNode = lastNode.getLeftChild();
            } else {
                lastNode = lastNode.getRightChild();
            }
        }
    }

    private String convertToBinary(int nodeNumber) {
        return Integer.toBinaryString(nodeNumber);
    }

    private Node findFirstEmptyNode() {

    }
}
