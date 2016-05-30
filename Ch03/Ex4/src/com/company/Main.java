package com.company;


// bubbleSort.java
// demonstrates bubble sort
// to run this program: C>java BubbleSortApp
////////////////////////////////////////////////////////////////
class ArrayBub
{
    private long[] a;                 // ref to array a
    private int nElems;               // number of data items
    //--------------------------------------------------------------
    public ArrayBub(int max)          // constructor
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
    public void bubbleSort()
    {
        int out, in;

        for(out=nElems-1; out>1; out--)   // outer loop (backward)
            for(in=0; in<out; in++)        // inner loop (forward)
                if( a[in] > a[in+1] )       // out of order?
                    swap(in, in+1);          // swap them
    }  // end bubbleSort()

    public void oddEvenSort() {
        for(int out = 0; out < (nElems/2); out++) {
            for(int odd = 1; odd < nElems; odd += 2) {
                if((odd + 1) != nElems)
                    if(a[odd] > a[odd + 1]) swap(odd, odd + 1);
            }
            for(int even = 0; even < nElems; even += 2) {
                if((even + 1) != nElems)
                    if(a[even] > a[even + 1]) swap(even, even + 1);
            }
        }
    }
    //--------------------------------------------------------------
    private void swap(int one, int two)
    {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
//--------------------------------------------------------------
}  // end class ArrayBub
////////////////////////////////////////////////////////////////
class Main
{
    public static void main(String[] args)
    {
        int maxSize = 100;            // array size
        ArrayBub arr;                 // reference to array
        arr = new ArrayBub(maxSize);  // create the array

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
        arr.insert(54);
        arr.insert(96);

        arr.display();                // display items

        arr.oddEvenSort();             // bubble sort them

        arr.display();                // display them again
    }  // end main()
}  // end class BubbleSortApp
////////////////////////////////////////////////////////////////