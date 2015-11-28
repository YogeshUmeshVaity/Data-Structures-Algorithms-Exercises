// orderedArray.java
// demonstrates ordered array class
// to run this program: C>java OrderedApp
////////////////////////////////////////////////////////////////
class OrdArray
   {
   private long[] a;                 // ref to array a
   private int nElems;               // number of data items
   // moved curIn for accessing it in insert() and delete()
   private int curIn; 
   //-----------------------------------------------------------
   public OrdArray(int max)          // constructor
      {
      a = new long[max];             // create array
      nElems = 0;
      }
   //-----------------------------------------------------------
   public int size()
      { return nElems; }
   //-----------------------------------------------------------
   
   public void merge(long[] a, long[] b) {
      // determin bigger array
      int aLength = a.length;
      int bLength = b.length;
      int minimumLength = 0;
      int i = 0;
      for(; (i < aLength) && (i < bLength); i++) {
          copySmaller(a[i], b[i]);
      }
      if(aLength > bLength) {
        for(int j = i; j < aLength; j++) {
          insert(a[j]);
        }
      } else {
        for(int j = i; j < bLength; j++) {
          insert(b[j]);
        }
      }
   }
   
   private void copySmaller(long a, long b) {
      if(a <= b) insert(a);
        else insert(b);
   }
   
   public int find(long searchKey)
      {
      int lowerBound = 0;
      int upperBound = nElems-1;
      

      while(true)
         {
         curIn = (lowerBound + upperBound ) / 2;
         if(a[curIn]==searchKey)
            return curIn;              // found it
         else if(lowerBound > upperBound) {
            // curIn + 1 at this point is where the insertion
            // should be made.
            return nElems; // can't find it
         }
                         
         else                          // divide range
            {
            if(a[curIn] < searchKey)
               lowerBound = curIn + 1; // it's in upper half
            else
               upperBound = curIn - 1; // it's in lower half
            }  // end else divide range
         }  // end while
      }  // end find()
   //-----------------------------------------------------------
   public void insert(long value)    // put element into array
      {
      if(nElems == 0) { // take care of 0 index = 0 bug
        a[0] = value;
      }
      int j = find(value);
      if(j == nElems) { // if item not found
        j = curIn + 1; // insert position
      for(int k=nElems; k>j; k--)    // move bigger ones up
         a[k] = a[k-1];
      a[j] = value;                  // insert it
      nElems++;                      // increment size
      }  
      } // end insert()
      
   //-----------------------------------------------------------
   public boolean delete(long value)
      {
      int j = find(value);
      if(j==nElems)                  // can't find it
         return false;
      else                           // found it
         {
         for(int k=j; k<nElems; k++) // move bigger ones down
            a[k] = a[k+1];
         nElems--;                   // decrement size
         return true;
         }
      }  // end delete()
   //-----------------------------------------------------------
   public void display()             // displays array contents
      {
      for(int j=0; j<nElems; j++)       // for each element,
         System.out.print(a[j] + " ");  // display it
      System.out.println("");
      }
   //-----------------------------------------------------------
   }  // end class OrdArray
////////////////////////////////////////////////////////////////
class OrderedApp
   {
   public static void main(String[] args)
      {
      int maxSize = 100;             // array size
      OrdArray arr;                  // reference to array
      arr = new OrdArray(maxSize);   // create the array
      long[] a = { 2, 4, 6, 8, 10, 12 };
      long[] b = { 1, 3, 5, 7 };
      arr.merge(a, b);
      arr.display();
      }  // end main()
   }  // end class OrderedApp
