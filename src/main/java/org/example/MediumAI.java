package org.example;

import java.util.Random;

import static org.example.Matrix.*;

public class MediumAI implements Player {

    @Override
    public char[][] makeMove(char[][] matrix, char playerChar) {
        if (checkWinner(matrix).equals(Result.GAMENOTFINISHED)) {
            System.out.println("Making move level \"medium\"");
            char[][] instantWin = instantWin(matrix, playerChar);
            if (instantWin != null) {
                return instantWin;
            }char[][] preventLoss = preventLoss(matrix, playerChar);
            if (preventLoss != null) {
                return preventLoss;
            }
            matrix = EasyAI.randomMoveGenerator(matrix, playerChar, new Random());
        }
        return matrix;
    }

    static char[][] preventLoss(char[][] matrix, char yourChar) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == ' ') {
                    matrix[i][j] = otherChar(yourChar);
                    if (checkCharWinner(matrix, otherChar(yourChar))) {
                        matrix[i][j] = yourChar;
                        return matrix;
                    } else {
                        matrix[i][j] = ' ';
                    }
                }
            }
        }
        return null;
    }
    static char[][] instantWin(char[][] matrix, char yourChar) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == ' ') {
                    matrix[i][j] = yourChar;
                    if (checkCharWinner(matrix, yourChar)) {
                        return matrix;
                    } else {
                        matrix[i][j] = ' ';
                    }
                }
            }
        }
        return null;
    }
}