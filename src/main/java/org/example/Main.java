package org.example;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Insert the starting position as a line");


        char[][] matrix = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = ' ';
            }
        }
        printMatrix(matrix);
        play(matrix);
    }
    public static void play(char[][] matrix){
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
                play(matrix);
            }
            if (row > 3 || row < 1 || column > 3 || column < 1) {
                System.out.println("Coordinates should be from 1 to 3!");
                play(matrix);
            }
            else if (matrix[row - 1][column - 1] != ' ') {
                System.out.println("This cell is occupied! Choose another one!");
                play(matrix);

            }
            else { matrix[row - 1][column - 1] = 'X';
                if(checkWinner(matrix).equals("X wins")) {
                    printMatrix(matrix);
                    System.out.println(checkWinner(matrix));
                    return;
                } else if (checkWinner(matrix).equals("Draw")) {
                    printMatrix(matrix);
                    System.out.println(checkWinner(matrix));
                    return;
                } else {
                    printMatrix(matrix);
                    System.out.println("Making move level \"easy\"");
                    matrix = playEasy(matrix);
                    if(checkWinner(matrix).equals("O wins")) {
                        printMatrix(matrix);
                        System.out.println(checkWinner(matrix));
                        return;
                    }
                    printMatrix(matrix);
                    play(matrix);
                }
            }
            play(matrix);
        } else if(checkWinner(matrix).equals("Impossible")) {
            System.out.println("This matrix is not valid");
        } else if(checkWinner(matrix).equals("Draw")) {
            System.out.println("It is a draw!");
        }
    }

    public static String checkWinner(char[][] matrix) {
        if (Math.abs(countXOs(matrix, 'X') - countXOs(matrix, 'O')) > 1) {
            return "Impossible";
        }
        if (checkCharWinner(matrix, 'X') && checkCharWinner(matrix, 'O')) {
            return "Impossible";
        }

        if(checkCharWinner(matrix, 'X')) {
            return "X wins";
        }

        if(checkCharWinner(matrix, 'O')) {
            return "O wins";
        }

        if(contains(matrix)){
            return "Game not finished";
        }
        return "Draw";
    }

    public static boolean checkCharWinner(char[][] matrix, char character) {
        if(matrix[0][0] == character && matrix[0][1] == character && matrix[0][2] == character) {
            return true;
        }
        if (matrix[1][0] == character && matrix[1][1] == character && matrix[1][2] == character) {
            return true;
        }
        if (matrix[2][0] == character && matrix[2][1] == character && matrix[2][2] == character) {
            return true;
        }
        if(matrix[0][0] == character && matrix[1][0] == character && matrix[2][0] == character) {
            return true;
        }
        if(matrix[0][1] == character && matrix[1][1] == character && matrix[2][1] == character) {
            return true;
        }
        if(matrix[0][2] == character && matrix[1][2] == character && matrix[2][2] == character) {
            return true;
        }
        if(matrix[0][0] == character && matrix[1][1] == character && matrix[2][2] == character) {
            return true;
        }
        if(matrix[2][0] == character && matrix[1][1] == character && matrix[0][2] == character) {
            return true;
        }
        return false;
    }

    public static int countXOs(char[][] matrix, char character) {
        int characterCount = 0;
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                if (aChar == character) {
                    characterCount++;
                }
            }
        }
        return characterCount;
    }

    public static void printMatrix(char[][] matrix) {
        System.out.println("-----------");
        for(int i = 0; i < 3; i++){
            System.out.println("| " + matrix[i][0] + " " + matrix[i][1] + " " + matrix[i][2] + " |");
        }
        System.out.println("-----------");
    }

    public static boolean contains(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                if (aChar == ' ') {
                    return true;
                }
            }
        }
        return false;
    }

    public static char[][] playEasy(char[][] matrix) {
        Random random = new Random();
        while(true) {
            int row = random.nextInt(matrix.length);
            int col = random.nextInt(matrix.length);
            if(matrix[row][col] == ' ') {
                matrix[row][col] = 'O';
                return matrix;
            }
        }
    }
}
