package com.company;

/**
 * Represents a row in the binary tree.
 */
public class Row {

    private char[] treeRow;

    public Row(int rowLength) {
        treeRow = new char[rowLength];
        fillRowWithDashes();
    }

    private void fillRowWithDashes() {
        for(int i = 0; i < treeRow.length; i++) {
            treeRow[i] = '-';
        }
    }

    public void insertCharAt(int index, char character){
        treeRow[index] = character;
    }

    @Override
    public String toString() {
        StringBuilder returnString = new StringBuilder();
        for(int i = 0; i < treeRow.length; i++) {
            returnString.append(treeRow[i]);
        }
        return returnString.toString();
    }

    public static void main(String[] args) {
        Row r = new Row(16);
        System.out.print(r);
        r.insertCharAt(8, 'X');
        System.out.print(r);
    }
}
