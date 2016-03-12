import java.util.Stack;

/**
 * Parses the postfix algebraic expression and stores it as a binary tree
 */
public class PostfixParser {

    /**
     * Parses the postfix string and returns it in the form of a binary tree
     * @param postfix is the String to be parsed.
     */
    public Tree parse(String postfix) {
        Stack<Tree> treeStack = new Stack<>();

        char currentChar;
        Tree operand1, operand2, result;
        for(int i = 0; i < postfix.length(); i++) {
            currentChar = postfix.charAt(i);
            if(currentChar >= '0' && currentChar <= '9') {
                Tree oneNodeTree = new Tree();
                oneNodeTree.setRoot(new Node(currentChar));
                treeStack.push(oneNodeTree);
            } else {
                operand2 = treeStack.pop();
                operand1 = treeStack.pop();
                Tree operatorTree = new Tree();
                operatorTree.setRoot(new Node(currentChar));
                operatorTree.getRoot().setLeftChild(operand1.getRoot());
                operatorTree.getRoot().setRightChild(operand2.getRoot());
                treeStack.push(operatorTree);
            }
        }
        return treeStack.pop();
    }

    public static void main(String[] args) {
        PostfixParser parser = new PostfixParser();
        Tree postfixTree = parser.parse("369+*457+/-");
        postfixTree.displayTree();
        System.out.println("inorder(): ");
        postfixTree.inorder(postfixTree.getRoot());
        System.out.println("\npreOrder(): ");
        postfixTree.preOrder(postfixTree.getRoot());
        System.out.println("\npostOrder(): ");
        postfixTree.postOrder(postfixTree.getRoot());
    }
}
