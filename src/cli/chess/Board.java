package cli.chess;

import pieces.*;

public class Board {

    private final int boardSize = 8;

    //Pass list of pieces to draw on board.
    //Will add 'dead pieces' on side of board.
    public void showBoard(Piece[][] array) {
        System.out.println("_________________________________________________________________________");
        System.out.println("                    --------------------------------------");
        for (int i = 0; i < boardSize; i++) {

            System.out.println("                    | " + array[i][0].getPieceIcon() + " | " + array[i][1].getPieceIcon() + " | " + array[i][2].getPieceIcon() + " | " + array[i][3].getPieceIcon()
                    + " | " + array[i][4].getPieceIcon() + " | " + array[i][5].getPieceIcon() + " | " + array[i][6].getPieceIcon() + " | " + array[i][7].getPieceIcon() + " |");
            System.out.println("                    --------------------------------------");
        }
        System.out.println("_________________________________________________________________________");
    }

    //I'm well aware there is 9 spaces on the blank rows... still figuring out a solution to the blank space...
    public void demoBoard() {
        System.out.println("_________________________________________________________________________");
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
        System.out.println("_________________________________________________________________________");

    }
}
