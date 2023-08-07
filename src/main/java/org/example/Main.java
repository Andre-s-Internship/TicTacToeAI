package org.example;

import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        char[][] matrix = createEmptyDeck();

        Scanner sc = new Scanner(System.in);
        System.out.println("Input command:");
        String input = sc.nextLine();
        String[] strings = input.split(" ");

        if(input.equals("exit")) System.exit(0);
        if(strings.length != 3) {
            System.out.println("Bad parameters!");
            menu();
        }

        Player player1;
        Player player2;

        if(strings[0].equals("start") &&
                Set.of("user", "easy", "medium", "hard").contains(strings[1]) &&
                Set.of("user", "easy", "medium", "hard").contains(strings[2])) {

            player1 = switch (strings[1]) {
                case "easy" -> new EasyAI();
                case "user" -> new User();
                case "medium" -> new MediumAI();
                default -> new HardAI();
            };

            player2 = switch (strings[2]) {
                case "easy" -> new EasyAI();
                case "user" -> new User();
                case "medium" -> new MediumAI();
                default -> new HardAI();
            };

            printMatrix(matrix);
            play(matrix, player1, player2);
        } else {
            System.out.println("Bad parameters!");
            menu();
        }
    }

    public static void play(char[][] matrix, Player player1, Player player2){
        while(checkWinner(matrix).equals("Game not finished")) {
            matrix = player1.play(matrix, 'X');
            printMatrix(matrix);
            if(checkWinner(matrix).equals("Game not finished")) {
                matrix = player2.play(matrix, 'O');
                printMatrix(matrix);
                if(checkCharWinner(matrix, 'O')) {
                    System.out.println(checkWinner(matrix));
                    return;
                }
            } else {
                System.out.println(checkWinner(matrix));
                return;
            }
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

        if(notFull(matrix)){
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

    static void printMatrix(char[][] matrix) {
        System.out.println("-----------");
        for(int i = 0; i < 3; i++){
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
        if(yourChar == 'O') return 'X';
        else return 'O';
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