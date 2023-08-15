package org.example;

import static org.example.Matrix.*;

public class HardAI extends Player {

    HardAI(char playerChar) {
        super(playerChar);
    }

    @Override
    public Matrix makeMove(Matrix matrix) {
        System.out.println("Making move level \"hard\"");
        int[] bestMove = getBestMove(matrix);
        matrix.performMove(this.getPlayerChar(), bestMove[0], bestMove[1]);
        return matrix;
    }

    private int[] getBestMove(Matrix matrix) {
        int[] bestMove = new int[]{-1, -1};
        int bestScore = (super.getPlayerChar() == 'X') ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix.getChar(i, j) == ' ') {
                    matrix.performMove(this.getPlayerChar(), i, j);
                    int score = minimax(matrix, 10, otherChar(this.getPlayerChar()));
                    matrix.performMove(' ', i, j);

                    if ((super.getPlayerChar() == 'X' && score > bestScore) || (this.getPlayerChar() == 'O' && score < bestScore)) {
                        bestScore = score;
                        bestMove[0] = i;
                        bestMove[1] = j;
                    }
                }
            }
        }
        return bestMove;
    }

    private static int minimax(Matrix matrix, int depth, char yourChar) {

        if (matrix.checkWinner().equals(Result.XWINS)) {
            return 10;
        }
        if (matrix.checkWinner().equals(Result.OWINS)) {
            return -10;
        }
        if (matrix.checkWinner().equals(Result.DRAW)) {
            return 0;
        }

        if (yourChar == 'X') {
            int highestVal = Integer.MIN_VALUE;
            for (int row = 0; row < matrix.length(); row++) {
                for (int col = 0; col < matrix.length(); col++) {
                    if (matrix.getChar(row, col) == ' ') {
                        matrix.performMove('X', row, col);
                        highestVal = Math.max(highestVal, minimax(matrix, depth - 1, 'O'));
                        matrix.performMove(' ', row, col);
                    }
                }
            }
            return highestVal;
        } else {
            int lowestVal = Integer.MAX_VALUE;
            for (int row = 0; row < matrix.length(); row++) {
                for (int col = 0; col < matrix.length(); col++) {
                    if (matrix.getChar(row, col) == ' ') {
                        matrix.performMove('O', row, col);
                        lowestVal = Math.min(lowestVal, minimax(matrix, depth - 1, 'X'));
                        matrix.performMove(' ', row, col);
                    }
                }
            }
            return lowestVal;
        }
    }
}
