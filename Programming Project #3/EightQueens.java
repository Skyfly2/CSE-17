
/*
 * CSE 17 Fall 2019
 * @author Asher Hamrick
 * Programming Assignment #3
 * Program: Eight Queens
 */
import java.util.*;

public class EightQueens {
    static int count = 0;

    /**
     * Take user input and run the eight queens recursive method
     * 
     * @param args arguments
     */
    public static void main(String[] args) {
        int size = 0;
        try {
            size = Integer.parseInt(args[0]);
            if (size > 8 || size < 1) {
                throw new IllegalArgumentException();
            } else {
                // Create board
                boolean[][] board = new boolean[size][size];

                // Initial call of recursive method
                findPlacements(board, 0);
                System.out.println("There are " + count + " solutions");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter an integer (1-8) through the command line.");
        } catch (IllegalArgumentException e) {
            System.out.println("Please enter an integer no less than 1 and no greater than 8.");
        }

    }

    /**
     * Recursive function to determine where to place the queens
     * 
     * @param board the board
     * @param row   current row on the board
     * @return true
     */
    public static boolean findPlacements(boolean board[][], int row) {
        // Base case (all queens have been placed) print board
        if (row == board[0].length) {
            // Loop through board
            for (int c = 0; c < board.length; c++) {
                System.out.println("");
                for (int i = 0; i < board[0].length; i++) {
                    if (board[c][i]) {
                        System.out.print(" Q ");
                    } else {
                        System.out.print(" * ");
                    }
                }
            }
            System.out.println("");
            count++;
            return true;
        } else {
            // Loop through each column of the row
            for (int c = 0; c < board.length; c++) {
                // If you can place a queen, place it, if not, don't (backtrack)
                if (canPlace(board, row, c)) {
                    board[row][c] = true;
                    // Recursive call with placed queen
                    findPlacements(board, row + 1);
                    // Restore spot for next pass
                    board[row][c] = false;
                }
            }
            return false;
        }
    }

    /**
     * Determine if a queen can be placed in a specific spot
     * 
     * @param board the board
     * @param row   the current row
     * @param col   the current column
     * @return true or false if you can or can't place a queen
     */
    public static boolean canPlace(boolean[][] board, int row, int col) {
        if (row == 0) {
            // All spots in the first row have nothing to do with the other spots, so they
            // can be placed
            return true;
        } else {
            // Loop through board
            for (int c = 0; c < board.length; c++) {
                for (int i = 0; i < board[0].length; i++) {
                    if (board[c][i]) {
                        // Check to see if current spot is on an attack path of another queen
                        if (row == c || col == i) {
                            return false;
                        } else if (Math.abs(row - c) == Math.abs(col - i)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}