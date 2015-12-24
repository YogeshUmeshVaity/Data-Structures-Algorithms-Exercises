package com.company;

public class Main {

    public static void main(String[] args) {
	    Deque deque = new Deque();
        deque.insertRight(33);
        deque.insertLeft(66);
        deque.insertRight(120);
        deque.insertRight(99);
        deque.displayDeque();

        System.out.println("removeLeft(): " + deque.removeLeft());
        System.out.println("removeLeft(): " + deque.removeLeft());
        deque.displayDeque();

        System.out.println("removeRight(): " + deque.removeRight());
        deque.displayDeque();
    }
}
