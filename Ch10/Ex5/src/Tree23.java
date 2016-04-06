class Tree23 {
    private Node root = new Node();            // make root node

    public int find(long key) {
        Node curNode = root;
        int childNumber;
        while (true) {
            if ((childNumber = curNode.findItem(key)) != -1)
                return childNumber;               // found it
            else if (curNode.isLeaf())
                return -1;                        // can't find it
            else                                 // search deeper
                curNode = getNextChild(curNode, key);
        }  // end while
    }

    // insert a DataItem
    public void insert(long dValue) {
        Node currentNode = root;
        Node newRightNode;
        DataItem newItem = new DataItem(dValue);
        // Find leaf node to insert item.
        while (!currentNode.isLeaf()) {
            currentNode = getNextChild(currentNode, dValue);
        }

        if (!currentNode.isFull()) {
            currentNode.insertItem(newItem);
        } else {
            newRightNode = split(currentNode, newItem);
            //currentNode.getParent().connectChild(1, newRightNode);
        }
    }


    public Node split(Node thisNode, DataItem newItem) {
        // assumes node is full
        DataItem itemA, itemB, itemC;
        Node parent, child0, child1, child2;


        itemC = thisNode.removeItem();
        itemA = thisNode.removeItem();
        itemB = newItem;

        // Sort Items in this node including the new item.
        if (itemA.dData > itemB.dData) {
            swap(itemA, itemB);
        }
        if (itemB.dData > itemC.dData) {
            swap(itemB, itemC);
        }
        if (itemA.dData > itemB.dData) {
            swap(itemA, itemB);
        }

        // Insert the first item back into the node being split.
        thisNode.insertItem(itemA);

        if (thisNode == root) {
            root = new Node();
            parent = root;
            root.connectChild(0, thisNode);
        } else {
            parent = thisNode.getParent();
        }
        Node newRightParent;
        Node newRightNode = new Node();
        newRightNode.insertItem(itemC);
        if (parent.isFull()) {
//            if(parent == root) {
//                root = new Node();
//                root.connectChild(0, parent);
//                newRightParent = split(parent, itemB);
//                root.connectChild(1, newRightParent);
//                return newRightParent;
//            }
            child0 = parent.disconnectChild(0);
            child1 = parent.disconnectChild(1);
            child2 = parent.disconnectChild(2);
            newRightParent = split(parent, itemB);
            if(thisNode == child0) {
                parent.connectChild(0, child0);
                newRightParent.connectChild(0, child1);
                newRightParent.connectChild(1, child2);
            } else if(thisNode == child1) {
                parent.connectChild(0, child0);
                parent. connectChild(1, child1);
                newRightParent.connectChild(1, child2);
            } else if(thisNode == child2) {
                parent.connectChild(0, child0);
                parent.connectChild(1, child1);
                newRightParent.connectChild(0, child2);
            }
            // Connect the new parent to it's grandparent
            //newRightParent.getParent().connectChild(1, parent); //
            parent = newRightParent;
            //parent.insertItem(itemB);
            parent.connectChild(1, newRightNode);
        } else {
            // Insert middle item in the parent
            int itemIndex = parent.insertItem(itemB);
            int n = parent.getNumItems();
            for (int j = n - 1; j > itemIndex; j--) {
                Node temp = parent.disconnectChild(j);
                parent.connectChild(j + 1, temp);
            }
            parent.connectChild(itemIndex + 1, newRightNode);
        }

        return newRightNode;
    }

    private void swap(DataItem item1, DataItem item2) {
        long tempItem = item1.dData;
        item1.dData = item2.dData;
        item2.dData = tempItem;
    }

    // gets appropriate child of node during search for value
    public Node getNextChild(Node theNode, long theValue) {
        int j;
        // assumes node is not empty, not full, not a leaf
        int numItems = theNode.getNumItems();
        for (j = 0; j < numItems; j++)          // for each item in node
        {                               // are we less?
            if (theValue < theNode.getItem(j).dData)
                return theNode.getChild(j);  // return left child
        }  // end for                   // we're greater, so
        return theNode.getChild(j);        // return right child
    }

    public void displayTree() {
        recDisplayTree(root, 0, 0);
    }

    private void recDisplayTree(Node thisNode, int level,
                                int childNumber) {
        System.out.print("level=" + level + " child=" + childNumber + " ");
        thisNode.displayNode();               // display this node

        // call ourselves for each child of this node
        int numItems = thisNode.getNumItems();
        for (int j = 0; j < numItems + 1; j++) {
            Node nextNode = thisNode.getChild(j);
            if (nextNode != null)
                recDisplayTree(nextNode, level + 1, j);
            else
                return;
        }
    }

}