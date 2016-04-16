// Write a hash function to implement a digit-folding approach in the hash function (as described in the
// “Hash Functions” section of this chapter). Your program should work for any array size and any key length.
// Use linear probing. Accessing a group of digits in a number may be easier than you think. Does it matter if
// the array size is not a multiple of 10?

import java.io.*;


class DataItem {
    private int iData;


    public DataItem(int ii) {
        iData = ii;
    }


    public int getKey() {
        return iData;
    }

}


class HashTable {
    private DataItem[] hashArray;
    private int arraySize;
    private DataItem nonItem;

    public HashTable(int size) {
        arraySize = size;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1);
    }

    public void displayTable() {
        System.out.print("Table: ");
        for (int j = 0; j < arraySize; j++) {
            if (hashArray[j] != null)
                System.out.print(hashArray[j].getKey() + " ");
            else
                System.out.print("** ");
        }
        System.out.println("");
    }

    public int hashFunc(int key) {
        int keyDigitCount = getDigitCount(key);
        int groupSize = getDigitCount(arraySize);
        int groupSum = 0;
        String keyString = Integer.toString(key);
        int i;
        for (i = 0; i < keyString.length(); i += groupSize) {
            if (i + groupSize <= keyString.length()) {
                String group = keyString.substring(i, i + groupSize);
                groupSum += Integer.parseInt(group);
            }
        }
        // There is no remaining part if count is divisible by groupsize.
        if (keyDigitCount % groupSize != 0) {
            String remainingPart = keyString.substring(i - groupSize, keyString.length());
            groupSum += Integer.parseInt(remainingPart);
        }
        return groupSum % arraySize;
    }

    private int getDigitCount(int n) {
        int numDigits = 1;
        while (n > 9) {
            n /= 10;
            numDigits++;
        }
        return numDigits;
    }

    public void insert(DataItem item)

    {
        int key = item.getKey();
        int hashVal = hashFunc(key);

        while (hashArray[hashVal] != null &&
                hashArray[hashVal].getKey() != -1) {
            ++hashVal;
            hashVal %= arraySize;
        }
        hashArray[hashVal] = item;
    }

    public DataItem delete(int key) {
        int hashVal = hashFunc(key);

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                DataItem temp = hashArray[hashVal];
                hashArray[hashVal] = nonItem;
                return temp;
            }
            ++hashVal;
            hashVal %= arraySize;
        }
        return null;
    }

    public DataItem find(int key) {
        int hashVal = hashFunc(key);
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key)
                return hashArray[hashVal];
            ++hashVal;
            hashVal %= arraySize;
        }
        return null;
    }
}

class HashTableApp {
    public static void main(String[] args) throws IOException {
        DataItem aDataItem;
        int aKey, size, n, keysPerCell;
        // get sizes
        System.out.print("Enter size of hash table: ");
        size = getInt();
        System.out.print("Enter initial number of items: ");
        n = getInt();
        keysPerCell = 1000;
        // make table
        HashTable theHashTable = new HashTable(size);

        for (int j = 0; j < n; j++) {
            aKey = (int) (java.lang.Math.random() *
                    keysPerCell * size);
            aDataItem = new DataItem(aKey);
            theHashTable.insert(aDataItem);
        }

        while (true) {
            System.out.print("Enter first letter of ");
            System.out.print("show, insert, delete, or find: ");
            char choice = getChar();
            switch (choice) {
                case 's':
                    theHashTable.displayTable();
                    break;
                case 'i':
                    System.out.print("Enter key value to insert: ");
                    aKey = getInt();
                    aDataItem = new DataItem(aKey);
                    theHashTable.insert(aDataItem);
                    break;
                case 'd':
                    System.out.print("Enter key value to delete: ");
                    aKey = getInt();
                    theHashTable.delete(aKey);
                    break;
                case 'f':
                    System.out.print("Enter key value to find: ");
                    aKey = getInt();
                    aDataItem = theHashTable.find(aKey);
                    if (aDataItem != null) {
                        System.out.println("Found " + aKey);
                    } else
                        System.out.println("Could not find " + aKey);
                    break;
                default:
                    System.out.print("Invalid entry\n");
            }
        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
}

