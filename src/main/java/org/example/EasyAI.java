package org.example;

import java.util.Random;

import static org.example.Matrix.checkWinner;

public class EasyAI implements Player {

    @Override
    public char[][] makeMove(char[][] matrix, char playerChar) {
        if (checkWinner(matrix).equals(Result.GAMENOTFINISHED)) {
            System.out.println("Making move level \"easy\"");
            matrix = randomMoveGenerator(matrix, playerChar);
        }
        return matrix;
    }

    public static char[][] randomMoveGenerator(char[][] matrix, char yourChar) {
        Random random = new Random();
        while (true) {
            int row = random.nextInt(matrix.length);
            int col = random.nextInt(matrix.length);
            if (matrix[row][col] == ' ') {
                matrix[row][col] = yourChar;
                return matrix;
            }
        }
    }
}
