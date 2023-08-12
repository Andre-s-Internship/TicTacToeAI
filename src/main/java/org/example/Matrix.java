package org.example;

public class Matrix {

    static Result checkWinner(char[][] matrix) {
        if (Math.abs(countXOs(matrix, 'X') - countXOs(matrix, 'O')) > 1) {
            return Result.IMPOSSIBLE;
        }
        if (checkCharWinner(matrix, 'X') && checkCharWinner(matrix, 'O')) {
            return Result.IMPOSSIBLE;
        }

        if (checkCharWinner(matrix, 'X')) {
            return Result.XWINS;
        }

        if (checkCharWinner(matrix, 'O')) {
            return Result.OWINS;
        }

        if (notFull(matrix)) {
            return Result.GAMENOTFINISHED;
        }
        return Result.DRAW;
    }

    static boolean checkCharWinner(char[][] matrix, char character) {
        if (matrix[0][0] == character && matrix[0][1] == character && matrix[0][2] == character) {
            return true;
        }
        if (matrix[1][0] == character && matrix[1][1] == character && matrix[1][2] == character) {
            return true;
        }
        if (matrix[2][0] == character && matrix[2][1] == character && matrix[2][2] == character) {
            return true;
        }
        if (matrix[0][0] == character && matrix[1][0] == character && matrix[2][0] == character) {
            return true;
        }
        if (matrix[0][1] == character && matrix[1][1] == character && matrix[2][1] == character) {
            return true;
        }
        if (matrix[0][2] == character && matrix[1][2] == character && matrix[2][2] == character) {
            return true;
        }
        if (matrix[0][0] == character && matrix[1][1] == character && matrix[2][2] == character) {
            return true;
        }
        if (matrix[2][0] == character && matrix[1][1] == character && matrix[0][2] == character) {
            return true;
        }
        return false;
    }

    static int countXOs(char[][] matrix, char character) {
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

    static void printMatrix(char[][] matrix) {
        System.out.println("-----------");
        for (int i = 0; i < 3; i++) {
            System.out.println("| " + matrix[i][0] + " " + matrix[i][1] + " " + matrix[i][2] + " |");
        }
        System.out.println("-----------");
    }

    static boolean notFull(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                if (aChar == ' ') {
                    return true;
                }
            }
        }
        return false;
    }

    static char otherChar(char yourChar) {
        if (yourChar == 'O') {
            return 'X';
        } else {
            return 'O';
        }
    }

    static char[][] createEmptyDeck() {
        char[][] matrix = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = ' ';
            }
        }
        return matrix;
    }
}
