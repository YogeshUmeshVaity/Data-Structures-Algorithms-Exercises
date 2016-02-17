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

    private long[] input = {492, 239, 124, 111, 278, 159, 987};


    public void sort() {
        for (int i = 2; i >= 0; i--) {

            // Initialize 10 groups
            List<LinkedList<Long>> groups = new LinkedList<>();
            for (int k = 0; k < 10; k++) {
                groups.add(k, new LinkedList<Long>());
            }

            // Disassemble
            for (int j = 0; j < input.length; j++) {
                String key = String.valueOf(input[j]);
                char digit = key.charAt(i);
                int integerDigit = Integer.parseInt(Character.toString(digit));
                Long currentElement = input[j];
                // Get the list from the group and add element
                groups.get(integerDigit).add(currentElement);

            }

            // Reassemble
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
