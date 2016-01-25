package com.company;

/**
 * Created by try on 20/1/16
 */
public class Knapsack {
    // Input array : values provided by user.
    private int[] weights = {1, 8, 7, 6, 8, 3, 2};

    // Output array : for storing fitted items.
    private int[] knapsack = new int[weights.length];

    // Index of knapsack.
    private int knapsackIndex = 0;

    // Flag for letting the function know whether the items are fitted.
    private boolean fitted = false;

    public void fitItems(int targetWeight, int startingIndex) {
        for(int i = startingIndex; i < weights.length && !fitted; i++) {
            if(i == weights.length) {
                return;
            }
            if(targetWeight == weights[i]) {
                fitted = true;
                knapsack[knapsackIndex++] = weights[i];
                return;
            } else if(targetWeight > weights[i]) {
                fitItems(targetWeight - weights[i], i + 1);
                if(fitted) knapsack[knapsackIndex++] = weights[i];
            } else if(targetWeight < weights[i]) {
                fitItems(targetWeight, i + 1);
            }
        }
    }

    public void displayFittedItems() {
        if(fitted) {
            for(int i = knapsackIndex - 1; i >= 0; i--) {
                System.out.print(knapsack[i]);
                if(i != 0) {
                    System.out.print(", ");
                }
            }
        } else {
            System.out.println("No solution exists");
        }
    }
}
