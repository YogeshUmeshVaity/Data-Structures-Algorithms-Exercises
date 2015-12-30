package com.company;

/**
 * Created by try on 30/12/15.
 */
public class LinkedList {

    private Link first;
    public LinkedList next;

    /** Creates empty LinkedList */
    public LinkedList() {
        first = null;
    }

    /** Inserts element to the list */
    public void insert(long d) {
        Link newLink = new Link(d);
        if(first == null) {
            first = newLink;
        } else {
            newLink.next = first;
            first = newLink;
        }
    }

    /**
     * Inserts specified value at specified position.
     * Assumes that the user know that a particular link is null.
     */
    public long insert(int position, long value) {
        // If list is empty, add a link
        if(first == null) first = new Link(-1); // -1 means unused link.
        // Iterate to the specified position
        Link current = first;
        for(int i = 1; i < position; i++) {
            // If current.next is empty, create new unused link
            if(current.next == null) {
                current.next = new Link(-1);
            }
            current = current.next;
        }
        long temp = current.dData;
        current.dData = value;
        return temp;
    }

    /**
     * Searches for the item to be deleted.
     * @return Returns true if the item is found in the list and deleted,
     * otherwise false.
     */
    public boolean delete(long d) {
        Link current = first;
        Link previous = null;
        while (current != null && current.dData != d) {
            previous = current;
            current = current.next;
        }
        // Item cannot be found or list empty
        if(current == null) return false;
        // If first item in the list
        if(current == first) {
            first = current.next;
        } else {
            previous.next = current.next;
        }
        return true;
    }

    /**
     * Searches for a link with given long value.
     * @return Returns the link with given value or null if value not found.
     */
    public Link find(long d) {
        Link current = first;
        while (current != null && current.dData != d) {
            current = current.next;
        }
        // If list empty or item not found till the end
        if(current == null) return null;
        return current;
    }

    /**
     * Returns the String representation of the LinkedList
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("[ ");
        Link current = first;
        while (current != null) {
            s.append(current);
            current = current.next;
            if(current != null) s.append(", ");
        }
        s.append(" ]");
        return s.toString();
    }
}
