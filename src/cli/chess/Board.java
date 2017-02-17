package cli.chess;

import pieces.*;

public class Board {

    //Pass list of pieces to draw on board
    //Currently placeholders, will add proper pieces later
    public void showBoard(Piece[][] array) {
        System.out.println("_________________________________________________________________________");
        System.out.println("                    --------------------------------------");
        for (int i = 0; i < 8; i++) {
            System.out.println("                    | " + array[i][0].getPieceType() + " | " + array[i][1].getPieceType() + " | " + array[i][2].getPieceType() + " | " + array[i][3].getPieceType() +
                    " | " + array[i][4].getPieceType() + " | " + array[i][5].getPieceType() + " | " + array[i][6].getPieceType() + " | " + array[i][7].getPieceType() + " |");
            System.out.println("                    --------------------------------------");
        }
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
