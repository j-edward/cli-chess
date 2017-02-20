package cli.chess;

import java.util.Scanner;
import pieces.*;

public class Game {

    Board board;
    Scanner scanner = new Scanner(System.in);
    Piece selectedPiece;
    PieceFactory pieceFactory = new PieceFactory();
    String player1Input;
    boolean playAgain;
    char userColour;
    char oppColour;
    int turn;

    //Creates pieces, and maps out game.
    //Additionally asks user for side preference.
    public void initGame() {

        System.out.println("                            Welcome to Chess CLI.");
        System.out.println("                         Created by Joe Howell, 2017.");
        System.out.println("_________________________________________________________________________");
        System.out.println("");
        System.out.println("Please enter your choice of colour ('W' or 'B') to start.");

        playAgain = true;
        while (playAgain) {
            userColour = scanner.nextLine().toUpperCase().charAt(0);
            System.out.println("_________________________________________________________________________");
            switch (userColour) {
                case 'B':
                    turn = 1;
                    startGame();
                    break;
                case 'W':
                    turn = 0;
                    startGame();
                    break;
                case 'E':
                    playAgain = false;
                    System.out.println("Thank you for playing! :)");
                    break;
                default:
                    System.out.println("'" + userColour + "'" + " is not a valid input. Please try again.");
            }
        }
    }

    //Starts game with user choices.
    public void startGame() {
        boolean gameOver;
        board = new Board(userColour, oppColour);

        System.out.println("Starting game for " + userColour + " side...");

        gameOver = false;
        do {
            board.showBoard();

            //Start turn
            switch (turn % 2) {
                case 0:
                    //P1 turn.
                    doTurn(userColour);
                    break;
                case 1:
                    //CPU turn.
                    doTurn(oppColour);
                    break;
            }

            //Do collision detection.
            //End of turn, increment turn value.
            turn++;

        } while (!gameOver);
        System.out.println("Thank you for playing! :)");
    }

    //Turn functionality.
    public void doTurn(char colour) {
        boolean isLegal;
        int rowSelec;
        int colSelec;
        int tarRow;
        int tarCol;
        String input;
        String pieceName;

        //Will add input validation later!
        //Select piece.
        do {
            System.out.println(colour + " Player: Please select a piece to move: [1-8, 1-8]");
            input = scanner.nextLine();
            rowSelec = Character.getNumericValue(input.charAt(1) - 1);
            colSelec = Character.getNumericValue(input.charAt(0) - 1);
            isLegal = board.selectPiece(rowSelec, colSelec, colour);
            if (isLegal) {
                selectedPiece = board.getPieceArray()[rowSelec][colSelec];
            }
            System.out.println("");
        } while (!isLegal);

        pieceName = selectedPiece.getClass().getCanonicalName().substring(7);
        //Select destination.
        do {
            System.out.println(pieceName + " is selected.");
            System.out.println("Please now enter a destination for the piece: [1-8, 1-8]");
            input = scanner.nextLine();
            tarRow = Character.getNumericValue(input.charAt(1) - 1);
            tarCol = Character.getNumericValue(input.charAt(0) - 1);

            isLegal = board.selectPieceDestination(tarRow, tarCol, colour);

            //If legal move, finally check if piece can actually even move there.
            if (isLegal) {
                if (selectedPiece.canMove(board.getPieceArray(), tarCol, tarRow, colSelec, rowSelec)) {
                    board.doMove(selectedPiece, tarCol, tarRow, colSelec, rowSelec);
                } else {
                    isLegal = false;
                    System.out.println(pieceName + " is unable to move to that location.");
                    System.out.println("");
                }
            }
        } while (!isLegal);
    }

}
