package com.compilerworks.nqueenssolver;

import static com.compilerworks.nqueenssolver.Utils.isNonCollinear;

/**
 * The NxN Board for the Classic N Queens problem can have only one queen per column. This makes
 * the board able to be represented in a single array representing the columns, with the value
 * representing the row at which the queen is placed.
 */
public class NBoard {

    private final int size;
    private final int[] board;

    public NBoard(final int size) {
        this.size = size;
        board = new int[size];
    }

    public void placeQueen(final int column, final int row) {
        board[column] = row;
    }

    public boolean isQueenAt(final int column, final int row) {
        return board[column] == row;
    }

    /**
     * Prints the board on the screen in one line format.
     * @param onlyIfNonCollinear print the solution only if it is non-collinear.
     * @return true if printed, false if not.
     */
    public boolean printBoard(boolean onlyIfNonCollinear) {
        if (!onlyIfNonCollinear || isNonCollinear(board)) {
            for (int i : board) {
                System.out.print(" " + i);
            }
            System.out.println();
            return true;
        }
        return false;
    }

}
