/**
 * A collection of OneNodeTrees combined together in one tree
 */
public class Forest {
    private Tree[] forest;
    private int forestIndex;

    public Forest(int numTrees) {
        forest = new Tree[numTrees];
        forestIndex = 0;
    }

    public boolean add(Tree tree) {
        if(forestIndex < forest.length) {
            forest[forestIndex++] = tree;
            return true;
        } else {
            return false;
        }
    }

    public Tree createMainTree() {
        Tree firstTree = new Tree();
        firstTree.setRoot(new Node('+'));
        firstTree.addToLeft(forest[0].getRoot());
        firstTree.addToRight(forest[1].getRoot());
        forest[1] = firstTree;

        int mainTreeIndex = 0;
        Tree tempTree;
        for(mainTreeIndex = 2; mainTreeIndex < forest.length; mainTreeIndex++) {
            tempTree = new Tree();
            tempTree.setRoot(new Node('+'));
            tempTree.addToLeft(forest[mainTreeIndex - 1].getRoot());
            tempTree.addToRight(forest[mainTreeIndex].getRoot());
            forest[mainTreeIndex] = tempTree;
        }

        return forest[mainTreeIndex - 1];
    }

    public static void main(String[] args) {
        final int numberOfTrees = 6;
        Forest forest = new Forest(numberOfTrees);

        // Add characters starting from A which has ASCII value 65
        int charLimit = 65 + numberOfTrees;
        for(int i = 65; i < charLimit; i++) {
            // Make new node.
            Node newNode = new Node((char) i);
            // Add that node to Tree as a root.
            Tree newTree = new Tree();
            newTree.setRoot(newNode);
            // And add that one-node tree to forest(array)
            forest.add(newTree);
        }

        Tree mainTree = forest.createMainTree();
        mainTree.displayTree();
    }
}
