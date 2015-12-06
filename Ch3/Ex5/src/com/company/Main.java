package com.company;

// insertSort.java
// demonstrates insertion sort
// to run this program: C>java InsertSortApp
//--------------------------------------------------------------
class ArrayIns
{
    private long[] a;                 // ref to array a
    private int nElems;               // number of data items
    //--------------------------------------------------------------
    public ArrayIns(int max)          // constructor
    {
        a = new long[max];                 // create the array
        nElems = 0;                        // no items yet
    }
    //--------------------------------------------------------------
    public void insert(long value)    // put element into array
    {
        a[nElems] = value;             // insert it
        nElems++;                      // increment size
    }
    //--------------------------------------------------------------
    public void display()             // displays array contents
    {
        for(int j=0; j<nElems; j++)       // for each element,
            System.out.print(a[j] + " ");  // display it
        System.out.println("");
    }
    //--------------------------------------------------------------

    /**
     * For inversely sorted array it requires 63 copies and 45 comparisons which is N*(N - 1)/2
     * So for it does show O(N*N) efficiency
     * For almost-sorted data, it requires much less number of copies and comparisons when
     * compared to selection sort and bubble sort.
     */
    public void insertionSort()
    {
        int in, out;
        int copies = 0, comparisons = 0;

        for(out=1; out<nElems; out++)     // out is dividing line
        {
            long temp = a[out];            // remove marked item
            copies++;
            in = out;                      // start shifts at out
            while(in>0) // until one is smaller,
            {
                comparisons++;
                if(a[in-1] >= temp) {
                    a[in] = a[in-1];            // shift item to right
                    copies++;
                    --in;
                } else break;
                                      // go left one position
            }
            a[in] = temp;                  // insert marked item
            copies++;
        }  // end for
        System.out.println("Total Copies : " + copies);
        System.out.println("Total Comparisons : " + comparisons);

    }  // end insertionSort()
//--------------------------------------------------------------
}  // end class ArrayIns
////////////////////////////////////////////////////////////////
class Main
{
    public static void main(String[] args)
    {
        int maxSize = 100;            // array size
        ArrayIns arr;                 // reference to array
        arr = new ArrayIns(maxSize);  // create the array

        arr.insert(9);               // insert 10 items
        arr.insert(0);
        arr.insert(1);
        arr.insert(2);
        arr.insert(3);
        arr.insert(4);
        arr.insert(5);
        arr.insert(6);
        arr.insert(7);
        arr.insert(8);

        arr.display();                // display items

        arr.insertionSort();          // insertion-sort them

        arr.display();                // display them again
    }  // end main()
}  // end class InsertSortApp