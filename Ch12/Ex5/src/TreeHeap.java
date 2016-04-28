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
        return findLastNode(numNodes + 1);
    }

    public boolean insert(int key) {
        Node newNode = new Node(key);
        if(root == null) {
            root = newNode;
            numNodes++;
            return true;
        }
        String binaryPath = convertToBinary(numNodes + 1);
        Node nullNode = root;
        for(int i = 1; i < binaryPath.length(); i++) {
            if(binaryPath.charAt(i) == '0') {
                if(nullNode.getLeftChild() != null) {
                    nullNode = nullNode.getLeftChild();
                }
            } else {
                if (nullNode.getRightChild() != null) {
                    nullNode = nullNode.getRightChild();
                }
            }
        }
        if(nullNode.getLeftChild() == null) {
            nullNode.setLeftChild(newNode);
        } else {
            nullNode.setRightChild(newNode);
        }
        newNode.setParent(nullNode);
        trickleUp(newNode);
        numNodes++;
        return true;
    }

    public Node remove() {
        // If heap empty
        if(root == null) return null;

        // If root is the only element in heap
        if(root.getLeftChild() == null && root.getRightChild() == null) {
            Node savedRoot = root;
            root = null;
            numNodes--;
            return savedRoot;
        }

        Node removedNode= root;
        Node lastNode = findLastNode(numNodes);

        // Disconnect last node from it's parent
        if(lastNode.getParent().getLeftChild() == lastNode) {
            lastNode.getParent().setLeftChild(null);
        } else if(lastNode.getParent().getRightChild() == lastNode) {
            lastNode.getParent().setRightChild(null);
        }

        // Move last node to top(as root)
        lastNode.setLeftChild(removedNode.getLeftChild());
        lastNode.setRightChild(removedNode.getRightChild());
        lastNode.setParent(null);
        root = lastNode;
        trickleDown(root);
        numNodes--;
        return removedNode;
    }

    private void trickleDown(Node newFirstNode) {
        Node largerChild;
        int top = newFirstNode.getKey();
        while(newFirstNode.getLeftChild() != null || newFirstNode.getRightChild() != null) {
            Node leftChild = newFirstNode.getLeftChild();
            Node rightChild = newFirstNode.getRightChild();
            if(rightChild != null && leftChild.getKey() < rightChild.getKey()) {
                largerChild = rightChild;
            } else {
                largerChild = leftChild;
            }
            if(top >= largerChild.getKey()) break;
            newFirstNode.setKey(largerChild.getKey());
            newFirstNode = largerChild;
        }
        newFirstNode.setKey(top);
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
        System.out.println(treeHeap.remove());
        System.out.println(treeHeap.remove());
        System.out.println(treeHeap.remove());
        System.out.println(treeHeap.remove());
        System.out.println(treeHeap.remove());
        System.out.println(treeHeap.remove());
        System.out.println(treeHeap.remove());
        System.out.println(treeHeap.remove());
        System.out.println(treeHeap.remove());
        System.out.println(treeHeap.remove());

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
        System.out.println(treeHeap.remove());
        System.out.println(treeHeap.remove());
        System.out.println(treeHeap.remove());
        System.out.println(treeHeap.remove());
        System.out.println(treeHeap.remove());
        System.out.println(treeHeap.remove());
        System.out.println(treeHeap.remove());
        System.out.println(treeHeap.remove());
        System.out.println(treeHeap.remove());
        System.out.println(treeHeap.remove());
    }
}
