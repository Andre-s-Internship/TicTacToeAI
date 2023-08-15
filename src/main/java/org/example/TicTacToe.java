package org.example;

import java.util.Scanner;
import java.util.Set;


public class TicTacToe {
    private static final String INPUT = "Input command";
    private static final String BAD_PARAMETERS = "Bad parameters!";
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {

        Matrix matrix = new Matrix();

        Scanner sc = new Scanner(System.in);
        System.out.println(INPUT);
        String input = sc.nextLine();
        String[] strings = input.split(" ");

        if (input.equals("exit")) System.exit(0);
        if (strings.length != 3) {
            System.out.println(BAD_PARAMETERS);
            menu();
        }

        Player player1;
        Player player2;

        if (strings[0].equals("start") &&
                Set.of("user", "easy", "medium", "hard").contains(strings[1]) &&
                Set.of("user", "easy", "medium", "hard").contains(strings[2])) {

            player1 = Player.createPlayer(strings[1], 'X');
            player2 = Player.createPlayer(strings[2], 'O');

            matrix.printMatrix();
            play(matrix, player1, player2);
        } else {
            System.out.println(BAD_PARAMETERS);
            menu();
        }
    }

    public static void play(Matrix matrix, Player player1, Player player2) {
        while (matrix.checkWinner().equals(Result.GAME_NOT_FINISHED)) {
            matrix = player1.makeMove(matrix);
            matrix.printMatrix();
            if (matrix.checkWinner().equals(Result.GAME_NOT_FINISHED)) {
                matrix = player2.makeMove(matrix);
                matrix.printMatrix();
                if (matrix.checkCharWinner('O')) {
                    System.out.println(matrix.checkWinner().toString());
                    return;
                }
            } else {
                System.out.println(matrix.checkWinner().toString());
                return;
            }
        }
    }


}