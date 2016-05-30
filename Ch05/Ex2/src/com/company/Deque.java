package com.company;

/**
 * Created by try on 24/12/15.
 */
public class Deque {

    private DoublyLinkedList list;

    public Deque() {
        list = new DoublyLinkedList();
    }

    /**
     * Inserts the element to the left of the Deque.
     */
    public void insertLeft(long element) {
        list.insertFirst(element);
    }

    /**
     * Inserts the element to the right of the Deque.
     */
    public  void insertRight(long element) {
        list.insertLast(element);
    }

    /**
     *  Removes the element from left of the Deque.
     *  @return Returns the removed value.
     */
    public long removeLeft() {
        Link link = list.deleteFirst();
        return link.dData;
    }

    /**
     *  Removes the element from right of the Deque.
     *  @return Returns the removed value.
     */
    public long removeRight() {
        Link link = list.deleteLast();
        return link.dData;
    }

    /**
     * @return Returns true if the Deque is empty, false otherwise.
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Displays the contents of the Deque
     */
    public void displayDeque() {
        list.displayForward();
    }

}
