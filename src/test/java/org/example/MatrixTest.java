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
        char[][] matrix = {{'X', 'X', 'O'}, {'X', 'X', 'O'}, {' ', ' ', ' '}};
        assertEquals("Impossible", Matrix.checkWinner(matrix).toString());
    }

    @Test
    @DisplayName("Test for checkWinner - impossible 2")
    void checkWinnerImpossible2() {
        char[][] matrix = {{'X', 'X', 'X'}, {'O', 'O', 'O'}, {' ', ' ', ' '}};
        assertEquals("Impossible", Matrix.checkWinner(matrix).toString());
    }

    @Test
    @DisplayName("Test for checkWinner - impossible 3")
    void checkWinnerImpossible3() {
        char[][] matrix = {{'O', 'X', 'O'}, {'X', 'O', 'O'}, {' ', 'O', ' '}};
        assertEquals("Impossible", Matrix.checkWinner(matrix).toString());
    }

    @Test
    @DisplayName("Test for checkWinner - impossible 4")
    void checkWinnerImpossible4() {
        char[][] matrix = {{'X', 'O', 'O'}, {'X', 'X', 'O'}, {'X', ' ', 'X'}};
        assertEquals("Impossible", Matrix.checkWinner(matrix).toString());
    }

    @Test
    @DisplayName("Test for checkWinner - X wins 1")
    void checkWinnerXWins1() {
        char[][] matrix = {{'X', 'X', 'X'}, {'O', 'X', 'O'}, {'O', ' ', ' '}};
        assertEquals("X wins", Matrix.checkWinner(matrix).toString());
    }

    @Test
    @DisplayName("Test for checkWinner - X wins 2")
    void checkWinnerXWins2() {
        char[][] matrix = {{'X', ' ', 'O'}, {' ', 'X', 'O'}, {'X', 'O', 'X'}};
        assertEquals("X wins", Matrix.checkWinner(matrix).toString());
    }

    @Test
    @DisplayName("Test for checkWinner - X wins 3")
    void checkWinnerXWins3() {
        char[][] matrix = {{'O', 'O', 'X'}, {'X', 'X', 'O'}, {'X', ' ', 'O'}};
        assertEquals("X wins", Matrix.checkWinner(matrix).toString());
    }

    @Test
    @DisplayName("Test for checkWinner - O wins 1")
    void checkWinnerOWins1() {
        char[][] matrix = {{'O', 'X', 'X'}, {'O', 'O', 'O'}, {' ', 'X', ' '}};
        assertEquals("O wins", Matrix.checkWinner(matrix).toString());
    }

    @Test
    @DisplayName("Test for checkWinner - O wins 2")
    void checkWinnerOWins2() {
        char[][] matrix = {{'O', ' ', 'X'}, {'X', 'O', ' '}, {' ', 'X', 'O'}};
        assertEquals("O wins", Matrix.checkWinner(matrix).toString());
    }

    @Test
    @DisplayName("Test for checkWinner - O wins 3")
    void checkWinnerOWins3() {
        char[][] matrix = {{'X', ' ', 'O'}, {' ', 'O', 'X'}, {'O', ' ', 'X'}};
        assertEquals("O wins", Matrix.checkWinner(matrix).toString());
    }

    @Test
    @DisplayName("Test for checkWinner - Game not finished 1")
    void checkWinnerNotFinished1() {
        char[][] matrix = {{'O', 'X', 'X'}, {'O', ' ', 'O'}, {' ', 'X', ' '}};
        assertEquals("Game not finished", Matrix.checkWinner(matrix).toString());
    }

    @Test
    @DisplayName("Test for checkWinner - Game not finished 2")
    void checkWinnerNotFinished2() {
        char[][] matrix = {{'O', ' ', ' '}, {'X', 'X', ' '}, {' ', 'X', 'O'}};
        assertEquals("Game not finished", Matrix.checkWinner(matrix).toString());
    }

    @Test
    @DisplayName("Test for checkWinner - Game not finished 3")
    void checkWinnerNotFinished3() {
        char[][] matrix = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        assertEquals("Game not finished", Matrix.checkWinner(matrix).toString());
    }

    @Test
    @DisplayName("Test for checkWinner - Draw 1")
    void checkWinnerDraw1() {
        char[][] matrix = {{'O', 'X', 'O'}, {'X', 'X', 'O'}, {'X', 'O', 'X'}};
        assertEquals("Draw", Matrix.checkWinner(matrix).toString());
    }

    @Test
    @DisplayName("Test for checkWinner - Draw 2")
    void checkWinnerDraw2() {
        char[][] matrix = {{'X', 'O', 'X'}, {'O', 'O', 'X'}, {'O', 'X', 'O'}};
        assertEquals("Draw", Matrix.checkWinner(matrix).toString());
    }

    @Test
    @DisplayName("Test for checkWinner - Draw 3")
    void checkWinnerDraw3() {
        char[][] matrix = {{'X', 'O', 'O'}, {'O', 'X', 'X'}, {'X', 'O', 'O'}};
        assertEquals("Draw", Matrix.checkWinner(matrix).toString());
    }

    @Test
    @DisplayName("Test for checkCharWinner 1")
    void checkCharWinner1() {
        char[][] matrix = {{'X', 'X', 'X'}, {'O', 'X', 'O'}, {'O', ' ', ' '}};
        assertTrue(Matrix.checkCharWinner(matrix, 'X'));
    }

    @Test
    @DisplayName("Test for checkCharWinner 2")
    void checkCharWinner2() {
        char[][] matrix = {{'X', 'O', 'X'}, {'O', 'O', 'X'}, {' ', 'X', 'X'}};
        assertTrue(Matrix.checkCharWinner(matrix, 'X'));
    }

    @Test
    @DisplayName("Test for checkCharWinner 3")
    void checkCharWinner3() {
        char[][] matrix = {{'X', ' ', 'O'}, {' ', 'O', 'X'}, {'O', ' ', 'X'}};
        assertTrue(Matrix.checkCharWinner(matrix, 'O'));
    }

    @Test
    @DisplayName("Test for checkCharWinner 4")
    void checkCharWinner4() {
        char[][] matrix = {{'O', 'X', 'X'}, {'O', 'X', 'X'}, {'O', 'O', 'O'}};
        assertTrue(Matrix.checkCharWinner(matrix, 'O'));
    }

    @Test
    @DisplayName("Test for checkCharWinner 5")
    void checkCharWinner5() {
        char[][] matrix = {{'X', 'O', 'X'}, {'O', 'O', 'X'}, {' ', 'X', 'X'}};
        assertTrue(Matrix.checkCharWinner(matrix, 'X'));
    }

    @Test
    @DisplayName("Test for checkCharWinner 6")
    void checkCharWinner6() {
        char[][] matrix = {{'X', 'O', 'X'}, {'X', 'O', 'X'}, {' ', 'O', ' '}};
        assertTrue(Matrix.checkCharWinner(matrix, 'O'));
    }

    @Test
    @DisplayName("Test for checkCharWinner 7")
    void checkCharWinner7() {
        char[][] matrix = {{'O', 'X', 'X'}, {'O', ' ', 'O'}, {'O', 'X', ' '}};
        assertTrue(Matrix.checkCharWinner(matrix, 'O'));
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
        char[][] matrix = {{'O', 'X', 'X'}, {'O', ' ', 'O'}, {'O', 'X', ' '}};
        StringBuilder s = new StringBuilder();
        s.append("-----------").append("\n");
        for (char[] chars : matrix) {
            s.append("| ").append(chars[0]).append(" ").append(chars[1]).append(" ").append(chars[2]).append(" |").append("\n");
        }
        s.append("-----------").append("\n");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        Matrix.printMatrix(matrix);
        String outputStreamString = outputStream.toString();
        assertEquals(s.toString(), outputStreamString);
    }

    @Test
    @DisplayName("Test for notFull true")
    void notFullTrue() {
        char[][] matrix = {{'O', 'X', 'X'}, {'O', ' ', 'O'}, {'O', 'X', ' '}};
        assertTrue(Matrix.notFull(matrix));
    }

    @Test
    @DisplayName("Test for notFull false")
    void notFullFalse() {
        char[][] matrix = {{'O', 'X', 'X'}, {'O', 'X', 'O'}, {'O', 'X', 'O'}};
        assertFalse(Matrix.notFull(matrix));
    }


}
