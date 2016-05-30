import java.util.Comparator;
import java.util.Stack;

/**
 * A binary tree
 */
public class Tree implements Comparator<Tree> {
    private Node root;

    public void setRoot(Node root) {
        this.root = root;
    }

    public void addToLeft(Node node) {
        root.setLeftChild(node);
    }

    public void addToRight(Node node) {
        root.setRightChild(node);
    }

    public Node getRoot() {
        return root;
    }

    public void displayTree() {
        Stack<Node> globalStack = new Stack<>();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        while (!isRowEmpty) {
            Stack<Node> localStack = new Stack<>();
            isRowEmpty = true;

            for (int j = 0; j < nBlanks; j++)
                System.out.print(' ');

            while (!globalStack.isEmpty()) {
                Node temp = (Node) globalStack.pop();
                if (temp != null) {
                    System.out.print(temp);
                    localStack.push(temp.getLeftChild());
                    localStack.push(temp.getRightChild());

                    if (temp.getLeftChild() != null ||
                            temp.getRightChild() != null)
                        isRowEmpty = false;
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++)
                    System.out.print(' ');
            }  // end while globalStack not empty
            System.out.println();
            nBlanks /= 2;
            while (!localStack.isEmpty())
                globalStack.push(localStack.pop());
        }  // end while isRowEmpty is false
    }

    @Override
    public int compare(Tree tree1, Tree tree2) {
        int frequency1 = tree1.getRoot().getFrequency();
        int frequency2 = tree2.getRoot().getFrequency();

        return (frequency1 < frequency2 ? -1 : (frequency1 == frequency2 ? 0 : 1));
    }
}
