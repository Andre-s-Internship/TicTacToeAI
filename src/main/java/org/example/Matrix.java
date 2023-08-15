package org.example;

public class Matrix {

    private final char[][] matrix;

    Matrix() {
        matrix = createEmptyDeck();
    }

    Matrix(char[][] initialMatrix) {
        matrix = initialMatrix;
    }

    public void performMove(char playerChar, int row, int col) {
        matrix[row][col] = playerChar;
    }

    public int length() {
        return 3;
    }

    public char[][] getInstance() {
        return matrix;
    }

    public char getChar(int row, int col) {
        return matrix[row][col];
    }

    Result checkWinner() {
        if (Math.abs(countXOs('X') - countXOs('O')) > 1) {
            return Result.IMPOSSIBLE;
        }
        if (checkCharWinner('X') && checkCharWinner('O')) {
            return Result.IMPOSSIBLE;
        }

        if (checkCharWinner('X')) {
            return Result.XWINS;
        }

        if (checkCharWinner('O')) {
            return Result.OWINS;
        }

        if (notFull()) {
            return Result.GAME_NOT_FINISHED;
        }
        return Result.DRAW;
    }

    boolean checkCharWinner(char character) {
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

    int countXOs(char character) {
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

    void printMatrix() {
        System.out.println("-----------");
        for (int i = 0; i < 3; i++) {
            System.out.println("| " + matrix[i][0] + " " + matrix[i][1] + " " + matrix[i][2] + " |");
        }
        System.out.println("-----------");
    }

    boolean notFull() {
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
