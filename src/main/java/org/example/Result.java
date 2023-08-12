package org.example;

public enum Result {
    IMPOSSIBLE {
        @Override
        public String toString() {
            return "Impossible";
        }
    },
    GAMENOTFINISHED{
        @Override
        public String toString() {
            return "Game not finished";
        }
    },
    XWINS{
        @Override
        public String toString() {
            return "X wins";
        }
    },
    OWINS{
        @Override
        public String toString() {
            return "O wins";
        }
    },
    DRAW{
        @Override
        public String toString() {
            return "Draw";
        }
    }
}
