package com.company;

public class Main {

    public static void main(String[] args) {
        LinkedList2D list = new LinkedList2D();

        for(int rows = 1; rows <= 7; rows++) {
            for(int columns = 1; columns <= 10; columns++) {
                list.insert(rows, columns, (long) (Math.random() * 99));
            }
        }
        System.out.println(list);
        System.out.println(list.insert(3, 3, 99));
        System.out.println(list);
        System.out.println(list.insert(7, 10, 99));
        System.out.println(list);
        System.out.println(list.insert(6, 9, 99));
        System.out.println(list);
    }
}
