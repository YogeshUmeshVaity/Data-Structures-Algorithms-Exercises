// partition.java
// demonstrates partitioning an array
// to run this program: C>java PartitionApp
////////////////////////////////////////////////////////////////
class Partition
{
    private long[] theArray;          // ref to array theArray

    private int nElems;               // number of data items
    //--------------------------------------------------------------
    public Partition(int max)          // constructor
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

    public long getElement(int index) {
        return theArray[index];
    }
    //--------------------------------------------------------------
    public int size()                 // return number of items
    { return nElems; }
    //--------------------------------------------------------------
    public void display()             // displays array contents
    {
        System.out.print("A=");
        for(int j=0; j<nElems; j++)    // for each element,
            System.out.print(theArray[j] + " ");  // display it
        System.out.println("");
    }
    //--------------------------------------------------------------

    public long findMedian(int leftIndex, int rightIndex) {
        int middleIndex = (int)((rightIndex - leftIndex) / 2);
        return recurseFindMedian(leftIndex, rightIndex, middleIndex);

    }

    private long recurseFindMedian(int leftIndex, int rightIndex, int middleIndex) {
        int pivotIndex = partitionIt(leftIndex, rightIndex);
        // base case
        if(pivotIndex == middleIndex) {
            return theArray[pivotIndex];
        } else if(pivotIndex > middleIndex) {
            return recurseFindMedian(leftIndex, pivotIndex, middleIndex);
        } else
            return recurseFindMedian(pivotIndex, rightIndex, middleIndex);
    }

    public int partitionIt(int left, int right)
    {
        int leftPtr = left - 1;           // right of first elem
        int rightPtr = right;         // left of pivot
        while(true)
        {
            while(leftPtr < right &&       // find bigger item
                    theArray[++leftPtr] < theArray[right])
                ;  // (nop)

            while(rightPtr > left &&       // find smaller item
                    theArray[--rightPtr] > theArray[right])
                ;  // (nop)
            if(leftPtr >= rightPtr)        // if pointers cross,
                break;                      //    partition done
            else                           // not crossed, so
                swap(leftPtr, rightPtr);    //    swap elements
        }  // end while(true)
        swap(leftPtr, right);
        return leftPtr;                   // return partition
    }  // end partitionIt()
    //--------------------------------------------------------------
    public void swap(int dex1, int dex2)  // swap two elements
    {
        long temp;
        temp = theArray[dex1];             // A into temp
        theArray[dex1] = theArray[dex2];   // B into A
        theArray[dex2] = temp;             // temp into B
    }  // end swap()
//--------------------------------------------------------------
}  // end class Partition
////////////////////////////////////////////////////////////////
class PartitionApp
{
    public static void main(String[] args)
    {
        int maxSize = 9;             // array size
        Partition arr;                 // reference to array
        arr = new Partition(maxSize);  // create the array

        arr.insert(49);
        arr.insert(3);
        arr.insert(12);
        arr.insert(1);
        arr.insert(27);
        arr.insert(15);
        arr.insert(9);
        arr.insert(10);
        arr.insert(11);
        arr.display();                // display unsorted array

        System.out.println("Median is : " + arr.findMedian(0, arr.size() - 1));
    }  // end main()
}  // end class PartitionApp
////////////////////////////////////////////////////////////////