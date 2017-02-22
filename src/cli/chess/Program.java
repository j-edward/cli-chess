package cli.chess;

public class Program {

    //Entry point for program. Initialise game instance.
    public static void main(String[] args) {
        Game game = new Game();
        game.initGame();
    }
}
