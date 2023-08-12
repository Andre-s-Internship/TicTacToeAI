package org.example;

import java.util.Scanner;
import java.util.Set;
import static org.example.Matrix.*;


public class TicTacToe {
    private static final String INPUT = "Input command";
    private static final String BADPARAMETERS = "Bad parameters!";
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {

        char[][] matrix = createEmptyDeck();

        Scanner sc = new Scanner(System.in);
        System.out.println(INPUT);
        String input = sc.nextLine();
        String[] strings = input.split(" ");

        if (input.equals("exit")) System.exit(0);
        if (strings.length != 3) {
            System.out.println(BADPARAMETERS);
            menu();
        }

        Player player1;
        Player player2;

        if (strings[0].equals("start") &&
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
            System.out.println(BADPARAMETERS);
            menu();
        }
    }

    public static void play(char[][] matrix, Player player1, Player player2) {
        while (checkWinner(matrix).equals(Result.GAMENOTFINISHED)) {
            matrix = player1.makeMove(matrix, 'X');
            printMatrix(matrix);
            if (checkWinner(matrix).equals(Result.GAMENOTFINISHED)) {
                matrix = player2.makeMove(matrix, 'O');
                printMatrix(matrix);
                if (checkCharWinner(matrix, 'O')) {
                    System.out.println(checkWinner(matrix).toString());
                    return;
                }
            } else {
                System.out.println(checkWinner(matrix).toString());
                return;
            }
        }
    }


}