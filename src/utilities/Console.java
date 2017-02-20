package utilities;

public class Console {

    public void promptErrorInvalidColourSelection(char colour) {
        System.out.println("'" + colour + "'" + " is not a valid input. Please try again.");
    }

    public void promptStartingGame(char colour) {
        System.out.println("Starting game for " + colour + " side...");
    }

    public void promptEndGame() {
        System.out.println("Thank you for playing! :)");
    }

    public void promptSelectPiece(char colour) {
        System.out.println(colour + " Player: Please select a piece to move: [1-8, 1-8]");
    }

    public void promptTargetPiece(String pieceName) {
        System.out.println(pieceName + " is selected.");
        System.out.println("Please now enter a destination for the piece: [1-8, 1-8]");
    }

    public void promptErrorPieceMove(String pieceName) {
        System.out.println(pieceName + " is unable to move to that location.");
        System.out.println("");
    }

    public void lineBreak() {
        System.out.println("_________________________________________________________________________");
    }

    public void promptDemo() {
        lineBreak();
        System.out.println("                    -------------------------------------");
        System.out.println("                    | ♜ | ♞ | ♝ | ♛ | ♚ | ♝ | ♞ | ♜ |");
        System.out.println("                    -------------------------------------");
        System.out.println("                    | ♟ | ♟ | ♟ | ♟ | ♟ | ♟ | ♟ | ♟ |");
        System.out.println("                    -------------------------------------");
        System.out.println("                    |   |   |   |   |   |   |   |   |   |");
        System.out.println("                    -------------------------------------");
        System.out.println("                    |   |   |   |   |   |   |   |   |   |");
        System.out.println("                    -------------------------------------");
        System.out.println("                    |   |   |   |   |   |   |   |   |   |");
        System.out.println("                    -------------------------------------");
        System.out.println("                    |   |   |   |   |   |   |   |   |   |");
        System.out.println("                    -------------------------------------");
        System.out.println("                    | ♙ | ♙ | ♙ | ♙ | ♙ | ♙ | ♙ | ♙ |");
        System.out.println("                    -------------------------------------");
        System.out.println("                    | ♖ | ♘ | ♗ | ♕ | ♔ | ♗ | ♘ | ♖ |");
        System.out.println("                    -------------------------------------");
        lineBreak();
        System.out.println("                            Welcome to Chess CLI.");
        System.out.println("                         Created by Joe Howell, 2017.");
        lineBreak();
        System.out.println("");
        System.out.println("Please enter your choice of colour ('W' or 'B') to start.");
    }

}
