/**
 * Modify the shellSort.java program (Listing 7.1) so it prints the entire contents
 * of the array after completing each n-sort. The array should be small enough so
 * its contents fit on one line. Analyze these intermediate steps to see if the algorithm is
 * operating the way you think should.
 */
public class ShellSort {
    public static void main(String[] args) {
        int maxSize = 30;             // array size
        ArraySh arr;
        arr = new ArraySh(maxSize);   // create the array

        for(int i = 0; i < maxSize; i++) {
            int rnd = (int) (Math.random() * 99);
            arr.insert(rnd);
        }

        arr.display();                // display unsorted array
        System.out.println();
        arr.shellSort();              // shell sort the array
        //arr.display();                // display sorted array
    }  // end main()
}


class ArraySh {
    private long[] theArray;          // ref to array theArray
    private int nElems;               // number of data items

    //--------------------------------------------------------------
    public ArraySh(int max)           // constructor
    {
        theArray = new long[max];      // create the array
        nElems = 0;                    // no items yet
    }

    //--------------------------------------------------------------
    public void insert(long value)    // put element into array
    {
        theArray[nElems] = value;      // insert it
        nElems++;                      // increment size
    }

    //--------------------------------------------------------------
    public void display()             // displays array contents
    {
        System.out.print("A=");
        for (int j = 0; j < nElems; j++)    // for each element,
            System.out.print(theArray[j] + " ");  // display it
        System.out.println("");
    }

    //--------------------------------------------------------------
    public void shellSort() {
        int inner, outer;
        long temp;

        int h = 1;                     // find initial value of h
        while (h <= nElems / 3)
            h = h * 3 + 1;                // (1, 4, 13, 40, 121, ...)

        while (h > 0)                     // decreasing h, until h=1
        {
            // h-sort the file
            System.out.println("h = " + h);
            for (outer = h; outer < nElems; outer++) {
                temp = theArray[outer];
                inner = outer;
                // one subpass (eg 0, 4, 8)
                while (inner > h - 1 && theArray[inner - h] >= temp) {
                    theArray[inner] = theArray[inner - h];
                    inner -= h;
                }
                theArray[inner] = temp;
                //display();
            }
            display();
            h = (h - 1) / 3;              // decrease h
        }  // end while(h>0)
    }  // end shellSort()
//--------------------------------------------------------------
}  // end class ArraySh