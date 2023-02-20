package chap05_recursive;

import java.awt.Point;

public class test01 {
    
    // Define the size of the chessboard
    private static final int BOARD_SIZE = 8;
    
    // Store the positions of the queens on the chessboard
    private static Point[] queens = new Point[BOARD_SIZE];
    
    public static void main(String[] args) {
        // Try to place the queens and print the solution if successful
        boolean success = placeQueens(0);
        if (success) {
            printBoard();
        } else {
            System.out.println("No solution found.");
        }
    }
    
    // Recursive backtracking algorithm to find a valid solution
    private static boolean placeQueens(int row) {
        // If all rows have been filled with queens, a solution has been found
        if (row == BOARD_SIZE) {
            return true;
        }
        // Try placing the queen in each column of the current row
        for (int col = 0; col < BOARD_SIZE; col++) {
            Point point = new Point(col, row);
            if (isValid(point)) { // Check if this position is valid
                queens[row] = point; // Place the queen at this position
                if (placeQueens(row+1)) { // Recursively move to the next row
                    return true; // A valid solution was found
                }
            }
        }
        return false; // No valid solution was found for this row
    }
    
    // Check whether a potential queen position conflicts with previous queens
    private static boolean isValid(Point point) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            Point queen = queens[i];
            if (queen != null && (queen.x == point.x || queen.y == point.y || 
                    queen.x - queen.y == point.x - point.y ||
                    queen.x + queen.y == point.x + point.y)) {
                // The new queen would be in conflict with a previously placed queen
                return false;
            }
        }
        return true; // The new queen position is valid
    }
    
    // Print out the solution as a simple ASCII chessboard
    private static void printBoard() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                if (queens[row] != null && queens[row].x == col) {
                    System.out.print("Q ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }
}
