package org.example;

import static tictactoe.Main.*;

public class MediumAI extends Player{
    @Override
    public char[][] play(char[][] matrix, char yourChar) {
        if (checkWinner(matrix).equals("Game not finished")) {
            System.out.println("Making move level \"medium\"");
            //1st rule
            //Instant win
            char[][] instantWin = instantWin(matrix, yourChar);
            if(instantWin != null) return instantWin;
            //2nd rule
            //Prevent loss
            char[][] preventLoss = preventLoss(matrix, yourChar);
            if(preventLoss != null) return preventLoss;
            //3rd rule
            //Do random move
            matrix = EasyAI.randomMoveGenerator(matrix, yourChar);
        }
        return matrix;
    }

    static char[][] instantWin(char[][] matrix, char yourChar) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == ' ') {
                    matrix[i][j] = otherChar(yourChar);
                    if (checkCharWinner(matrix, otherChar(yourChar))) {
                        matrix[i][j] = yourChar;
                        return matrix;
                    } else matrix[i][j] = ' ';
                }
            }
        }
        return null;
    }

    static char[][] preventLoss(char[][] matrix, char yourChar) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == ' ') {
                    matrix[i][j] = yourChar;
                    if (checkWinner(matrix).equals(yourChar + " wins")) {
                        return matrix;
                    } else matrix[i][j] = ' ';
                }
            }
        }
        return null;
    }
}