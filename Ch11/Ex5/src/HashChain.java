import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

////////////////////////////////////////////////////////////////
class HashTable {
    private Tree[] hashArray;   // array of lists
    private int arraySize;

    // -------------------------------------------------------------
    public HashTable(int size)        // constructor
    {
        arraySize = size;
        hashArray = new Tree[arraySize];  // create array
        for (int j = 0; j < arraySize; j++)          // fill array
            hashArray[j] = new Tree();     // with lists
    }

    // -------------------------------------------------------------
    public void displayTable() {
        for (int j = 0; j < arraySize; j++) // for each cell,
        {
            System.out.print(j + ". "); // display cell number
            hashArray[j].showTree(); // display list
            System.out.println();
        }
    }

    // -------------------------------------------------------------
    public int hashFunc(int key)      // hash function
    {
        return key % arraySize;
    }

    // -------------------------------------------------------------
    public void insert(int id)  // insert a link
    {
        // handle duplicates
        if (find(id) == -1) {
            int hashVal = hashFunc(id);   // hash the key
            hashArray[hashVal].insert(id); // insert at hashVal
        }

    }  // end insert()

    // -------------------------------------------------------------
    public int find(int key)         // find link
    {
        int hashVal = hashFunc(key);   // hash the key
        Node node = null;  // get link
        if (!hashArray[hashVal].isEmpty()) {
            node = hashArray[hashVal].find(key);
            if (node != null) {
                return node.iData;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }
// -------------------------------------------------------------
}  // end class HashTable

////////////////////////////////////////////////////////////////
class HashChainApp {
    public static void main(String[] args) throws IOException {
        int aKey;
        Node aDataItem;
        int size, n, keysPerCell = 100;
        // get sizes
        System.out.println("Enter size of hash table: ");
        size = getInt();
        System.out.print("Enter initial number of items: ");
        n = getInt();
        // make table
        HashTable theHashTable = new HashTable(size);

        for (int j = 0; j < n; j++)         // insert data
        {
            aKey = (int) (java.lang.Math.random() *
                    keysPerCell * size);
            theHashTable.insert(aKey);
        }
        while (true)                    // interact with user
        {
            System.out.print("Enter first letter of ");
            System.out.print("show, insert, or find: ");
            char choice = getChar();
            switch (choice) {
                case 's':
                    theHashTable.displayTable();
                    break;
                case 'i':
                    System.out.print("Enter key value to insert: ");
                    aKey = getInt();
                    theHashTable.insert(aKey);
                    break;
                case 'f':
                    System.out.print("Enter key value to find: ");
                    aKey = getInt();
                    int found = theHashTable.find(aKey);
                    if (found != -1)
                        System.out.println("Found " + aKey);
                    else
                        System.out.println("Could not find " + aKey);
                    break;
                default:
                    System.out.print("Invalid entry\n");
            }  // end switch
        }  // end while
    }  // end main()

    //--------------------------------------------------------------
    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }

    //-------------------------------------------------------------
    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

    //-------------------------------------------------------------
    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
//--------------------------------------------------------------
}  // end class HashChainApp
////////////////////////////////////////////////////////////////