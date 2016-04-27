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

    private Node findLastNode(int numNodes) {
        if(root == null) return null;
        String binaryPath = convertToBinary(numNodes);
        Node lastNode = root;
        for(int i = 1; i < binaryPath.length(); i++) {
            if(binaryPath.charAt(i) == '0') {
                lastNode = lastNode.getLeftChild();
            } else {
                lastNode = lastNode.getRightChild();
            }
        }
        return lastNode;
    }

    private String convertToBinary(int nodeNumber) {
        return Integer.toBinaryString(nodeNumber);
    }

    private Node findFirstNullNode() {
        Node nullNode =
        return findLastNode(numNodes + 1);
    }

    public boolean insert(int key) {
        Node newNode = new Node(key);
        if(root == null) {
            root = newNode;
            numNodes++;
            return true;
        }
        Node lastNode = findLastNode(numNodes);
        Node nullNode = null;
        if(lastNode != root && lastNode.getParent().getRightChild() == null) {
            lastNode = lastNode.getParent();
        } else if(lastNode != root){
            lastNode = lastNode.getParent().getLeftChild();
        }
        if(lastNode.getLeftChild() == null) {
            lastNode.setLeftChild(newNode);
            newNode.setParent(lastNode);
            trickleUp(lastNode.getLeftChild());
        } else {
            lastNode.setRightChild(newNode);
            newNode.setParent(lastNode);
            trickleUp(lastNode.getRightChild());
        }
        numNodes++;
        return true;
    }

    private void trickleUp(Node nullNode) {
        Node parent = nullNode.getParent();
        int bottom = nullNode.getKey();
        while(parent != null && parent.getKey() < bottom) {
            nullNode.setKey(parent.getKey());
            nullNode = parent;
            parent = parent.getParent();
        }
        nullNode.setKey(bottom);
    }

    public static void main(String[] args) {
        TreeHeap treeHeap = new TreeHeap();
        treeHeap.insert(39);
        treeHeap.insert(93);
        treeHeap.insert(21);
        treeHeap.insert(22);
        treeHeap.insert(70);
        treeHeap.insert(90);
        treeHeap.insert(63);
        treeHeap.insert(60);
        treeHeap.insert(72);
        treeHeap.insert(69);
    }
}
