package org.example;

import org.example.Player;

import java.util.Scanner;

import static org.example.ThirdStage.Main.checkWinner;
import static org.example.ThirdStage.Main.printMatrix;

public class User extends Player {
    @Override
    public char[][] play(char[][] matrix, char yourChar) {
        if(checkWinner(matrix).equals("Game not finished")) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the coordinates:");
            int row = -1;
            int column = -1;
            if (sc.hasNextInt() && sc.hasNextInt()) {
                row = sc.nextInt();
                column = sc.nextInt();
            } else {
                System.out.println("You should enter numbers!");
                play(matrix, yourChar);
            }
            if (row > 3 || row < 1 || column > 3 || column < 1) {
                System.out.println("Coordinates should be from 1 to 3!");
                play(matrix, yourChar);
            }
            else if (matrix[row - 1][column - 1] != ' ') {
                System.out.println("This cell is occupied! Choose another one!");
                play(matrix, yourChar);

            }
            else { matrix[row - 1][column - 1] = yourChar;
                if(checkWinner(matrix).equals(yourChar + " wins")) {
                    printMatrix(matrix);
                    System.out.println(checkWinner(matrix));
                    return matrix;
                } else if (checkWinner(matrix).equals("Draw")) {
                    printMatrix(matrix);
                    System.out.println(checkWinner(matrix));
                    return matrix;
                }
            }
        } else if(checkWinner(matrix).equals("Impossible")) {
            System.out.println("This matrix is not valid");
        } else if(checkWinner(matrix).equals("Draw")) {
            System.out.println("It is a draw!");
        }
        return matrix;
    }
}
