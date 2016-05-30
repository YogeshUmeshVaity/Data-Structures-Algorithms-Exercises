package com.company;
import com.company.Deque;

public class Stack {

    private Deque deque;

    public Stack(int maxSize) {
        deque = new Deque(maxSize);
    }

    public void push(long j) {
        deque.insertRight(j);
    }

    public long pop() {
        return deque.removeRight();
    }

    public long peek() {
        long temp = deque.removeRight();
        deque.insertRight(temp);
        return temp;
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }

    public boolean isFull() {
        return deque.isFull();
    }

    public static void main(String[] args) {
        Stack stack = new Stack(10);

        stack.push(30);
        stack.push(60);
        stack.push(90);
        stack.push(120);
        stack.push(150);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
