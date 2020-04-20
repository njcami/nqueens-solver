package com.compilerworks.nqueenssolver;

import java.util.regex.Pattern;

/**
 * Utility class
 */
public class Utils {

    private static final String GREATER_THAN_ZERO_DIGIT_REGEX = "^[1-9]\\d*$";

    /**
     * Validates that first argument exists and is a natural number greater than zero.
     * @param args the command line arguments
     * @return a positive integer value from the first argument or -1 if no valid board size found
     */
    public static int validateArgumentAndGetBoardSize(final String[] args) {
        if (args == null || args.length == 0 || args[0] == null || args[0].length() == 0) {
            System.out.println("\nNo board size entered, exiting. To run via gradle with board size = 8 and 8 queens, type: gradle run --args=\"8\"");
        } else if (Pattern.matches(GREATER_THAN_ZERO_DIGIT_REGEX, args[0])) {
            return Integer.parseInt(args[0]);
        } else {
            System.out.println("\nPlease enter a numeric value for the board size and queens amount, greater than zero.");
        }
        return -1;
    }

    /**
     * If three points are on a straight line, the would be triangle formed by the points would have a zero area.
     * More information here: https://www.geeksforgeeks.org/program-check-three-points-collinear
     * @param board the board for which non-collinear solutions are going to be checked
     * @return true if the solution is non-collinear
     */
    public static boolean isNonCollinear(final int[] board) {
        int size = board.length;
        for (int a = 0; a < size - 2; a++) {
            for (int b = a + 1; b < size - 1; b++) {
                for (int c = b + 1; c < size; c++) {
                    if (((board[a]*(b-c)) + (board[b]*(c-a)) + (board[c]*(a-b))) == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
