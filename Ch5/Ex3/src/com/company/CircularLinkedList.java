package com.company;

/**
 * Created by try on 25/12/15.
 * A circular list is a linked list in which the last link points back to the first link.
 * There are many ways to design a circular list. Sometimes there is a pointer to
 * the “start” of the list. However, this makes the list less like a real circle and
 * more like an ordinary list that has its end attached to its beginning. Make a
 * class for a singly linked circular list that has no end and no beginning. The
 * only access to the list is a single reference, current , that can point to any link
 * on the list. This reference can move around the list as needed. (See
 * Programming Project 5.5 for a situation in which such a circular list is ideally
 * suited.) Your list should handle insertion, searching, and deletion. You may
 * find it convenient if these operations take place one link downstream of the
 * link pointed to by current . (Because the upstream link is singly linked, you
 * can’t get at it without going all the way around the circle.) You should also be
 * able to display the list (although you’ll need to break the circle at some arbitrary
 * point to print it on the screen). A step() method that moves current along to the
 * next link might come in handy too.
 */
public class CircularLinkedList {

    private Link first;

    /** Creates empty CircularLinkedList */
    public CircularLinkedList() {
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
     * Returns the String representation of the CircularLinkedList
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
