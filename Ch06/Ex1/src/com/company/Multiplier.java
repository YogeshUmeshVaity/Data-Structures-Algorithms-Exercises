package com.company;

/**
 * Suppose you buy a budget-priced pocket PC and discover that the chip inside
 * can’t do multiplication, only addition. You program your way out of this
 * quandary by writing a recursive method, mult(), that performs multiplication
 * of x and y by adding x to itself y times. Its arguments are x and y and its return
 * value is the product of x and y. Write such a method and a main() program to
 * call it. Does the addition take place when the method calls itself or when it
 * returns?
 */
public class Multiplier {

    /**
     * Multiplies x by y using recursion.
     *
     * @param multiplicand is x.
     * @param multiplier is y.
     * @return Returns the product of x and y.
     */
    public int multiply(int multiplicand, int multiplier) {
        if(multiplier == 1) {
            return multiplicand;
        } else {
            // Addition takes place when the method returns.
            return multiplicand + multiply(multiplicand, multiplier - 1 );
        }
    }
}
