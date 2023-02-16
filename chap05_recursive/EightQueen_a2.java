package chap05_recursive;

import java.awt.Point;

public class EightQueen_a2 {

    private static final int BOARD_SIZE = 8;
    private Point[] queens;  // Use Point array to store the positions of the queens

    public EightQueen_a2() {
        queens = new Point[BOARD_SIZE];
    }

    public void solve() {
        if (placeQueen(0)) {  // Start with the first row and attempt to place queens recursively
            printQueens();
        } else {
            System.out.println("No solution found.");
        }
    }

    private boolean placeQueen(int row) {
        if (row == BOARD_SIZE) {  // We have placed a queen in every row and have a solution
            return true;
        }

        for (int col = 0; col < BOARD_SIZE; col++) {  // Try placing a queen in each column in the current row
            queens[row] = new Point(col, row);  // Create a new Point object to represent the current queen
            if (isValid(row, col) && placeQueen(row + 1)) {  // Check if the placement is valid and recursively call placeQueen for the next row
                return true;
            }
        }

        return false;  // We couldn't place a queen in any of the columns in the current row
    }

    private boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {  // Check all the previously placed queens
            Point queen = queens[i];  // Get the position of the queen as a Point object
            if (queen.x == col || queen.y == row || Math.abs(queen.x - col) == Math.abs(queen.y - row)) {
                // Check if the queen is in the same column, row, or diagonal as the current queen
                return false;  // The placement is invalid
            }
        }
        return true;  // The placement is valid
    }

    private void printQueens() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                Point queen = queens[i];  // Get the position of the queen in the current row
                if (queen.x == j && queen.y == i) {  // Check if the current position is where the queen is placed
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        EightQueen_a2 eq = new EightQueen_a2();
        eq.solve();
    }

}
