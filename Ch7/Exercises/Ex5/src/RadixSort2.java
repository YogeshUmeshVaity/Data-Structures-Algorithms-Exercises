import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by try on 19/2/16.
 */
public class RadixSort2 {

    private static final int RADIX = 2;

    public int[] radixSort(int[] arrayToSort) {
        // Initialize the number of group according to radix.
        LinkedList[] groups = new LinkedList[RADIX];
        for(int i = 0; i < groups.length; i++) {
            groups[i] = new LinkedList<Integer>();
        }

        boolean maxDigits = false;
        int temporary = -1;
        int digitPosition = 1;
        while (!maxDigits) {
            maxDigits = true;
            for (int element : arrayToSort) {
                temporary = element / digitPosition;
                groups[temporary % RADIX].add(element);
                if(maxDigits && temporary > 0) {
                    maxDigits = false;
                }
            }

            int index = 0;
            for (LinkedList group : groups) {
                Iterator<Integer> groupIterator = group.iterator();
                while (groupIterator.hasNext()) {
                    arrayToSort[index++] = groupIterator.next();
                }
            }
            for(int i = 0; i < groups.length; i++) {
                groups[i].clear();
            }
            digitPosition = RADIX * digitPosition;
        }
        return arrayToSort;
    }

    public static void main(String[] args) {
        RadixSort2 radixSort2 = new RadixSort2();
        int[] output = radixSort2.radixSort(
                new int[] {49282, 39, 124, 1, 2784, 15923, 6767987});
        System.out.println(Arrays.toString(output));
    }
}
