package chap05_recursive;

import java.util.*;

public class MazeSolver {
    // Fields
    private int[][] maze; // The maze
    private Set<String> visited; // Set of visited positions
    private List<int[]> solution; // List of positions that form the solution

    // Constructor
    public MazeSolver(int[][] maze) {
        this.maze = maze; // Initialize the maze field
        this.visited = new HashSet<>(); // Initialize the visited set
        this.solution = new ArrayList<>(); // Initialize the solution list
    }

    // Main method
    public List<int[]> solve() {
        int[] startPos = findStartPos(); // Find the starting position
        backtrack(startPos[0], startPos[1]); // Find the solution path from the starting position
        return solution; // Return the solution path
    }

    // Private recursive method
    private boolean backtrack(int x, int y) {
        // Base case: position has already been visited
        if (visited.contains(x + "," + y)) {
            return false;
        }
        // Base case: position is the goal
        if (isGoal(x, y)) {
            solution.add(new int[]{x, y});
            return true;
        }
        // Recursive case: position has not been visited and is not the goal
        visited.add(x + "," + y); // Mark position as visited
        solution.add(new int[]{x, y}); // Add position to the solution path
        // Generate list of possible moves from current position
        for (int[] nextPos : getPossibleMoves(x, y)) {
            // Recursively call backtrack with the next position
            if (backtrack(nextPos[0], nextPos[1])) {
                return true; // Goal has been found
            }
        }
        // Goal has not been found, remove current position from solution path and backtrack
        solution.remove(solution.size()-1);
        return false;
    }

    // Private helper method to find the starting position
    private int[] findStartPos() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] == 1) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    // Private helper method to check if a position is the goal
    private boolean isGoal(int x, int y) {
        return maze[x][y] == 2;
    }

    // Private helper method to generate a list of possible moves from a position
    private List<int[]> getPossibleMoves(int x, int y) {
        List<int[]> moves = new ArrayList<>();
        if (x > 0 && maze[x-1][y] == 0) {
            moves.add(new int[]{x-1, y});
        }
        if (x < maze.length-1 && maze[x+1][y] == 0) {
            moves.add(new int[]{x+1, y});
        }
        if (y > 0 && maze[x][y-1] == 0) {
            moves.add(new int[]{x, y-1});
        }
        if (y < maze[0].length-1 && maze[x][y+1] == 0) {
            moves.add(new int[]{x, y+1});
        }
        return moves;
    }
}
