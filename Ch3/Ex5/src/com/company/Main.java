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

        arr.display();                // display items

        arr.insertionSort();          // insertion-sort them

        arr.display();                // display them again
    }  // end main()
}  // end class InsertSortApp