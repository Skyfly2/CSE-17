import java.util.*;

public class EightQueens {
    static int count = 0;

    public static void main(String[] args) {
        int size = 0;
        boolean go = false;
        do {
            try {
                size = Integer.parseInt(args[0]);
            } catch (InputMismatchException e) {
                go = true;
            }
        } while (go);

        boolean[][] board = new boolean[size][size];

        findPlacements(board, 0);
        System.out.println("There are " + count + " solutions");
    }

    public static boolean findPlacements(boolean board[][], int row) {
        if (row == board[0].length) {
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
            for (int c = 0; c < board.length; c++) {
                if (canPlace(board, row, c)) {
                    board[row][c] = true;
                    findPlacements(board, row + 1);
                    board[row][c] = false;
                }
            }
            return false;
        }
    }

    public static boolean canPlace(boolean[][] board, int row, int col) {
        if (row == 0) {
            return true;
        } else {
            for (int c = 0; c < board.length; c++) {
                for (int i = 0; i < board[0].length; i++) {
                    if (board[c][i]) {
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