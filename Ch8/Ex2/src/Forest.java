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
        if (forestIndex < forest.length) {
            forest[forestIndex++] = tree;
            return true;
        } else {
            return false;
        }
    }

    public Tree createMainTree() {
        Tree tempTree;
        // Finished will be true when only one tree is left in the forest.
        boolean finished = false;
        while(!finished) {
            int tempIndex = 0;
            for (int i = 0; i < forestIndex; i += 2) {
                tempTree = new Tree();
                tempTree.setRoot(new Node('+'));
                tempTree.addToLeft(forest[i].getRoot());
                // When the number of nodes is odd, need to check for index out of bound.
                if(i + 1 < forestIndex) {
                    tempTree.addToRight(forest[i + 1].getRoot());
                }
                forest[tempIndex++] = tempTree;
            }
            forestIndex = tempIndex;
            if (forestIndex <= 1) {
                finished = true;
            }
        }
        return forest[0];

    }

    public static void main(String[] args) {
        final int numberOfTrees = 7;
        Forest forest = new Forest(numberOfTrees);

        // Add characters starting from A which has ASCII value 65
        int charLimit = 65 + numberOfTrees;
        for (int i = 65; i < charLimit; i++) {
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
