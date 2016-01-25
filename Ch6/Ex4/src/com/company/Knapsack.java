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
        for(int i = startingIndex; i < weights.length && !fitted; i++) {
            if(i == weights.length) {
                return;
            }
            if(targetWeight == weights[i]) {
                fitted = true;
                knapsack.add(weights[i]);
                return;
            } else if(targetWeight > weights[i]) {
                fitItems(targetWeight - weights[i], i + 1);
                if(fitted) knapsack.add(weights[i]);
            } else if(targetWeight < weights[i]) {
                fitItems(targetWeight, i + 1);
            }
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
