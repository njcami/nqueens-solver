package com.compilerworks.nqueenssolver;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NQueensSolverTest {

    @Test
    public void testNQueensSolverWithBoardSize1() {
        final NQueensSolver nQueensSolver = new NQueensSolver(1, true);
        nQueensSolver.solve();
        assertEquals(1L, nQueensSolver.getSolutions(),
                "With board size equal to 1, there is only 1 solution.");

        final NQueensSolver nQueensSolverAllSolutions = new NQueensSolver(1, false);
        nQueensSolverAllSolutions.solve();
        assertEquals(1L, nQueensSolverAllSolutions.getSolutions(),
                "With board size equal to 1 and all solutions, there should still be 1 solution.");
    }

    @Test
    public void testNQueensSolverWithBoardSize4() {
        final NQueensSolver nQueensSolver = new NQueensSolver(4, true);
        nQueensSolver.solve();
        assertEquals(2L, nQueensSolver.getSolutions(),
                "With board size equal to 4, there should be 2 solutions.");

        final NQueensSolver nQueensSolverAllSolutions = new NQueensSolver(4, false);
        nQueensSolverAllSolutions.solve();
        assertEquals(2L, nQueensSolverAllSolutions.getSolutions(),
                "With board size equal to 4 and all solutions, there should still be 2 solutions.");
    }

    @Test
    public void testNQueensSolverWithBoardSize8() {
        final NQueensSolver nQueensSolver = new NQueensSolver(8, true);
        nQueensSolver.solve();
        assertEquals(8L, nQueensSolver.getSolutions(),
                "With board size equal to 8, there should be 8 non-collinear solutions.");

        final NQueensSolver nQueensSolverAllSolutions = new NQueensSolver(8, false);
        nQueensSolverAllSolutions.solve();
        assertEquals(92L, nQueensSolverAllSolutions.getSolutions(),
                "With board size equal to 8 and all solutions, there should be 92 solutions.");
    }

    @Test
    public void testThatMainMethodDoesNotThrowExceptionWithNoOrWrongArguments() {
        NQueensSolver.main(null);
        NQueensSolver.main(new String[0]);
        NQueensSolver.main(new String[]{"unexpected argument"});
        NQueensSolver.main(new String[]{"-10"});
        NQueensSolver.main(new String[]{"-9.78945"});
        NQueensSolver.main(new String[]{"0.4545329"});
    }

    @Test
    public void testThatWithNoArgumentsAMinusOneIsReturned() {
        assertEquals(-1, Utils.validateArgumentAndGetBoardSize(null));
        final String[] args = new String[0];
        assertEquals(-1, Utils.validateArgumentAndGetBoardSize(args));
    }

    @Test
    public void testThatWithNonNumericArgumentAMinusOneIsReturned() {
        final String[] args = new String[1];
        args[0] = "Non numeric argument";
        assertEquals(-1, Utils.validateArgumentAndGetBoardSize(args));
    }

    @Test
    public void testForNonCollinearity() {
        assertFalse(Utils.isNonCollinear(new int[] {4, 2, 0, 3, 1}));
        assertTrue(Utils.isNonCollinear(new int[] {1, 3, 0, 2}));
    }

}
