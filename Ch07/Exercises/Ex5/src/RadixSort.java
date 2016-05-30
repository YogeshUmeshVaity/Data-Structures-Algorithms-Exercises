import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Implement a radix sort as described in the last section of this chapter. It should
 * handle variable amounts of data and variable numbers of digits in the key. You
 * could make the number-base variable as well (so it can be something other
 * than 10), but it will be hard to see what’s happening unless you develop a
 * routine to print values in different bases.
 */

public class RadixSort {

    private long[] input = {49282, 39, 124, 1, 2784, 15923, 6767987};

    /**
     * Sorts elements of an array using radix sort.
     */
    public void sort() {
        int maxDigits = calculateMaxDigits();
        for (int digitPosition = maxDigits - 1; digitPosition >= 0; digitPosition--) {
            List<LinkedList<Long>> groups = makeTenGroups();
            // Arrange elements into 10 groups
            disassemble(maxDigits, digitPosition, groups);
            // Copy elements from groups back into the array.
            reassemble(groups);
        }
    }

    /**
     * Initializes 10 groups to store the keys into.
     * @return Returns a List of 10 groups.
     */
    private List<LinkedList<Long>> makeTenGroups() {
        List<LinkedList<Long>> groups = new LinkedList<>();
        for (int k = 0; k < 10; k++) {
            groups.add(k, new LinkedList<Long>());
        }
        return groups;
    }

    /**
     * Sub-sorts the elements into groups.
     * @param maxDigits is maximum digits in a number in the input array.
     * @param digitPosition is the current position of the digits being disassembled.
     * @param groups into which the numbers will be categorized.
     */
    private void disassemble(int maxDigits, int digitPosition, List<LinkedList<Long>> groups) {
        for (int j = 0; j < input.length; j++) {
            String key = String.valueOf(input[j]);
            // Prepend 0, if the key has fewer digits.
            while (key.length() != maxDigits) {
                key = "0" + key;
            }
            char digit = key.charAt(digitPosition);
            int integerDigit = Integer.parseInt(Character.toString(digit));
            Long currentElement = input[j];
            // Get the list from the group and add element
            groups.get(integerDigit).add(currentElement);
        }
    }

    /**
     * Copies the numbers from groups back to the input array.
     * @param groups are where the numbers will be copied from.
     */
    private void reassemble(List<LinkedList<Long>> groups) {
        Iterator<LinkedList<Long>> groupsIterator = groups.iterator();
        int index = 0;
        while (groupsIterator.hasNext()) {
            LinkedList<Long> singleGroup = groupsIterator.next();
            Iterator<Long> singleGroupIterator = singleGroup.iterator();
            while (singleGroupIterator.hasNext()) {
                Long currentElement = singleGroupIterator.next();
                input[index++] = currentElement;
            }
        }
    }

    /**
     * Calculates and returns maximum digits in a single element of the input array.
     */
    private int calculateMaxDigits() {
        int maxDigits = 0;
        for(int i = 0; i < input.length; i++) {
            if(String.valueOf(input[i]).length() > maxDigits) {
                maxDigits = String.valueOf(input[i]).length();
            }
        }
        return maxDigits;
    }

    public void display() {
        System.out.println(Arrays.toString(input));
    }

    public static void main(String[] args) {
        RadixSort radixSort = new RadixSort();
        radixSort.sort();
        radixSort.display();
    }
}
