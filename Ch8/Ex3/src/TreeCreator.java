import java.util.Arrays;

/**
 * Accepts nodes and creates trees.
 */
public class TreeCreator {
    private Node[] nodes;
    private int forestIndex;

    public TreeCreator(int numNodes) {
        nodes = new Node[numNodes];
        forestIndex = 0;
    }

    public boolean add(Node node) {
        if (forestIndex < nodes.length) {
            nodes[forestIndex++] = node;
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

        return mainTree;
    }

    private void createTreeRecursively(Node root, int rootIndex) {
        if(rootIndex * 2 > nodes.length - 1) {
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
