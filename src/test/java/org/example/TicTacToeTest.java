package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {

    @Test
    void testGame() {
        String input = "start easy hard";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        TicTacToe.menu();
        String outputStreamString = outputStream.toString();
        assertTrue(outputStreamString.contains("O wins"));
        assertTrue(outputStreamString.contains("Making move level \"easy\""));
        assertTrue(outputStreamString.contains("Making move level \"hard\""));
    }

    @Test
    void testGame1() {
        String input = "start easy medium";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        TicTacToe.main(new String[0]);
        String outputStreamString = outputStream.toString();
        assertTrue(outputStreamString.contains("Making move level \"easy\""));
        assertTrue(outputStreamString.contains("Making move level \"medium\""));
    }
}
