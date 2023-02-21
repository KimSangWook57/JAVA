package chap05_recursive;

import java.util.List;

public class MazeExitFinder {
    public static void main(String[] args) {
        // Define the maze as a 2D array of integers
        int[][] maze = {
            {1, 0, 0, 0, 0},
            {1, 1, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 1, 1},
            {0, 0, 0, 0, 2}
        };

        // Create a new MazeSolver object with the maze
        MazeSolver mazeSolver = new MazeSolver(maze);

        // Find the solution path using the MazeSolver object
        List<int[]> solution = mazeSolver.solve();

        // Print the solution path
        if (solution == null) {
            System.out.println("No solution found");
        } else {
            System.out.println("Solution:");
            for (int[] pos : solution) {
                System.out.println("(" + pos[0] + ", " + pos[1] + ")");
            }
        }
    }
}
