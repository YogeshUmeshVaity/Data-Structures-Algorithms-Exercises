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

    /**
     * Encodes the specified message into the Huffman tree.
     *
     * @param message is the text message to be compressed.
     */
    public void encode(String message) {
        Map<Character, Integer> frequencyTable = createFrequencyTable(message);
        InsertOneNodeTrees(frequencyTable);
        int queSize = treeQueue.size();
//        for (int i = 0; i < queSize; i++) {
//            treeQueue.remove().displayTree();
//        }
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

        createCodeTable(treeQueue.peek().getRoot(), "");
        System.out.println("space :" + codeTable[(int) ' ']);
        System.out.println("E: " + codeTable[(int) 'E']);
        System.out.println("S: " + codeTable[(int) 'S']);
        System.out.println("S: " + codeTable[(int) 'A']);
        System.out.println("T: " + codeTable[(int) 'T']);
        System.out.println("U: " + codeTable[(int) 'U']);

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

    public void createCodeTable(Node currentNode, String sequence) {
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
        tree.encode("SUSIE SAYS IT IS EASY.");
        tree.displayTree();
    }
}
