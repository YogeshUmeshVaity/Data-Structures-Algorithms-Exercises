import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Encodes the given string message into Huffman binary tree and decodes back from the binary bits.
 */
public class HuffmanTree {
    private PriorityQueue<Tree> treeQueue = new PriorityQueue<>(new Tree());

    /**
     * Encodes the specified message into the Huffman tree.
     *
     * @param message is the text message to be compressed.
     */
    public void encode(String message) {
        Map<Character, Integer> frequencyTable = createFrequencyTable(message);
        InsertOneNodeTrees(frequencyTable);
        while(treeQueue.size() > 1) {
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
