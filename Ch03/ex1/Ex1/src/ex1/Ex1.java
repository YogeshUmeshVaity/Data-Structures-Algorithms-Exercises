/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.lang.Override;

class ArrayBub {
    private long[] a;                 // ref to array a
    private int nElems;               // number of data items
//--------------------------------------------------------------
    @Override
    public ArrayBub(int max) // constructor
    {
        a = new long[max];                 // create the array
        nElems = 0;                        // no items yet
    }
//--------------------------------------------------------------

    public void insert(long value) // put element into array
    {
        a[nElems] = value;             // insert it
        nElems++;                      // increment size
    }
//--------------------------------------------------------------

    public void display() // displays array contents
    {
        for (int j = 0; j < nElems; j++) // for each element,
        {
            System.out.print(a[j] + " ");  // display it
        }
        System.out.println("");
    }
//--------------------------------------------------------------

    public void bubbleSort() {
        int out, in, out2, in2;

        for (out = nElems - 1; out > 1; out--) // outer loop (backward)
        {
            for(out2 = in2; out2 < out; out2++)
            {
                for (in = 0; in < out; in++) // inner loop (forward)
                {
                    if (a[in] > a[in + 1]) // out of order?
                    {
                        swap(in, in + 1);          // swap them
                    }
                }
                for (in2 = in - 1; in2 > out2; in2--)
                {
                    if (a[in2] < a[in2 - 1])
                    {
                        swap(in2, in2 - 1);
                    }
                }
            }
        }

    }  // end bubbleSort()
//--------------------------------------------------------------

    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
//--------------------------------------------------------------
}  // end class ArrayBub
////////////////////////////////////////////////////////////////

class Ex1 {

    public static void main(String[] args) {
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

        arr.display();                // display items

        arr.bubbleSort();             // bubble sort them

        arr.display();                // display them again
    }  // end main()
}  // end class BubbleSortApp
////////////////////////////////////////////////////////////////
