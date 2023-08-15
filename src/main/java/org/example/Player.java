package org.example;

public abstract class Player {

    private char playerChar;

    public char getPlayerChar() {
        return playerChar;
    }

    Player(char playerChar) {
        this.playerChar = playerChar;
    }

    public abstract Matrix makeMove(Matrix matrix);

    public static Player createPlayer(String playerType, char playerChar) {
        return switch (playerType) {
            case "easy" -> new EasyAI(playerChar);
            case "user" -> new User(playerChar);
            case "medium" -> new MediumAI(playerChar);
            default -> new HardAI(playerChar);
        };
    }
}
