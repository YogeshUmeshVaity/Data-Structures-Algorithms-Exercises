package com.company;


// demonstrates queue
// to run this program: C>java QueueApp
////////////////////////////////////////////////////////////////
class Deque
{
    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;
    private int nItems;

    public Deque(int s) {
        maxSize = s;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(long j) {
        if(rear == maxSize-1)         // deal with wraparound
            rear = -1;
        queArray[++rear] = j;         // increment rear and insert
        nItems++;                     // one more item
    }

    public long remove() {
        long temp = queArray[front++]; // get value and incr front
        if(front == maxSize)           // deal with wraparound
            front = 0;
        nItems--;                      // one less item
        return temp;
    }



    public boolean isEmpty() {
        return (nItems==0);
    }

    public boolean isFull() {
        return (nItems==maxSize);
    }


}

class Main {
    public static void main(String[] args) {
        Deque deque = new Deque(5);  // queue holds 5 items
        deque.insert(10);            // insert 4 items
        deque.insert(20);
        deque.insert(30);
        deque.insert(40);

        System.out.println(deque.remove());

    }
}