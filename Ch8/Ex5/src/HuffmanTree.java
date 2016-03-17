import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Encodes the given string message into Huffman binary tree and decodes back from the binary bits.
 */
public class HuffmanTree {
    private PriorityQueue<Tree> treeQueue = new PriorityQueue<>(new Tree());

    // Table for holding ASCII character codes and their binary representations.
    private String[] codeTable = new String[256];

    int binaryMessageIndex = 0;

    /**
     * Encodes the specified message into the Huffman tree.
     *
     * @param message is the text message to be compressed.
     */
    public String encode(String message) {
        Map<Character, Integer> frequencyTable = createFrequencyTable(message);
        InsertOneNodeTrees(frequencyTable);
        createLargerTree();
        createCodeTable(treeQueue.peek().getRoot(), "");
        return encodeToBinary(message);
    }

    private void createLargerTree() {
        while (treeQueue.size() > 1) {
            Tree leftTree = treeQueue.remove();
            Tree rightTree = treeQueue.remove();
            int totalFrequency =
                    leftTree.getRoot().getFrequency() + rightTree.getRoot().getFrequency();
            Node newNode = new Node(null, totalFrequency);
            newNode.setLeftChild(leftTree.getRoot());
            newNode.setRightChild(rightTree.getRoot());
            Tree newTree = new Tree();
            newTree.setRoot(newNode);
            treeQueue.add(newTree);
        }
    }

    /**
     * Decodes the specified binary message back to String
     */
    public String decode(String binaryMessage) {
        StringBuilder stringMessage = new StringBuilder();
        Tree rootTree = treeQueue.peek();
        while (binaryMessageIndex < binaryMessage.length()) {
            stringMessage.append(getCharacter(rootTree.getRoot(), binaryMessage));
        }
        return stringMessage.toString();
    }

    /**
     * For each character you start at the root. If you see a 0 bit, you go left to the next node,
     * and if you see a 1 bit, you go right.
     */
    private char getCharacter(Node root, String binaryMessage) {
        if (root.getLeftChild() == null && root.getRightChild() == null) {
            return root.getCharacter();
        } else {
            if (binaryMessage.charAt(binaryMessageIndex) == '0') {
                binaryMessageIndex++;
                return getCharacter(root.getLeftChild(), binaryMessage);
            } else {
                binaryMessageIndex++;
                return getCharacter(root.getRightChild(), binaryMessage);
            }
        }
    }

    private String encodeToBinary(String message) {
        StringBuilder binaryMessage = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            int charIndex = (int) message.charAt(i);
            binaryMessage.append(codeTable[charIndex]);
        }
        return binaryMessage.toString();
    }

    /**
     * Inserts one-node trees into treeQueue.
     *
     * @param frequencyTable is table from where characters and their respective frequencies are stored.
     */
    private void InsertOneNodeTrees(Map<Character, Integer> frequencyTable) {
        for (Map.Entry<Character, Integer> entry : frequencyTable.entrySet()) {
            char character = entry.getKey();
            int frequency = entry.getValue();
            Node node = new Node(character, frequency);
            Tree oneNodeTree = new Tree();
            oneNodeTree.setRoot(node);
            treeQueue.add(oneNodeTree);
        }
    }

    private void createCodeTable(Node currentNode, String sequence) {
        if (currentNode.getLeftChild() == null && currentNode.getRightChild() == null) {
            char currentTreeChar = currentNode.getCharacter();
            int charIndex = (int) currentTreeChar;
            codeTable[charIndex] = sequence;
            return;
        }
        createCodeTable(currentNode.getLeftChild(), sequence + "0");
        createCodeTable(currentNode.getRightChild(), sequence + "1");
    }

    private Map<Character, Integer> createFrequencyTable(String message) {
        Map<Character, Integer> frequencyTable = new HashMap<Character, Integer>();
        for (int i = 0; i < message.length(); i++) {
            char currentChar = message.charAt(i);
            // If character already exist in map, increase it's frequency. Else add new character.
            if (frequencyTable.containsKey(currentChar)) {
                Integer currentCharFrequency = frequencyTable.get(currentChar);
                frequencyTable.put(currentChar, currentCharFrequency + 1);
            } else {
                frequencyTable.put(currentChar, 1);
            }
        }

        return frequencyTable;
    }

    public void displayTree() {
        treeQueue.peek().displayTree();
    }

    public static void main(String[] args) {
        HuffmanTree tree = new HuffmanTree();
        System.out.println(tree.encode("SUSIE SAYS IT IS EASY."));
        System.out.println();
        tree.displayTree();
        System.out.println();
        String textMessage =
                tree.decode(tree.encode("SUSIE SAYS IT IS EASY."));
        System.out.println(textMessage);
    }
}
