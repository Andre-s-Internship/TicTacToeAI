package org.example;

import com.sun.source.tree.ModuleTree;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

class EasyAITest {

    @Test
    public void testRandomMoveGenerator() {
        Random mockRandom = Mockito.mock(Random.class);

        Mockito.when(mockRandom.nextInt(Mockito.anyInt())).thenReturn(1);
        char[][] resultMatrix1 = EasyAI.randomMoveGenerator(Matrix.createEmptyDeck(), 'X', mockRandom);
        Mockito.when(mockRandom.nextInt(Mockito.anyInt())).thenReturn(2);
        char[][] resultMatrix2 = EasyAI.randomMoveGenerator(Matrix.createEmptyDeck(), 'O', mockRandom);
        Mockito.when(mockRandom.nextInt(Mockito.anyInt())).thenReturn(0);
        char[][] resultMatrix3 = EasyAI.randomMoveGenerator(Matrix.createEmptyDeck(), 'O', mockRandom);
        assertEquals('X', resultMatrix1[1][1]);
        assertEquals('O', resultMatrix2[2][2]);
        assertEquals('O', resultMatrix3[0][0]);
    }
    @Test
    public void testMakeMove() {
        Player easyAI = new EasyAI();
        char[][] matrix = easyAI.makeMove(Matrix.createEmptyDeck(), 'X');
        assertFalse(Arrays.deepEquals(matrix, new char[3][3]));
    }
}