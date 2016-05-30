/**
 * In the triangle.java program (Listing 6.1), remove the code for the base case
 * (the if(n==1), the return 1;, and the else). Then run the program and see what
 * happens.
 *
 * Result: java.lang.StackOverflowError -> Due to deep recursion, stack is exhausted.
 * Here infinite recursion is occurring.
 */

package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int theNumber;

    public static void main(String[] args) throws IOException
    {
        System.out.print("Enter a number: ");
        theNumber = getInt();
        int theAnswer = triangle(theNumber);
        System.out.println("Triangle="+theAnswer);
    }  // end main()
    //-------------------------------------------------------------
    public static int triangle(int n)
    {
        return  ( n + triangle(n-1) );
    }
    //-------------------------------------------------------------
    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
    //-------------------------------------------------------------
    public static int getInt() throws IOException
    {
        String s = getString();
        return Integer.parseInt(s);
    }
}
