package com.company;

/**
 * Created by try on 2/12/15.
 */

// selectSort.java
// demonstrates selection sort
// to run this program: C>java SelectSortApp
////////////////////////////////////////////////////////////////
class ArraySel
{
    private long[] a;                 // ref to array a
    private int nElems;               // number of data items
    //--------------------------------------------------------------
    public ArraySel(int max)          // constructor
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
    public void selectionSort()
    {
        int out, in, min;

        for(out=0; out<nElems-1; out++)   // outer loop
        {
            min = out;                     // minimum
            for(in=out+1; in<nElems; in++) // inner loop
                if(a[in] < a[min] )         // if min greater,
                    min = in;               // we have a new min
            swap(out, min);                // swap them
        }  // end for(out)
    }  // end selectionSort()
    //--------------------------------------------------------------
    private void swap(int one, int two)
    {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
//--------------------------------------------------------------
}  // end class ArraySel
////////////////////////////////////////////////////////////////
class SelectSort
{
    public static void main(String[] args)
    {
        int maxSize = 10000;            // array size
        ArraySel arr;                 // reference to array
        arr = new ArraySel(maxSize);  // create the array

        for(int i = 0; i < maxSize; i++) {
            long n = (long) (Math.random() * (maxSize - 1));
            arr.insert(n);
        }

        long t1 = System.currentTimeMillis();
        arr.selectionSort();             // bubble sort them
        long t2 = System.currentTimeMillis();
        // results : 146, 135, 133 (max 10000 items)
        System.out.println("Time in milliseconds : " + (t2 - t1));


        maxSize = 100000;            // array size
        ArraySel arr2;                 // reference to array
        arr2 = new ArraySel(maxSize);  // create the array

        for(int i = 0; i < maxSize; i++) {
            long n = (long) (Math.random() * (maxSize - 1));
            arr2.insert(n);
        }

        t1 = System.currentTimeMillis();
        arr2.selectionSort();             // bubble sort them
        t2 = System.currentTimeMillis();
        // results : 12260, 12105, 12191 (max 100000 items)
        System.out.println("Time in milliseconds : " + (t2 - t1));




    }  // end main()
}  // end class SelectSortApp
////////////////////////////////////////////////////////////////