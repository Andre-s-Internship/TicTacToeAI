package org.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class EasyAITest {

    @Test
    public void testRandomMoveGenerator() {
        Random mockRandom = Mockito.mock(Random.class);

        Mockito.when(mockRandom.nextInt(Mockito.anyInt())).thenReturn(1);
        Matrix resultMatrix1 = EasyAI.randomMoveGenerator(new Matrix(), 'X', mockRandom);
        Mockito.when(mockRandom.nextInt(Mockito.anyInt())).thenReturn(2);
        Matrix resultMatrix2 = EasyAI.randomMoveGenerator(new Matrix(), 'O', mockRandom);
        Mockito.when(mockRandom.nextInt(Mockito.anyInt())).thenReturn(0);
        Matrix resultMatrix3 = EasyAI.randomMoveGenerator(new Matrix(), 'O', mockRandom);
        assertEquals('X', resultMatrix1.getChar(1, 1));
        assertEquals('O', resultMatrix2.getChar(2, 2));
        assertEquals('O', resultMatrix3.getChar(0, 0));
    }
    @Test
    public void testMakeMove() {
        Player easyAI = new EasyAI('X');
        Matrix matrix = easyAI.makeMove(new Matrix());
        assertFalse(Arrays.deepEquals(matrix.getInstance(), new char[3][3]));
    }
}