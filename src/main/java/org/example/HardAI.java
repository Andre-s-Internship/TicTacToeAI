package org.example;

import static tictactoe.Main.*;

public class HardAI extends Player {
    @Override
    public char[][] play(char[][] matrix, char yourChar) {
        System.out.println("Making move level \"hard\"");
        int[] bestMove = getBestMove(matrix, yourChar);
        matrix[bestMove[0]][bestMove[1]] = yourChar;
        return matrix;
    }

    public int[] getBestMove(char[][] matrix, char yourChar) {
        int[] bestMove = new int[]{-1, -1};
        int bestScore = (yourChar == 'X') ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == ' ') {
                    matrix[i][j] = yourChar;
                    int score = minimax(matrix, 10, otherChar(yourChar));
                    matrix[i][j] = ' ';

                    if ((yourChar == 'X' && score > bestScore) || (yourChar == 'O' && score < bestScore)) {
                        bestScore = score;
                        bestMove[0] = i;
                        bestMove[1] = j;
                    }
                }
            }
        }
        return bestMove;
    }

    public static int minimax(char[][] matrix, int depth, char yourChar) {

        if (checkWinner(matrix).equals("X wins")) {
            return 10;
        }
        if (checkWinner(matrix).equals("O wins")) {
            return -10;
        }
        if (checkWinner(matrix).equals("Draw")) {
            return 0;
        }

        if (yourChar == 'X') {
            int highestVal = Integer.MIN_VALUE;
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix.length; col++) {
                    if (matrix[row][col] == ' ') {
                        matrix[row][col] = 'X';
                        highestVal = Math.max(highestVal, minimax(matrix, depth - 1, 'O'));
                        matrix[row][col] = ' ';
                    }
                }
            }
            return highestVal;
        } else {
            int lowestVal = Integer.MAX_VALUE;
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix.length; col++) {
                    if (matrix[row][col] == ' ') {
                        matrix[row][col] = 'O';
                        lowestVal = Math.min(lowestVal, minimax(matrix, depth - 1, 'X'));
                        matrix[row][col] = ' ';
                    }
                }
            }
            return lowestVal;
        }
    }
}
