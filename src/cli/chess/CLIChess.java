package cli.chess;

import java.util.Scanner;

public class CLIChess {

    //Entry point for program. Initialise game instance.
    public static void main(String[] args) {
        Game game = new Game();
        game.initGame();
    }
}
