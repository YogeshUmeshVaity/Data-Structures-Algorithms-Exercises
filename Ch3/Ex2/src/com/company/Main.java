package com.company;

// insertSort.java
// demonstrates insertion sort
// to run this program: C>java InsertSortApp
//--------------------------------------------------------------
class ArrayIns
{
    private long[] a;                 // ref to array a
    private int nElems;               // number of data items

    public float median() {
        insertionSort();
        float median = 0;
        int medianIndex = (nElems - 1)/2;
        if(nElems % 2 == 0) {
            // If the number of values is even, the median is the average of the two middle values.
            median = (float) (a[medianIndex] + a[medianIndex + 1]) / 2;
            return median;
        } else {
            // If the number of values is odd, the median is the middle value
            return a[medianIndex];
        }

    }
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
    public void insertionSort()
    {
        int in, out;

        for(out=1; out<nElems; out++)     // out is dividing line
        {
            long temp = a[out];            // remove marked item
            in = out;                      // start shifts at out
            while(in>0 && a[in-1] >= temp) // until one is smaller,
            {
                a[in] = a[in-1];            // shift item to right
                --in;                       // go left one position
            }
            a[in] = temp;                  // insert marked item
        }  // end for
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

        arr.insert(77);               // insert 10 items
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);
        arr.insert(111);

        arr.display();                // display items

        arr.insertionSort();          // insertion-sort them

        arr.display();                // display them again

        System.out.println("Median = " + arr.median());
    }  // end main()
}  // end class InsertSortApp