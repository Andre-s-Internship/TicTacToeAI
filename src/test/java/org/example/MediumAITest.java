package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MediumAITest {

    @Test
    public void testInstantWin1() {
        char[][] matrix = {{'X', ' ', ' '}, {' ', 'O', 'X'}, {'O', ' ', 'X'}};
        char[][] wonMatrix = {{'X', ' ', 'O'}, {' ', 'O', 'X'}, {'O', ' ', 'X'}};
        char[][] instantWin = MediumAI.instantWin(matrix, 'O');
        assertTrue(Arrays.deepEquals(wonMatrix, instantWin));
    }
    @Test
    public void testPreventLoss1() {
        char[][] matrix = {{'X', ' ', ' '},
                           {' ', 'O', 'X'},
                           {'O', ' ', ' '}};
        char[][] preventLossForX = {{'X', ' ', 'X'},
                                    {' ', 'O', 'X'},
                                    {'O', ' ', ' '}};
        char[][] instantWin = MediumAI.instantWin(matrix, 'X');
        char[][] preventLoss = MediumAI.preventLoss(matrix, 'X');
        assertNull(instantWin);
        assertNotNull(preventLoss);
        assertTrue(Arrays.deepEquals(preventLossForX, preventLoss));
    }

    @Test
    public void testInstantWin2() {
        MediumAI mediumAI = new MediumAI();
        char[][] matrix = {{'X', ' ', ' '},
                           {' ', 'O', 'X'},
                           {'O', ' ', ' '}};
        assertTrue(Arrays.deepEquals(MediumAI.instantWin(matrix, 'O'), mediumAI.makeMove(matrix, 'O')));
    }
    @Test
    public void testPreventLoss2() {
        MediumAI mediumAI = new MediumAI();
        char[][] matrix = {{'X', ' ', ' '},
                           {' ', 'O', 'X'},
                           {'O', ' ', ' '}};
        assertTrue(Arrays.deepEquals(MediumAI.preventLoss(matrix, 'X'), mediumAI.makeMove(matrix, 'X')));
    }


}