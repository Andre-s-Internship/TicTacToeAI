package org.example;

import java.util.Random;

public class EasyAI extends Player {

    EasyAI(char playerChar) {
        super(playerChar);
    }

    @Override
    public Matrix makeMove(Matrix matrix) {
        if (matrix.checkWinner().equals(Result.GAME_NOT_FINISHED)) {
            System.out.println("Making move level \"easy\"");
            matrix = randomMoveGenerator(matrix, this.getPlayerChar(), new Random());
        }
        return matrix;
    }

    public static Matrix randomMoveGenerator(Matrix matrix, char playerChar, Random random) {
        while (true) {
            int row = random.nextInt(matrix.length());
            int col = random.nextInt(matrix.length());
            if (matrix.getChar(row, col) == ' ') {
                matrix.performMove(playerChar, row, col);
                return matrix;
            }
        }
    }
}
