package com.company;

/**
 * Created by try on 14/1/16.
 * In Chapter 8, “Binary Trees,” we’ll look at binary trees, where every branch has
 * (potentially) exactly two sub-branches. If we draw a binary tree on the screen
 * using characters, we might have 1 branch on the top row, 2 on the next row,
 * then 4, 8, 16, and so on. Here’s what that looks like for a tree 16 characters
 * wide:
 * --------X-------
 * ----X-------X---
 * --X---X---X---X-
 * -X-X-X-X-X-X-X-X
 * XXXXXXXXXXXXXXXX
 * (Note that the bottom line should be shifted a half character-width right, but
 * there’s nothing we can do about that with character-mode graphics.) You can
 * draw this tree using a recursive recursiveMakeBranches() method with arguments left
 * and right, which are the endpoints of a horizontal range. When you first enter
 * the routine, left is 0 and right is the number of characters (including dashes)
 * in all the lines, minus 1. You draw an X in the center of this range. Then the
 * method calls itself twice: once for the left half of the range and once for the
 * right half. Return when the range gets too small. You will probably want to put
 * all the dashes and Xs into an array and display the array all at once, perhaps
 * with a display() method. Write a main() program to draw the tree by calling
 * recursiveMakeBranches() and display(). Allow main() to determine the line length of the
 * display (32, 64, or whatever). Ensure that the array that holds the characters for
 * display is no larger than it needs to be. What is the relationship of the number
 * of lines (five in the picture here) to the line width?
 */
//--------X-----------X-------X-----X---X---X---X--X-X-X-X-X-X-X-XXXXXXXXXXXXXXXXX
public class BinaryTreePrinter {

    // Holds the characters to be printed
    private Row[] binaryTree;
    private int rowLength;

    public BinaryTreePrinter(int rowLength) {
        this.rowLength = rowLength;
        // Number of rows = (Base 2 log of rowLength) + 1
        int numberOfRows = (int) (Math.log(rowLength) / Math.log(2)) + 1;
        binaryTree = new Row[numberOfRows];
        for (int i = 0; i < binaryTree.length; i++) {
            binaryTree[i] = new Row(rowLength);
        }
    }

    public void makeBranches() {
        recursiveMakeBranches(0, rowLength - 1, 0);
    }

    private void recursiveMakeBranches(int leftIndex, int rightIndex, int rowIndex) {
        if (leftIndex == rightIndex) {
            binaryTree[rowIndex].insertCharAt(leftIndex, 'X');
            return;
        } else {
            int midPoint = (leftIndex + rightIndex) / 2;
            binaryTree[rowIndex].insertCharAt(midPoint, 'X');
            recursiveMakeBranches(leftIndex, midPoint, rowIndex + 1);
            recursiveMakeBranches(midPoint + 1, rightIndex, rowIndex + 1);
        }
    }

    public void display() {
        for (int i = 0; i < binaryTree.length; i++) {
            System.out.println(binaryTree[i]);
        }
    }

}

