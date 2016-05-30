/**
 * Compares all the sort algorithm times
 */
public class ShellQuickComparator {
    public static void main(String[] args) {
        // maxSize value should be in 9 for format e.g. 9, 99, 999, ... to be able to calculate
        // random numbers properly.
        final int maxSize = 99;
        // Create array with same items for all tests
        long[] testArray = new long[maxSize];
        for (int i = 0; i < maxSize; i++) {
            int item = (int) (Math.random() * maxSize);
            testArray[i] = item;
        }

        // BubbleSort
        BubbleSort bubbleSort = new BubbleSort(maxSize);
        for (int i = 0; i < maxSize; i++) {
            bubbleSort.insert(testArray[i]);
        }
        System.out.println("Testing BubbleSort for " + maxSize + " Items...");
        long t1 = System.currentTimeMillis();
        bubbleSort.bubbleSort();
        long t2 = System.currentTimeMillis();
        System.out.println("BubbleSort time : " + (t2 - t1) + " ms \n");

        // SelectSort
        SelectSort selectSort = new SelectSort(maxSize);
        for (int i = 0; i < maxSize; i++) {
            selectSort.insert(testArray[i]);
        }
        System.out.println("Testing SelectSort for " + maxSize + " Items...");
        long t3 = System.currentTimeMillis();
        selectSort.selectionSort();
        long t4 = System.currentTimeMillis();
        System.out.println("SelectSort time : " + (t4 - t3) + " ms \n");

        // InsertSort
        InsertSort insertSort = new InsertSort(maxSize);
        for (int i = 0; i < maxSize; i++) {
            insertSort.insert(testArray[i]);
        }
        System.out.println("Testing InsertSort for " + maxSize + " Items...");
        long t5 = System.currentTimeMillis();
        insertSort.insertionSort();
        long t6 = System.currentTimeMillis();
        System.out.println("InsertSort time : " + (t6 - t5) + " ms \n");

        // ShellSort
        ShellSort shellSort = new ShellSort(maxSize);
        for (int i = 0; i < maxSize; i++) {
            shellSort.insert(testArray[i]);
        }
        System.out.println("Testing ShellSort for " + maxSize + " Items...");
        long t7 = System.currentTimeMillis();
        shellSort.shellSort();
        long t8 = System.currentTimeMillis();
        System.out.println("ShellSort time : " + (t8 - t7) + " ms \n");

        // QuickSort2
        QuickSort2 quickSort2 = new QuickSort2(maxSize);
        for (int i = 0; i < maxSize; i++) {
            quickSort2.insert(testArray[i]);
        }
        System.out.println("Testing QuickSort2 for " + maxSize + " Items...");
        long t9 = System.currentTimeMillis();
        quickSort2.quickSort();
        long t10 = System.currentTimeMillis();
        System.out.println("QuickSort2 time : " + (t10 - t9) + " ms \n");

        // QuickSort3
        QuickSort3 quickSort3 = new QuickSort3(maxSize);
        for (int i = 0; i < maxSize; i++) {
            quickSort3.insert(testArray[i]);
        }
        System.out.println("Testing QuickSort3 for " + maxSize + " Items...");
        long t11 = System.currentTimeMillis();
        quickSort3.quickSort();
        long t12 = System.currentTimeMillis();
        System.out.println("QuickSort3 time : " + (t12 - t11) + " ms \n");
    }
}

/**
 * Results:
 * <p>
 * <p>
 * Testing BubbleSort for 99 Items...
 * BubbleSort time : 2 ms
 * <p>
 * Testing SelectSort for 99 Items...
 * SelectSort time : 0 ms
 * <p>
 * Testing InsertSort for 99 Items...
 * InsertSort time : 1 ms
 * <p>
 * Testing ShellSort for 99 Items...
 * ShellSort time : 0 ms
 * <p>
 * Testing QuickSort2 for 99 Items...
 * QuickSort2 time : 0 ms
 * <p>
 * Testing QuickSort3 for 99 Items...
 * QuickSort3 time : 0 ms
 * <p>
 * <p>
 * Testing BubbleSort for 999 Items...
 * BubbleSort time : 12 ms
 * <p>
 * Testing SelectSort for 999 Items...
 * SelectSort time : 8 ms
 * <p>
 * Testing InsertSort for 999 Items...
 * InsertSort time : 11 ms
 * <p>
 * Testing ShellSort for 999 Items...
 * ShellSort time : 0 ms
 * <p>
 * Testing QuickSort2 for 999 Items...
 * QuickSort2 time : 1 ms
 * <p>
 * Testing QuickSort3 for 999 Items...
 * QuickSort3 time : 2 ms
 * <p>
 * <p>
 * Testing BubbleSort for 9999 Items...
 * BubbleSort time : 284 ms
 * <p>
 * Testing SelectSort for 9999 Items...
 * SelectSort time : 139 ms
 * <p>
 * Testing InsertSort for 9999 Items...
 * InsertSort time : 50 ms
 * <p>
 * Testing ShellSort for 9999 Items...
 * ShellSort time : 14 ms
 * <p>
 * Testing QuickSort2 for 9999 Items...
 * QuickSort2 time : 24 ms
 * <p>
 * Testing QuickSort3 for 9999 Items...
 * QuickSort3 time : 12 ms
 * <p>
 * <p>
 * Testing BubbleSort for 99999 Items...
 * BubbleSort time : 24813 ms
 * <p>
 * Testing SelectSort for 99999 Items...
 * SelectSort time : 11766 ms
 * <p>
 * Testing InsertSort for 99999 Items...
 * InsertSort time : 2101 ms
 * <p>
 * Testing ShellSort for 99999 Items...
 * ShellSort time : 24 ms
 * <p>
 * Testing QuickSort2 for 99999 Items...
 * QuickSort2 time : 22 ms
 * <p>
 * Testing QuickSort3 for 99999 Items...
 * QuickSort3 time : 19 ms
 */