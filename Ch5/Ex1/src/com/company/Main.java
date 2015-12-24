package com.company;

public class Main {

    public static void main(String[] args) {
	    PriorityQueue queue = new PriorityQueue();

        queue.insert(120);
        queue.insert(66);
        queue.insert(99);
        System.out.println("After inserting...");
        queue.displayQueue();

        queue.remove();
        queue.remove();
        System.out.println("After removing twice...");
        queue.displayQueue();

        System.out.println("peek(): " + queue.peek());

        System.out.println("After peek() the queque is :");
        queue.displayQueue();
    }
}
