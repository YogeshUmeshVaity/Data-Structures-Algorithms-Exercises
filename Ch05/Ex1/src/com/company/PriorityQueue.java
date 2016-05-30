package com.company;

/**
 * Created by try on 24/12/15.
 * Implement a priority queue based on a sorted linked list. The remove operation
 * on the priority queue should remove the item with the smallest key.
 */
public class PriorityQueue {

    private SortedList list = new SortedList();

    /**
     * Inserts elements in sorted order required for priority queue.
     * @param key is the item to be inserted.
     */
    public void insert(long key) {
        list.insert(key);
    }

    /**
     * Removes the first key(smallest) in the list.
     * @return Returns the removed item.
     */
    public long remove() {
        Link tempLink = list.remove();
        return tempLink.dData;
    }

    /**
     * Temporarily removes the value from the queue and then inserts it back.
     * @return Returns the next value to be removed from the queue.
     */
    public long peek() {
        Link tempLink = list.remove();
        long data = tempLink.dData;
        list.insert(data);
        return tempLink.dData;
    }

    /**
     * Displays the contents of the queue.
     */
    public void displayQueue() {
        list.displayList();
    }
}
