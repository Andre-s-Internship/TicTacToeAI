package org.example;

import java.util.Scanner;

import static org.example.Matrix.checkWinner;
import static org.example.Matrix.printMatrix;

public class User implements Player {

    @Override
    public char[][] makeMove(char[][] matrix, char playerChar) {
        if (checkWinner(matrix).equals(Result.GAMENOTFINISHED)) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the coordinates:");
            int row = -1;
            int column = -1;
            if (sc.hasNextInt() && sc.hasNextInt()) {
                row = sc.nextInt();
                column = sc.nextInt();
            } else {
                System.out.println("You should enter numbers!");
                makeMove(matrix, playerChar);
            }

            if (row > 3 || row < 1 || column > 3 || column < 1) {
                System.out.println("Coordinates should be from 1 to 3!");
                makeMove(matrix, playerChar);
            } else if (matrix[row - 1][column - 1] != ' ') {
                System.out.println("This cell is occupied! Choose another one!");
                makeMove(matrix, playerChar);

            } else {
                matrix[row - 1][column - 1] = playerChar;
                if (checkWinner(matrix).toString().equals(playerChar + " wins")) {
                    printMatrix(matrix);
                    System.out.println(checkWinner(matrix).toString());
                    return matrix;
                } else if (checkWinner(matrix).toString().equals("Draw")) {
                    printMatrix(matrix);
                    System.out.println(checkWinner(matrix).toString());
                    return matrix;
                }
            }
        } else if (checkWinner(matrix).equals(Result.IMPOSSIBLE)) {
            System.out.println("This matrix is not valid");
        } else if (checkWinner(matrix).equals(Result.DRAW)) {
            System.out.println("It is a draw!");
        }
        return matrix;
    }
}
