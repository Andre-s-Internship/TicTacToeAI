package org.example;

import org.example.FourthStage.EasyAI;

import static org.example.Main.*;

public class MediumAI extends Player {
    @Override
    public char[][] play(char[][] matrix, char yourChar) {
        if (checkWinner(matrix).equals("Game not finished")) {
            System.out.println("Making move level \"medium\"");
            //1st rule
            //Instant win
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
            //2nd rule
            //Prevent loss
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
            //3rd rule
            //Do random move
            matrix = EasyAI.randomMoveGenerator(matrix, yourChar);
        }
        return matrix;
    }
}
