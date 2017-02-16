package cli.chess;

import java.util.Scanner;

public class CLIChess {

    //Entry point for program. Initialise game instance.
    public static void main(String[] args) {
        Game newGame = new Game();
        newGame.initGame();
    }
}
