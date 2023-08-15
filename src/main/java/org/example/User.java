package org.example;

import java.util.Scanner;


public class User extends Player {

    User(char playerChar) {
        super(playerChar);
    }

    @Override
    public Matrix makeMove(Matrix matrix) {
        if (matrix.checkWinner().equals(Result.GAMENOTFINISHED)) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the coordinates:");
            int row = -1;
            int column = -1;

            if (sc.hasNextInt() && sc.hasNextInt()) {
                row = sc.nextInt();
                column = sc.nextInt();
                if (row > 3 || row < 1 || column > 3 || column < 1) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    makeMove(matrix);
                } else if (matrix.getChar(row - 1, column - 1) != ' ') {
                    System.out.println("This cell is occupied! Choose another one!");
                    makeMove(matrix);
                }
            } else {
                System.out.println("You should enter numbers!");
                makeMove(matrix);
            }

            matrix.performMove(this.getPlayerChar(), row - 1, column - 1);

            if (matrix.checkWinner().toString().equals(this.getPlayerChar() + " wins")) {
                matrix.printMatrix();
                System.out.println(matrix.checkWinner().toString());
                return matrix;
            } else if (matrix.checkWinner().toString().equals("Draw")) {
                matrix.printMatrix();
                System.out.println(matrix.checkWinner().toString());
                return matrix;
            }

        } else if (matrix.checkWinner().equals(Result.IMPOSSIBLE)) {
            System.out.println("This matrix is not valid");
        }
        else if (matrix.checkWinner().equals(Result.DRAW)) {
            System.out.println("It is a draw!");
        }
        return matrix;
    }
}
