package com.company;

/**
 *  Implement the recursive approach to raising a number to a power, as described
 * in the “Raising a Number to a Power” section near the end of this chapter.
 * Write the recursive power() function and a main() routine to test it.
 */
public class PowerRaiser {

    /**
     * Calculates the specified power of the specified base.
     */
    public long raiseToPower(long base, long power) {
        if(power == 1) {
            return base;
        }
        if ((power % 2) != 0) { // power is odd
            return base * raiseToPower(base * base, power / 2);
        } else { // power is even
            return raiseToPower(base * base, power / 2);
        }
    }
}
