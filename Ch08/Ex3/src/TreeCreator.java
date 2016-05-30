import java.util.Arrays;

/**
 * Accepts nodes and creates trees.
 */
public class TreeCreator {
    private Node[] nodes;
    private int index;

    public TreeCreator(int numNodes) {
        nodes = new Node[numNodes];
        index = 0;
    }

    public boolean add(Node node) {
        if (index < nodes.length) {
            nodes[index++] = node;
            return true;
        } else {
            return false;
        }
    }

    public Tree createMainTree() {
        System.out.println(Arrays.toString(nodes));
        Tree mainTree = new Tree();
        // Set first node of array as root.
        mainTree.setRoot(nodes[0]);
        createTreeRecursively(mainTree.getRoot(), 1);

        // If number of nodes is even, need to be set last node manually to it's parent.
        if(nodes.length % 2 == 0) {
            int lastNodeIndex = nodes.length;
            int lastNodeParentIndex = (lastNodeIndex - 1) / 2;
            nodes[lastNodeParentIndex].setLeftChild(nodes[nodes.length - 1]);
        }

        return mainTree;
    }

    private void createTreeRecursively(Node root, int rootIndex) {
        if(rootIndex * 2 >= nodes.length) {
            return;
        } else {
            root.setLeftChild(nodes[2 * rootIndex - 1]);
            createTreeRecursively(root.getLeftChild(), 2 * rootIndex);
            root.setRightChild(nodes[2 * rootIndex]);
            createTreeRecursively(root.getRightChild(), 2 * rootIndex + 1);
        }
    }

    public static void main(String[] args) {
        final int numberOfNodes = 12;
        TreeCreator treeCreator = new TreeCreator(numberOfNodes);

        // Add characters starting from A which has ASCII value 65
        int charLimit = 65 + numberOfNodes;
        for (int i = 65; i < charLimit; i++) {
            // Make new node and add.
            Node newNode = new Node((char) i);
            treeCreator.add(newNode);
        }

        Tree mainTree = treeCreator.createMainTree();
        mainTree.displayTree();
    }
}
