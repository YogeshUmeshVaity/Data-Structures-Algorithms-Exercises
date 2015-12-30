package com.company;

/**
 * Created by try on 30/12/15.
 *
 * a two-dimensional linked list, which we’ll
 * call a matrix. This is the list analogue of a two-dimensional array. It might be
 * useful in applications such as spreadsheet programs. If a spreadsheet is based
 * on an array, and you insert a new row near the top, you must move every cell
 * in the lower rows N*M cells, which is potentially a slow process. If the spread-
 * sheet is implemented by a matrix, you need only change N pointers.
 * For simplicity, we’ll assume a singly linked approach (although a double-linked
 * approach would probably be more appropriate for a spreadsheet). Each link
 * (except those on the top row and left side) is pointed to by the link directly
 * above it and by the link on its left. You can start at the upper-left link and
 * navigate to, say, the link on the third row and fifth column by following the
 * pointers down two rows and right four columns. Assume your matrix is created
 * with specified dimensions (7 by 10, for example). You should be able to insert
 * values in specified links and display the contents of the matrix.
 *
 * This will be easier to implement if we create LinkedList of LinkedLists.
 * That is, there will be a LinkedList for holding rows and LinkedList of LinkedLists
 * for holding columns.
 */
public class LinkedList2D {
    // Holds reference to first LinkedList in the list
    private LinkedList first;

    public LinkedList2D() {
        first = null;
    }

    /**
     * Inserts the value in the given cell specified with given row and column.
     * TODO Creates new cell if the cell doesn't exist, otherwise replaces the current value
     * in the cell.
     *
     * @param row is the row where the cell located.
     * @param column is the column where the cell is located.
     * @param value is the element to be inserted in the specified cell.
     * @return Returns the replaced or inserted value.
     */
    public long insert(int row, int column, long value) {
        // If row is empty, add a list to it.
        if(first == null) first = new LinkedList();
        // Iterate to the specified row first
        LinkedList current = first;
        for(int i = 1; i < row; i++) {
            // If current.next is empty, create new list
            if(current.next == null) {
                current.next = new LinkedList();
            }
            current = current.next;
        }
        // At this point current will be the row(LinkedList) where the cell is.
        return current.insert(column, value);
    }

    /**
     * @return Returns String representation of the LinkedList2D
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("");
        LinkedList current = first;
        while (current != null) {
            s.append(current);
            current = current.next;
            if(current != null) s.append("\n");
        }
        return s.toString();
    }

}
