import java.util.Arrays;
import java.util.LinkedList;

/** Implements radix sort for any radix */
public class RadixSort2 {

    private static final int RADIX = 2;

    public int[] radixSort(int[] arrayToSort) {
        // Initialize the number of group according to radix.
        LinkedList[] groups =  new LinkedList[RADIX];
        for(int i = 0; i < groups.length; i++) {
            LinkedList<Integer> group = new LinkedList<>();
            groups[i] = group;
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
                for (Object integer : group) {
                    arrayToSort[index++] = (int) integer;
                }
            }
            for (LinkedList group : groups) {
                group.clear();
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
