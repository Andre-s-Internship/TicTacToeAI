package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testUser() {
        String input = "1 1";
        Player user = new User('X');
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        char[][] matrix = {{'X', ' ', ' '},
                            {' ', ' ', ' '},
                            {' ', ' ', ' '}};
        Matrix userMatrix = user.makeMove(new Matrix());
        assertTrue(Arrays.deepEquals(matrix, userMatrix.getInstance()));
    }
//    @Test
//    void testUser1() {
//        String input = "a b\n1 1";
//        System.setIn(new ByteArrayInputStream(input.getBytes()));
//        Player user = new User('X');
//        char[][] matrix = {{'X', ' ', ' '},
//                            {' ', ' ', ' '},
//                            {' ', ' ', ' '}};
//        Matrix userMatrix = user.makeMove(new Matrix());
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outputStream));
//        assertTrue(outputStream.toString().contains("You should enter numbers!"));
//        assertTrue(Arrays.deepEquals(matrix, userMatrix.getInstance()));
//    }

}




