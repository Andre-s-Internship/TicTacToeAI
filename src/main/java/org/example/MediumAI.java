package org.example;

import java.util.Random;

import static org.example.Matrix.*;

public class MediumAI extends Player {

    MediumAI(char playerChar) {
        super(playerChar);
    }

    @Override
    public Matrix makeMove(Matrix matrix) {
        if (matrix.checkWinner().equals(Result.GAME_NOT_FINISHED)) {
            System.out.println("Making move level \"medium\"");
            Matrix instantWin = instantWin(matrix, this.getPlayerChar());
            if (instantWin != null) {
                return instantWin;
            }
            Matrix preventLoss = preventLoss(matrix, this.getPlayerChar());
            if (preventLoss != null) {
                return preventLoss;
            }
            matrix = EasyAI.randomMoveGenerator(matrix, this.getPlayerChar(), new Random());
        }
        return matrix;
    }

    static Matrix preventLoss(Matrix matrix, char yourChar) {
        for (int i = 0; i < matrix.length(); i++) {
            for (int j = 0; j < matrix.length(); j++) {
                if (matrix.getChar(i, j) == ' ') {
                    matrix.performMove(otherChar(yourChar), i, j);
                    if (matrix.checkCharWinner(otherChar(yourChar))) {
                        matrix.performMove(yourChar, i, j);
                        return matrix;
                    } else {
                        matrix.performMove(' ', i, j);
                    }
                }
            }
        }
        return null;
    }
    static Matrix instantWin(Matrix matrix, char yourChar) {
        for (int i = 0; i < matrix.length(); i++) {
            for (int j = 0; j < matrix.length(); j++) {
                if (matrix.getChar(i, j) == ' ') {
                    matrix.performMove(yourChar, i, j);
                    if (matrix.checkCharWinner(yourChar)) {
                        return matrix;
                    } else {
                        matrix.performMove(' ', i, j);
                    }
                }
            }
        }
        return null;
    }
}