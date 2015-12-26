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

    private Link current;

    /** Creates empty CircularLinkedList */
    public CircularLinkedList() {
        current = null;
    }

    /** Inserts element to the list */
    public void insert(long d) {
        Link newLink = new Link(d);
        // if list empty
        if(current == null) {
            current = newLink;
            newLink.next = current;
        } else {
            newLink.next = current.next;
            current.next = newLink;
        }
        // make current point to newly inserted link
        current = newLink;
    }

    /**
     * Steps through all the elements in the list. One element at a time.
     */

    /**
     * Returns the String representation of the CircularLinkedList
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("[ ");
        s.append(current);
        if(current.next != current) s.append(", ");
        Link temp = current.next;
        while (temp != current) {
            s.append(temp);
            temp = temp.next;
            if(temp != current) s.append(", ");
        }
        s.append(" ]");
        return s.toString();
    }

}
