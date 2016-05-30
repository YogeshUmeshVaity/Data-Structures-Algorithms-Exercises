package com.company;

/**
 * Created by try on 14/12/15.
 */


class Checker {

    private static int checkerCount = 1;
    private int checkerId;
    private Queue queue;

    public Checker(Queue queue) {
        this.queue = queue;
        checkerId = checkerCount++;
    }

    /** Checks out the first customer that entered the queue */
    public void checkOut() {
        System.out.println("Customer " + queue.remove() + " checked out from checker" + checkerId);
    }

    /** Returns current number of people at the counter */
    public int getQueueSize() {
        return queue.size();
    }

    /** Checks in a new customer
     *  @param customerNumber is used like a customer identity
     */
    public void checkIn(long customerNumber) {
        queue.insert(customerNumber);
        System.out.println("Customer " + customerNumber + " has joined checker" + checkerId);
    }

    /**
     * Returns whether the checker is full or not
     */
    public boolean isFull() {
        return  queue.isFull();
    }

    /**
     * Returns whether the check is empty or not
     */
    public boolean isEmpty() {
        return queue.isEmpty();
    }


    public void showQueue() {
        queue.display();
    }
}