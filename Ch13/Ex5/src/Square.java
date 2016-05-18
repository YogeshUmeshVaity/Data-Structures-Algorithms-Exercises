/**
 * Represents are square in a chess board.
 */
public class Square {
    private int squareNumber;
    private boolean visited;

    // Last visited on the matrix.
    private int lastMove;

    private int row;
    private int column;

    public Square(int squareNumber, int row, int column) {
        this.squareNumber = squareNumber;
        visited = false;
        this.lastMove = -1;
        this.row = row;
        this.column = column;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getSquareNumber() {

        return squareNumber;
    }

    public void setSquareNumber(int squareNumber) {
        this.squareNumber = squareNumber;
    }

    public int getLastMove() {
        return lastMove;
    }

    public void setLastMove(int lastMove) {
        this.lastMove = lastMove;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public String toString() {
        String number;
        if(squareNumber <= 9) {
            number = "0" + squareNumber;
        } else {
            number = String.valueOf(squareNumber);
        }
        return number + ":" + (visited ? 1 : 0);
    }
}
