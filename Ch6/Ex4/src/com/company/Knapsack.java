package com.company;

import java.util.LinkedList;

/**
 * Created by try on 20/1/16.
 */
public class Knapsack {
    private int[] weights = {11, 8, 7, 6, 5};
    private LinkedList<Integer> knapsack = new LinkedList<>();
    private boolean fitted = false;

    public void fitItems(int targetWeight, int startingIndex) {
        for(int i = startingIndex; i < weights.length && !fitted; i++) {
            if(targetWeight == weights[i]) {
                fitted = true;
                return;
            } else if(targetWeight > weights[i]) {
                fitItems(targetWeight - weights[i], i + 1);
            }
        }
    }

    public void displayFittedItems() {
        System.out.println(knapsack);
    }
}
