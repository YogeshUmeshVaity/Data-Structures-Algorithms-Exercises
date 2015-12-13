package com.company;

/**
 * The priority queue shown in Listing 4.6 features fast removal of the high-prior-
 * ity item but slow insertion of new items. Write a program with a revised
 * PriorityQ class that has fast O(1) insertion time but slower removal of the high-
 * priority item. Include a method that displays the contents of the priority
 * queue, as suggested in Programming Project 4.1.
 */

class PriorityQ {
    // array in sorted order, from max at 0 to min at size-1
    private int maxSize;
    private long[] queArray;
    private int nItems;

    //-------------------------------------------------------------
    public PriorityQ(int s)          // constructor
    {
        maxSize = s;
        queArray = new long[maxSize];
        nItems = 0;
    }

    //-------------------------------------------------------------
    public void insert(long item)    // insert item
    {
        queArray[nItems++] = item;
    }  // end insert()

    //-------------------------------------------------------------
    // remove minimum item
    public long remove() {
        int tempIndex = 0;
        // find the minimum item
        for (int i = 1; i < nItems; i++) {
            if (queArray[tempIndex] > queArray[i]) {
                tempIndex = i;
            }
        }
        // store smallest item
        long smallest = queArray[tempIndex];
        // shift elements
        for (int i = tempIndex; i < nItems - 1; i++) {
            queArray[i] = queArray[i + 1];
        }
        nItems--;
        return smallest;

    }

    public void displayQueue() {
        System.out.println("displayQueue():");
        for(int i = 0; i < nItems; i++) {
            System.out.print(queArray[i] + " ");
        }
        System.out.println();
    }

    //-------------------------------------------------------------
    public long peekMin()            // peek at minimum item
    {
        int tempIndex = 0;
        // find the minimum item
        for (int i = 1; i < nItems; i++) {
            if (queArray[tempIndex] > queArray[i]) {
                tempIndex = i;
            }
        }
        return queArray[tempIndex];
    }

    //-------------------------------------------------------------
    public boolean isEmpty()         // true if queue is empty
    {
        return (nItems == 0);
    }

    //-------------------------------------------------------------
    public boolean isFull()          // true if queue is full
    {
        return (nItems == maxSize);
    }
//-------------------------------------------------------------
}  // end class PriorityQ

////////////////////////////////////////////////////////////////
public class Main {
    public static void main(String[] args) {
        PriorityQ thePQ = new PriorityQ(6);
        thePQ.insert(30);
        thePQ.insert(50);
        thePQ.insert(10);
        thePQ.insert(40);
        thePQ.insert(20);
        thePQ.insert(15);

        System.out.println("peekMin(): " + thePQ.peekMin());

        thePQ.displayQueue();

        System.out.println("pop() all:");
        while (!thePQ.isEmpty()) {
            long item = thePQ.remove();
            System.out.print(item + " ");  // 10, 20, 30, 40, 50
        }  // end while
        System.out.println("");
    }  // end main()
//-------------------------------------------------------------
}  // end class PriorityQApp
////////////////////////////////////////////////////////////////
