package org.example;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class MediumAITest {

    @Test
    public void testInstantWin1() {
        char[][] matrix = {{'X', ' ', ' '}, {' ', 'O', 'X'}, {'O', ' ', 'X'}};
        char[][] wonMatrix = {{'X', ' ', 'O'}, {' ', 'O', 'X'}, {'O', ' ', 'X'}};
        Matrix initialMatrix = new Matrix(matrix);
        Matrix instantWin = MediumAI.instantWin(initialMatrix, 'O');
        assertTrue(Arrays.deepEquals(wonMatrix, instantWin.getInstance()));
    }
    @Test
    public void testPreventLoss1() {
        char[][] initialMatrix = {{'X', ' ', ' '},
                                    {' ', 'O', 'X'},
                                    {'O', ' ', ' '}};

        char[][] preventLossForX = {{'X', ' ', 'X'},
                                    {' ', 'O', 'X'},
                                    {'O', ' ', ' '}};
        Matrix matrix = new Matrix(initialMatrix);
        Matrix preventLoss = new Matrix(preventLossForX);
        Matrix instantWin = MediumAI.instantWin(matrix, 'X');
        MediumAI mediumAI = new MediumAI('X');
        Matrix preventLoss1 = mediumAI.makeMove(preventLoss);
        assertNull(instantWin);
        assertNotNull(preventLoss1);
        assertTrue(Arrays.deepEquals(preventLossForX, preventLoss1.getInstance()));
    }

    @Test
    public void testInstantWin2() {
        MediumAI mediumAI = new MediumAI('O');
        char[][] matrix1 = {{'X', ' ', ' '},
                           {' ', 'O', 'X'},
                           {'O', ' ', ' '}};
        Matrix matrix = new Matrix(matrix1);
        assertTrue(Arrays.deepEquals(MediumAI.instantWin(matrix, 'O').getInstance(), mediumAI.makeMove(matrix).getInstance()));
    }
    @Test
    public void testPreventLoss2() {
        MediumAI mediumAI = new MediumAI('X');
        char[][] matrix1 = {{'X', ' ', ' '},
                           {' ', 'O', 'X'},
                           {'O', ' ', ' '}};
        Matrix matrix = new Matrix(matrix1);
        assertTrue(Arrays.deepEquals(MediumAI.preventLoss(matrix, 'X').getInstance(), mediumAI.makeMove(matrix).getInstance()));
    }


}