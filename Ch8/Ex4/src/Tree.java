import java.util.Stack;

/**
 * A binary tree
 */
public class Tree {
    private Node root;

    private StringBuilder inorderOutput = new StringBuilder();

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
        System.out.println(
                "......................................................");
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
        System.out.println(
                "......................................................");
    }

    public void preOrder(Node localRoot) {
        if (localRoot != null) {
            System.out.print(localRoot + " ");
            preOrder(localRoot.getLeftChild());
            preOrder(localRoot.getRightChild());
        }
    }

    public void inorder(Node localRoot) {
        recurseInorder(localRoot);
        System.out.print(inorderOutput);
    }

    public void recurseInorder(Node localRoot) {
        if (localRoot != null) {
            inorderOutput.append("(");
            recurseInorder(localRoot.getLeftChild());
            inorderOutput.setLength(inorderOutput.length() - 1);
            inorderOutput.append(localRoot + " ");
            inorderOutput.setLength(inorderOutput.length() - 1);
            recurseInorder(localRoot.getRightChild());
            inorderOutput.append(")");
        }
    }

    public void postOrder(Node localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.getLeftChild());
            postOrder(localRoot.getRightChild());
            System.out.print(localRoot + " ");
        }
    }
}
