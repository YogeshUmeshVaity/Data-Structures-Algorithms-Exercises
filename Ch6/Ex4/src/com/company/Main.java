package com.company;

public class Main {

    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack();
        knapsack.fitItems(21, 0);
        knapsack.displayFittedItems();
    }
}
