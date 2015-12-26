package com.company;

public class Main {

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();

        list.insert(999);
        list.insert(222);
        list.insert(111);
        list.insert(555);
        list.insert(666);
        list.insert(777);
        list.insert(333);

        System.out.println(list);

//        System.out.println("find(333): " + list.find(333));
//        System.out.println("find(123): " + list.find(123));
//        System.out.println("find(999): " + list.find(999));
//        System.out.println("find(334): " + list.find(334));

    }
}
