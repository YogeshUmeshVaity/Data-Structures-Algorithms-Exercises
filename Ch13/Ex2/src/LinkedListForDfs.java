// linkList2.java
// demonstrates linked list
// to run this program: C>java LinkList2App
////////////////////////////////////////////////////////////////
class Link
{
    public int iData;              // data item (key)
    public Link next;              // next link in list
    public Vertex vertex;
    // -------------------------------------------------------------
    public Link(int id) // constructor
    {
        iData = id;
    }
    // -------------------------------------------------------------
    public void displayLink()      // display ourself
    {
        System.out.print("{" + iData +  "} ");
    }
}  // end class Link
////////////////////////////////////////////////////////////////
class LinkList
{
    private Link first;            // ref to first link on list

    // -------------------------------------------------------------
    public LinkList()              // constructor
    {
        first = null;               // no links on list yet
    }
    // -------------------------------------------------------------
    public void insertFirst(int id)
    {                           // make new link
        Link newLink = new Link(id);
        newLink.next = first;       // it points to old first link
        first = newLink;            // now first points to this
    }
    // -------------------------------------------------------------
    public Link findUnvisited(Vertex[] vertexList)      // findUnvisited link with given key
    {                           // (assumes non-empty list)
        Link current = first;              // start at 'first'
        while(vertexList[current.iData].wasVisited != false)        // while no match,
        {
            if(current.next == null)        // if end of list,
                return null;                 // didn't findUnvisited it
            else                            // not end of list,
                current = current.next;      // go to next link
        }
        return current;                    // found it
    }
    // -------------------------------------------------------------
    public Link delete(int key)    // delete link with given key
    {                           // (assumes non-empty list)
        Link current = first;              // search for link
        Link previous = first;
        while(current.iData != key)
        {
            if(current.next == null)
                return null;                 // didn't findUnvisited it
            else
            {
                previous = current;          // go to next link
                current = current.next;
            }
        }                               // found it
        if(current == first)               // if first link,
            first = first.next;             //    change first
        else                               // otherwise,
            previous.next = current.next;   //    bypass it
        return current;
    }
    // -------------------------------------------------------------
    public void displayList()      // display the list
    {
        System.out.print("List (first-->last): ");
        Link current = first;       // start at beginning of list
        while(current != null)      // until end of list,
        {
            current.displayLink();   // print data
            current = current.next;  // move to next link
        }
        System.out.println("");
    }
// -------------------------------------------------------------
}  // end class LinkList
////////////////////////////////////////////////////////////////
//class LinkList2App
//{
//    public static void main(String[] args)
//    {
//        LinkList theList = new LinkList();  // make list
//
//        theList.insertFirst(22);      // insert 4 items
//        theList.insertFirst(44);
//        theList.insertFirst(66);
//        theList.insertFirst(88);
//
//        theList.displayList();              // display list
//
//        Link f = theList.findUnvisited();          // findUnvisited item
//        if( f != null)
//            System.out.println("Found link with key " + f.iData);
//        else
//            System.out.println("Can't findUnvisited link");
//
//        Link d = theList.delete(66);        // delete item
//        if( d != null )
//            System.out.println("Deleted link with key " + d.iData);
//        else
//            System.out.println("Can't delete link");
//
//        theList.displayList();              // display list
//    }  // end main()
//}  // end class LinkList2App
////////////////////////////////////////////////////////////////