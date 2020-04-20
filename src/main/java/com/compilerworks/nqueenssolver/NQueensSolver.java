package com.compilerworks.nqueenssolver;

import static com.compilerworks.nqueenssolver.Utils.validateArgumentAndGetBoardSize;
import static java.lang.Math.abs;

/**
 * This class solves the Classic N Queens Problem and prints the different unique positions.
 * It has an option of only printing the non-collinear solutions, i.e. solutions where the
 * queens are not in a straight line.
 */
public class NQueensSolver {

    private final boolean onlyNonCollinearSolutions;
    private final int boardSize;
    private final NBoard board;

    private long solutions = 0L;

    public NQueensSolver(final int boardSize, final boolean onlyNonCollinearSolutions) {
        this.boardSize = boardSize;
        this.board = new NBoard(boardSize);
        this.onlyNonCollinearSolutions = onlyNonCollinearSolutions;
    }

    public static void main(String[] args) {
        final int boardSize = validateArgumentAndGetBoardSize(args);
        if (boardSize > 0) {
            final long startTime = System.currentTimeMillis();
            final NQueensSolver nQueensSolver = new NQueensSolver(boardSize, true);
            nQueensSolver.solve();
            System.out.println("(Processing time was " + (System.currentTimeMillis() - startTime) + "ms)");
        }
    }

    public void solve() {
        if (boardSize == 1) {
            solutions = 1;
            System.out.println("\n 1 \nThere is just one place to put one queen on a 1x1 board.");
        } else {
            solveQueenPositionsStartingByFirstColumnRow(0);
            System.out.println(
                    String.format("\nThere are %d unique %sways of placing %d queens.",
                            solutions, onlyNonCollinearSolutions ? "non-collinear " : "", boardSize));
        }
    }

    /**
     * The leftmost column is the starting point to start checking for ways of placing the queens.
     * Start by placing the queen on the topmost row and then going down recursively.
     * @param firstColumnRow the row at which the queen is placed at the leftmost row.
     */
    private void solveQueenPositionsStartingByFirstColumnRow(final int firstColumnRow) {
        board.placeQueen(0, firstColumnRow);
        solveQueenPositionsStartingByColumn(1);

        if (firstColumnRow < (boardSize - 1)) {
            solveQueenPositionsStartingByFirstColumnRow(firstColumnRow + 1);
        }
    }

    /**
     * Given that the queen on the first column has already been placed at a particular row, place the queen
     * on the second column topmost row and then go down, while checking if it is safe to do so. The process
     * is recursively repeated on all columns and if the queen can be safely placed on the last column, then
     * a solution would have been found.
     * @param column the column at which the queen is going to be placed.
     */
    private void solveQueenPositionsStartingByColumn(int column) {
        for (int row = 0; row < boardSize; row++) {
            if (isSafeToPutQueen(column, row)) {
                board.placeQueen(column, row);
                if (column == boardSize - 1) {
                    if (board.printBoard(onlyNonCollinearSolutions)) solutions++;
                } else {
                    solveQueenPositionsStartingByColumn(column + 1);
                }
            }
        }
    }

    /**
     * Determine whether a queen placed at a particular row and column is under attack
     * by other queens on the left columns.
     */
    private boolean isSafeToPutQueen(final int column, final int row) {
        for (int columnIndex = 0; columnIndex < column; columnIndex++) {
            for (int rowIndex = 0; rowIndex < boardSize; rowIndex++) {
                if (board.isQueenAt(columnIndex, rowIndex)) {
                    if (rowIndex == row) return false; // same row, different column with another queen
                    if (abs(column - columnIndex) == abs(row - rowIndex)) return false; // at a diagonal to another queen
                }
            }
        }
        return true;
    }

    public long getSolutions() {
        return this.solutions;
    }

}