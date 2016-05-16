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

    public KnightsTour() {
        board = new Square[BOARD_SIZE][BOARD_SIZE];
        int squareNumber = 0;
        for (int y = 0; y < BOARD_SIZE; y++) {
            for (int x = 0; x < BOARD_SIZE; x++) {
                board[y][x] = new Square(squareNumber++, y, x);
            }
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
    private Square findValidMoveAndMarkVisited(Square currentPosition) {
        Square validMove = null;
        int r = 0, c = 0;

        int row = currentPosition.getRow();
        int column = currentPosition.getColumn();

        // Possible knight move 1
        r = row - 2;
        c = column - 1;
        if (r >= 0 && r < BOARD_SIZE && c >= 0 && c < BOARD_SIZE && !board[r][c].isVisited()) {
            validMove = board[r][c];
            return validMove;
        }

        // Possible knight move 2
        r = row - 2;
        c = column + 1;
        if (r >= 0 && r < BOARD_SIZE && c >= 0 && c < BOARD_SIZE && !board[r][c].isVisited()) {
            validMove = board[r][c];
            return validMove;
        }

        // Possible knight move 3
        r = row - 1;
        c = column + 2;
        if (r >= 0 && r < BOARD_SIZE && c >= 0 && c < BOARD_SIZE && !board[r][c].isVisited()) {
            validMove = board[r][c];
            return validMove;
        }

        // Possible knight move 4
        r = row + 1;
        c = column + 2;
        if (r >= 0 && r < BOARD_SIZE && c >= 0 && c < BOARD_SIZE && !board[r][c].isVisited()) {
            validMove = board[r][c];
            return validMove;
        }

        // Possible knight move 5
        r = row + 2;
        c = column + 1;
        if (r >= 0 && r < BOARD_SIZE && c >= 0 && c < BOARD_SIZE && !board[r][c].isVisited()) {
            validMove = board[r][c];
            return validMove;
        }

        // Possible knight move 6
        r = row + 2;
        c = column - 1;
        if (r >= 0 && r < BOARD_SIZE && c >= 0 && c < BOARD_SIZE && !board[r][c].isVisited()) {
            validMove = board[r][c];
            return validMove;
        }

        // Possible knight move 7
        r = row + 1;
        c = column - 2;
        if (r >= 0 && r < BOARD_SIZE && c >= 0 && c < BOARD_SIZE && !board[r][c].isVisited()) {
            validMove = board[r][c];
            return validMove;
        }

        // Possible knight move 8
        r = row - 1;
        c = column - 2;
        if (r >= 0 && r < BOARD_SIZE && c >= 0 && c < BOARD_SIZE && !board[r][c].isVisited()) {
            validMove = board[r][c];
            return validMove;
        }

        return validMove;
    }

    public void startTour() {
        Square firstMove = board[2][2];
        Square nextMove;
        firstMove.setVisited(true);
        stack.push(firstMove);
        while (!stack.isEmpty()) {
            nextMove = findValidMoveAndMarkVisited(stack.peek());
            if (nextMove == null) {
                stack.pop();
            } else {
                nextMove.setVisited(true);
                stack.push(nextMove);
                System.out.println("Last move : " + nextMove.getSquareNumber());
                showBoard();
                waitForInput();
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

