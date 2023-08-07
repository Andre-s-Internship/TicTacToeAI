package org.example;

import java.util.Random;

import static tictactoe.Main.checkWinner;

public class EasyAI extends Player{
    @Override
    public char[][] play(char[][] matrix, char yourChar) {
            if(checkWinner(matrix).equals("Game not finished")) {
                System.out.println("Making move level \"easy\"");
                matrix = randomMoveGenerator(matrix, yourChar);
            }
            return matrix;
    }

    public static char[][] randomMoveGenerator(char[][] matrix, char yourChar) {
        Random random = new Random();
        while(true) {
            int row = random.nextInt(matrix.length);
            int col = random.nextInt(matrix.length);
            if(matrix[row][col] == ' ') {
                matrix[row][col] = yourChar;
                return matrix;
            }
        }
    }
}
