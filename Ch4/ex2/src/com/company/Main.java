package com.company;

class Deque
{
    private int maxSize;
    private long[] queArray;
    private int left;
    private int right;
    private int nItems;

    public Deque(int s) {
        maxSize = s;
        queArray = new long[maxSize];
        left = 0;
        right = -1;
        nItems = 0;
    }

    public void insertRight(long j) {
        if(right == maxSize-1)
            right = -1;
        queArray[++right] = j;
        nItems++;
    }

    public long removeRight() {
        //if(nItems == 1) left = right;
        long temp = queArray[right--];
        nItems--;
        if(right == -1) {
            if(nItems > 0)
                right = maxSize - 1;
            else
                right = left;
        }
        return temp;
    }

    public void insertLeft(long j) {
        if(left == 0) left = maxSize - 1;
        queArray[left--] = j;
        if(right == left) left++; // prevent left overwriting right
        nItems++;
    }

    public long removeLeft() {
        if(nItems == 1) right = left;
        long temp = queArray[left++];
        if(left == right) left--;
        nItems--;
        //if(nItems == 0) left = right;
        if(left == maxSize) {
            if(nItems > 0) {
                left = 0;
            } else {
                left = right;
            }
        }

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
        Deque deque = new Deque(5);
        deque.insertRight(10);
        deque.insertRight(20);
        deque.insertRight(30);
        deque.insertRight(40);
        deque.insertLeft(50);

        System.out.println(deque.removeLeft());
        System.out.println(deque.removeLeft());
        System.out.println(deque.removeLeft());
        System.out.println(deque.removeLeft());

        deque.insertLeft(10);
        System.out.println(deque.removeLeft());
//
//
//        deque.insertLeft(10);
//        System.out.println(deque.removeLeft());
//
//        deque.insertRight(10);
//        System.out.println(deque.removeLeft());



//        System.out.println(deque.removeLeft());
//        System.out.println(deque.removeRight());
//
//        deque.insertLeft(10);
//        System.out.println(deque.removeLeft());
//        System.out.println(deque.removeLeft());
//        deque.insertLeft(10);
//        System.out.println(deque.removeLeft());


    }
}