package com.company;

import java.util.LinkedList;

/**
 * Created by try on 20/1/16
 */
public class Knapsack {
    private int[] weights = {1, 8, 7, 6, 8, 3, 2};
    private LinkedList<Integer> knapsack = new LinkedList<>();
    private boolean fitted = false;

    public void fitItems(int targetWeight, int startingIndex) {
        if(startingIndex == weights.length) {
            return;
        }
        if(targetWeight == weights[startingIndex]) {
            fitted = true;
            knapsack.add(weights[startingIndex]);
            return;
        } else if(targetWeight > weights[startingIndex]) {
            fitItems(targetWeight - weights[startingIndex], startingIndex + 1);
            if(fitted) knapsack.add(weights[startingIndex]);
        } else if(targetWeight < weights[startingIndex]) {
            fitItems(targetWeight, startingIndex + 1);
        }
    }

    public void displayFittedItems() {
        if(fitted) {
            System.out.println(knapsack);
        } else {
            System.out.println("No solution exists");
        }
    }
}
