package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @Test
    @DisplayName("Test for checkWinner - impossible 1")
    void checkWinnerImpossible1() {
        char[][] initialMatrix = {{'X', 'X', 'O'}, {'X', 'X', 'O'}, {' ', ' ', ' '}};
        Matrix matrix = new Matrix(initialMatrix);
        assertEquals("Impossible", matrix.checkWinner().toString());
    }

    @Test
    @DisplayName("Test for checkWinner - impossible 2")
    void checkWinnerImpossible2() {
        char[][] initialMatrix = {{'X', 'X', 'X'}, {'O', 'O', 'O'}, {' ', ' ', ' '}};
        Matrix matrix = new Matrix(initialMatrix);
        assertEquals("Impossible", matrix.checkWinner().toString());
    }

    @Test
    @DisplayName("Test for checkWinner - impossible 3")
    void checkWinnerImpossible3() {
        char[][] initialMatrix = {{'O', 'X', 'O'}, {'X', 'O', 'O'}, {' ', 'O', ' '}};
        Matrix matrix = new Matrix(initialMatrix);
        assertEquals("Impossible", matrix.checkWinner().toString());
    }

    @Test
    @DisplayName("Test for checkWinner - impossible 4")
    void checkWinnerImpossible4() {
        char[][] initialMatrix = {{'X', 'O', 'O'}, {'X', 'X', 'O'}, {'X', ' ', 'X'}};
        Matrix matrix = new Matrix(initialMatrix);
        assertEquals("Impossible", matrix.checkWinner().toString());
    }

    @Test
    @DisplayName("Test for checkWinner - X wins 1")
    void checkWinnerXWins1() {
        char[][] initialMatrix = {{'X', 'X', 'X'}, {'O', 'X', 'O'}, {'O', ' ', ' '}};
        Matrix matrix = new Matrix(initialMatrix);
        assertEquals("X wins", matrix.checkWinner().toString());
    }

    @Test
    @DisplayName("Test for checkWinner - X wins 2")
    void checkWinnerXWins2() {
        char[][] initialMatrix = {{'X', ' ', 'O'}, {' ', 'X', 'O'}, {'X', 'O', 'X'}};
        Matrix matrix = new Matrix(initialMatrix);
        assertEquals("X wins", matrix.checkWinner().toString());
    }

    @Test
    @DisplayName("Test for checkWinner - X wins 3")
    void checkWinnerXWins3() {
        char[][] initialMatrix = {{'O', 'O', 'X'}, {'X', 'X', 'O'}, {'X', ' ', 'O'}};
        Matrix matrix = new Matrix(initialMatrix);
        assertEquals("X wins", matrix.checkWinner().toString());
    }

    @Test
    @DisplayName("Test for checkWinner - O wins 1")
    void checkWinnerOWins1() {
        char[][] initialMatrix = {{'O', 'X', 'X'}, {'O', 'O', 'O'}, {' ', 'X', ' '}};
        Matrix matrix = new Matrix(initialMatrix);

        assertEquals("O wins", matrix.checkWinner().toString());
    }

    @Test
    @DisplayName("Test for checkWinner - O wins 2")
    void checkWinnerOWins2() {
        char[][] initialMatrix = {{'O', ' ', 'X'}, {'X', 'O', ' '}, {' ', 'X', 'O'}};
        Matrix matrix = new Matrix(initialMatrix);
        assertEquals("O wins", matrix.checkWinner().toString());
    }

    @Test
    @DisplayName("Test for checkWinner - O wins 3")
    void checkWinnerOWins3() {
        char[][] initialMatrix = {{'X', ' ', 'O'}, {' ', 'O', 'X'}, {'O', ' ', 'X'}};
        Matrix matrix = new Matrix(initialMatrix);
        assertEquals("O wins", matrix.checkWinner().toString());
    }

    @Test
    @DisplayName("Test for checkWinner - Game not finished 1")
    void checkWinnerNotFinished1() {
        char[][] initialMatrix = {{'O', 'X', 'X'}, {'O', ' ', 'O'}, {' ', 'X', ' '}};
        Matrix matrix = new Matrix(initialMatrix);
        assertEquals("Game not finished", matrix.checkWinner().toString());
    }

    @Test
    @DisplayName("Test for checkWinner - Game not finished 2")
    void checkWinnerNotFinished2() {
        char[][] initialMatrix = {{'O', ' ', ' '}, {'X', 'X', ' '}, {' ', 'X', 'O'}};
        Matrix matrix = new Matrix(initialMatrix);
        assertEquals("Game not finished", matrix.checkWinner().toString());
    }

    @Test
    @DisplayName("Test for checkWinner - Game not finished 3")
    void checkWinnerNotFinished3() {
        char[][] initialMatrix = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        Matrix matrix = new Matrix(initialMatrix);

        assertEquals("Game not finished", matrix.checkWinner().toString());
    }

    @Test
    @DisplayName("Test for checkWinner - Draw 1")
    void checkWinnerDraw1() {
        char[][] initialMatrix = {{'O', 'X', 'O'}, {'X', 'X', 'O'}, {'X', 'O', 'X'}};
        Matrix matrix = new Matrix(initialMatrix);

        assertEquals("Draw", matrix.checkWinner().toString());
    }

    @Test
    @DisplayName("Test for checkWinner - Draw 2")
    void checkWinnerDraw2() {
        char[][] initialMatrix = {{'X', 'O', 'X'}, {'O', 'O', 'X'}, {'O', 'X', 'O'}};
        Matrix matrix = new Matrix(initialMatrix);

        assertEquals("Draw", matrix.checkWinner().toString());
    }

    @Test
    @DisplayName("Test for checkWinner - Draw 3")
    void checkWinnerDraw3() {
        char[][] initialMatrix = {{'X', 'O', 'O'}, {'O', 'X', 'X'}, {'X', 'O', 'O'}};
        Matrix matrix = new Matrix(initialMatrix);

        assertEquals("Draw", matrix.checkWinner().toString());
    }

    @Test
    @DisplayName("Test for checkCharWinner 1")
    void checkCharWinner1() {
        char[][] initialMatrix = {{'X', 'X', 'X'}, {'O', 'X', 'O'}, {'O', ' ', ' '}};
        Matrix matrix = new Matrix(initialMatrix);

        assertTrue(matrix.checkCharWinner('X'));
    }

    @Test
    @DisplayName("Test for checkCharWinner 2")
    void checkCharWinner2() {
        char[][] initialMatrix = {{'X', 'O', 'X'}, {'O', 'O', 'X'}, {' ', 'X', 'X'}};
        Matrix matrix = new Matrix(initialMatrix);

        assertTrue(matrix.checkCharWinner('X'));
    }

    @Test
    @DisplayName("Test for checkCharWinner 3")
    void checkCharWinner3() {
        char[][] initialMatrix = {{'X', ' ', 'O'}, {' ', 'O', 'X'}, {'O', ' ', 'X'}};

        Matrix matrix = new Matrix(initialMatrix);
        assertTrue(matrix.checkCharWinner('O'));
    }

    @Test
    @DisplayName("Test for checkCharWinner 4")
    void checkCharWinner4() {
        char[][] initialMatrix = {{'O', 'X', 'X'}, {'O', 'X', 'X'}, {'O', 'O', 'O'}};
        Matrix matrix = new Matrix(initialMatrix);
        assertTrue(matrix.checkCharWinner('O'));
    }

    @Test
    @DisplayName("Test for checkCharWinner 5")
    void checkCharWinner5() {
        char[][] initialMatrix = {{'X', 'O', 'X'}, {'O', 'O', 'X'}, {' ', 'X', 'X'}};
        Matrix matrix = new Matrix(initialMatrix);
        assertTrue(matrix.checkCharWinner('X'));
    }

    @Test
    @DisplayName("Test for checkCharWinner 6")
    void checkCharWinner6() {
        char[][] initialMatrix = {{'X', 'O', 'X'}, {'X', 'O', 'X'}, {' ', 'O', ' '}};
        Matrix matrix = new Matrix(initialMatrix);

        assertTrue(matrix.checkCharWinner('O'));
    }

    @Test
    @DisplayName("Test for checkCharWinner 7")
    void checkCharWinner7() {
        char[][] initialMatrix = {{'O', 'X', 'X'}, {'O', ' ', 'O'}, {'O', 'X', ' '}};
        Matrix matrix = new Matrix(initialMatrix);

        assertTrue(matrix.checkCharWinner('O'));
    }

    @Test
    @DisplayName("Test for otherChar X")
    void otherCharX() {
        assertEquals('X', Matrix.otherChar('O'));
    }

    @Test
    @DisplayName("Test for otherChar O")
    void otherCharO() {
        assertEquals('O', Matrix.otherChar('X'));
    }

    @Test
    @DisplayName("Test for printMatrix")
    void printMatrix() {
        char[][] initialMatrix = {{'O', 'X', 'X'}, {'O', ' ', 'O'}, {'O', 'X', ' '}};
        Matrix matrix = new Matrix(initialMatrix);
        StringBuilder s = new StringBuilder();
        s.append("-----------").append("\n");
        for (char[] chars : matrix.getInstance()) {
            s.append("| ").append(chars[0]).append(" ").append(chars[1]).append(" ").append(chars[2]).append(" |").append("\n");
        }
        s.append("-----------").append("\n");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        matrix.printMatrix();
        String outputStreamString = outputStream.toString();
        assertEquals(s.toString(), outputStreamString);
    }

    @Test
    @DisplayName("Test for notFull true")
    void notFullTrue() {
        char[][] initialMatrix = {{'O', 'X', 'X'}, {'O', ' ', 'O'}, {'O', 'X', ' '}};
        Matrix matrix = new Matrix(initialMatrix);

        assertTrue(matrix.notFull());
    }

    @Test
    @DisplayName("Test for notFull false")
    void notFullFalse() {
        char[][] initialMatrix = {{'O', 'X', 'X'}, {'O', 'X', 'O'}, {'O', 'X', 'O'}};
        Matrix matrix = new Matrix(initialMatrix);

        assertFalse(matrix.notFull());
    }


}
