package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testUser() {
        String input = "1 1";
        Player user = new User();
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        char[][] matrix = {{'X', ' ', ' '},
                            {' ', ' ', ' '},
                            {' ', ' ', ' '}};
        char[][] userMatrix = user.makeMove(Matrix.createEmptyDeck(), 'X');
        assertTrue(Arrays.deepEquals(matrix, userMatrix));
    }

}




