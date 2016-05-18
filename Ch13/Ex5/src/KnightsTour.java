import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Solves Knight's tour problem using depth-first search algorithm.
 */
public class KnightsTour {
    private static final int BOARD_SIZE = 5;
    private static final int MAX_MOVES = BOARD_SIZE * BOARD_SIZE;
    private Square board[][];
    private Stack<Square> stack = new Stack<>();
    private int[][] adjacentMovesMatrix;
    private Square[] squareList;

    public KnightsTour() {
        // Initialize Matrix
        adjacentMovesMatrix = new int[MAX_MOVES][MAX_MOVES];
        for(int y = 0; y < MAX_MOVES; y++) {
            for (int x = 0; x < MAX_MOVES; x++) {
                adjacentMovesMatrix[y][x] = 0;
            }
        }

        board = new Square[BOARD_SIZE][BOARD_SIZE];
        int squareNumber = 0;
        for (int y = 0; y < BOARD_SIZE; y++) {
            for (int x = 0; x < BOARD_SIZE; x++) {
                board[y][x] = new Square(squareNumber++, y, x);
            }
        }

        squareNumber = 0;
        squareList = new Square[MAX_MOVES];
        for (int y = 0; y < BOARD_SIZE; y++) {
            for (int x = 0; x < BOARD_SIZE; x++) {
                squareList[squareNumber] = new Square(squareNumber++, y, x);
            }
        }

        for (int i = 0; i < squareList.length; i++) {
            initAdjacentMoves(squareList[i]);
        }

    }

    private void initAdjacentMoves(Square currentSquare) {
        int r = 0, c = 0;

        int row = currentSquare.getRow();
        int column = currentSquare.getColumn();
        int squareNumber = currentSquare.getSquareNumber();

        // Possible knight move 1
        r = row - 2;
        c = column - 1;
        if (r >= 0 && r < BOARD_SIZE && c >= 0 && c < BOARD_SIZE) {
            adjacentMovesMatrix[squareNumber][board[r][c].getSquareNumber()] = 1;
        }

        // Possible knight move 2
        r = row - 2;
        c = column + 1;
        if (r >= 0 && r < BOARD_SIZE && c >= 0 && c < BOARD_SIZE) {
            adjacentMovesMatrix[squareNumber][board[r][c].getSquareNumber()] = 1;
        }

        // Possible knight move 3
        r = row - 1;
        c = column + 2;
        if (r >= 0 && r < BOARD_SIZE && c >= 0 && c < BOARD_SIZE) {
            adjacentMovesMatrix[squareNumber][board[r][c].getSquareNumber()] = 1;
        }

        // Possible knight move 4
        r = row + 1;
        c = column + 2;
        if (r >= 0 && r < BOARD_SIZE && c >= 0 && c < BOARD_SIZE) {
            adjacentMovesMatrix[squareNumber][board[r][c].getSquareNumber()] = 1;
        }

        // Possible knight move 5
        r = row + 2;
        c = column + 1;
        if (r >= 0 && r < BOARD_SIZE && c >= 0 && c < BOARD_SIZE) {
            adjacentMovesMatrix[squareNumber][board[r][c].getSquareNumber()] = 1;
        }

        // Possible knight move 6
        r = row + 2;
        c = column - 1;
        if (r >= 0 && r < BOARD_SIZE && c >= 0 && c < BOARD_SIZE) {
            adjacentMovesMatrix[squareNumber][board[r][c].getSquareNumber()] = 1;
        }

        // Possible knight move 7
        r = row + 1;
        c = column - 2;
        if (r >= 0 && r < BOARD_SIZE && c >= 0 && c < BOARD_SIZE) {
            adjacentMovesMatrix[squareNumber][board[r][c].getSquareNumber()] = 1;
        }

        // Possible knight move 8
        r = row - 1;
        c = column - 2;
        if (r >= 0 && r < BOARD_SIZE && c >= 0 && c < BOARD_SIZE) {
            adjacentMovesMatrix[squareNumber][board[r][c].getSquareNumber()] = 1;
        }
    }

    private void showMatrix() {
        for(int y = 0; y < MAX_MOVES; y++) {
            for (int x = 0; x < MAX_MOVES; x++) {
                System.out.print(adjacentMovesMatrix[y][x]);
            }
            System.out.println();
        }
    }

    public void showBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("\n");
        }
    }

    /**
     * Returns a valid move. Takes care of the moves that are off the board.
     */
    private int findValidMove(Square currentPosition) {
        int currentMove = currentPosition.getSquareNumber();
        for(int x = currentPosition.getLastMove() + 1; x < MAX_MOVES; x++) {
            if(adjacentMovesMatrix[currentMove][x] == 1 && squareList[x].isVisited() == false) {
                return x;
            }
        }
        return -1;
    }

    public void startTour() {
        squareList[12].setVisited(true);
        stack.push(squareList[12]);
        while (!stack.isEmpty()) {
            int nextMove = findValidMove(stack.peek());
            if (nextMove == -1) {
                Square backTrackMove = stack.pop();
                //board[backTrackMove.getRow()][backTrackMove.getColumn()].setVisited(false);
                backTrackMove.setVisited(false);
                backTrackMove.setLastMove(-1);

//                if (!stack.isEmpty()) {
//                    System.out.println("Backtracked move : "
//                            + backTrackMove.getSquareNumber()
//                            + ", Current Position : " + stack.peek().getSquareNumber());
//                }
//                showBoard();
                //waitForInput();

            } else {
                squareList[nextMove].setVisited(true);
                squareList[stack.peek().getSquareNumber()].setLastMove(nextMove);
                stack.push(squareList[nextMove]);
                //board[nextMoveRow][nextMoveColumn].setVisited(true);

//                System.out.println("Last move : " + nextMove.getSquareNumber());
//                showBoard();
                //waitForInput();

                if (stack.size() == MAX_MOVES) {
                    System.out.println(stack);
                    return;
                }
            }
        }
    }

    public void waitForInput() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try {
            br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        KnightsTour tour = new KnightsTour();
        //tour.showBoard();
        tour.startTour();
    }
}

