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

    // Flag for letting the outer method know whether the items are fitted.
    private boolean fitted = false;

    /**
     * Collects the fitted items in knapsack if the solution exists.
     * Call showResult() for result after calling this.
     * @param targetWeight is the maximum weight the knapsack can handle.
     */
    public void fitItems(int targetWeight) {
        recurseFitItems(targetWeight, 0);
    }

    /**
     * Collects the fitted items in knapsack if the solution exists.
     * @param targetWeight is the maximum weight the knapsack can handle.
     * @param startingIndex is the index of weights array where the search should begin.
     */
    private void recurseFitItems(int targetWeight, int startingIndex) {
        for (int i = startingIndex; i < weights.length && !fitted; i++) {
            if (i == weights.length) {
                return;
            }
            // Base case
            if (targetWeight == weights[i]) {
                fitted = true;
                knapsack[knapsackIndex++] = weights[i];
                return;
            } else if (targetWeight > weights[i]) {
                // Recursion
                recurseFitItems(targetWeight - weights[i], i + 1);
                if (fitted) knapsack[knapsackIndex++] = weights[i];
            } else if (targetWeight < weights[i]) {
                // Recursion
                recurseFitItems(targetWeight, i + 1);
            }
        }
    }

    /**
     * Prints fitted items on the console.
     */
    private void printFittedItems() {
        for (int i = knapsackIndex - 1; i >= 0; i--) {
            System.out.print(knapsack[i]);
            if (i != 0) {
                System.out.print(", ");
            }
        }
    }

    /**
     * Displays fitted items on the console if the solution exits.
     * Otherwise a message that says "No solution exists".
     */
    public void showResult() {
        if (fitted) printFittedItems();
        else System.out.println("No solution exists");

    }
}