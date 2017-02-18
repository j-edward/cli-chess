package cli.chess;

import java.util.Scanner;
import pieces.*;

public class Game {

    Board board;
    Scanner inputScanner = new Scanner(System.in);
    Piece selectedPiece;
    Piece[][] pieceArray = new Piece[8][8];
    PieceFactory pieceFactory = new PieceFactory();
    String player1Input;
    boolean playAgain;
    char userColour;
    char oppColour;
    int turn;

    //Creates pieces, and maps out game.
    //Additionally asks user for side preference.
    public void initGame() {
        board = new Board();

        board.demoBoard();
        System.out.println("                            Welcome to Chess CLI.");
        System.out.println("                         Created by Joe Howell, 2017.");
        System.out.println("_________________________________________________________________________");
        System.out.println("");
        System.out.println("Please enter your choice of colour ('W' or 'B') to start.");

        playAgain = true;
        while (playAgain) {
            userColour = inputScanner.nextLine().toUpperCase().charAt(0);
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
        boolean move;
        boolean gameOver;
        System.out.println("Starting game for " + userColour + " side...");
        System.out.println("_________________________________________________________________________");

        generatePieces();
        board.showBoard(pieceArray);
        System.out.println("");

        gameOver = false;
        while (!gameOver) {
            
            move = false;
            //Start turn
            switch (turn % 2) {
                case 0:
                    //P1 turn
                    while (!move) {
                        System.out.println("Please select a piece to move: [a-h, 0-8]");
                        player1Input = inputScanner.nextLine();
                        move = validateSelectedPiece(player1Input);
                    }
                    move = false;

                    while (!move) {
                        System.out.println("Now please enter a destination for the piece: [a-h, 0-8]");
                        player1Input = inputScanner.nextLine();
                        move = validateSelectedPieceDestination(player1Input);
                    }
                    break;
                case 1:
                    //CPU turn
                    break;
            }

            //Do collision detection.
            checkCollision();

            //End of turn, increment turn value
            turn++;
        }
        System.out.println("Thank you for playing! :)");
    }

    //Create pieces in array.
    public void generatePieces() {

        //Based on user's choice of side, make set opposition to the opposite.
        switch (userColour) {
            case 'W':
                oppColour = 'B';
                break;
            case 'B':
                oppColour = 'W';
                break;
        }

        //Main loop for generating pieces on board
        for (int row = 0; row < pieceArray.length; row++) {
            for (int column = 0; column < pieceArray.length; column++) {
                switch (row) {
                    case 0:
                        createRoyalRowPieces(row, column, oppColour);
                        break;
                    case 1:
                        pieceArray[row][column] = createPiece("Pawn", oppColour);
                        break;
                    case 6:
                        pieceArray[row][column] = createPiece("Pawn", userColour);
                        break;
                    case 7:
                        createRoyalRowPieces(row, column, userColour);
                        break;
                    default:
                        pieceArray[row][column] = createPiece("EMPTY", '1');
                }

            }
        }
    }

    //Switch case for 'royal row' on board.
    public void createRoyalRowPieces(int row, int column, char colour) {
        switch (column) {
            case 0:
                pieceArray[row][column] = createPiece("CASTLE", colour);
                break;
            case 1:
                pieceArray[row][column] = createPiece("KNIGHT", colour);
                break;
            case 2:
                pieceArray[row][column] = createPiece("BISHOP", colour);
                break;
            case 3:
                pieceArray[row][column] = createPiece("QUEEN", colour);
                break;
            case 4:
                pieceArray[row][column] = createPiece("KING", colour);
                break;
            case 5:
                pieceArray[row][column] = createPiece("BISHOP", colour);
                break;
            case 6:
                pieceArray[row][column] = createPiece("KNIGHT", colour);
                break;
            case 7:
                pieceArray[row][column] = createPiece("CASTLE", colour);
                break;
        }
    }

    public Piece createPiece(String piece, char colour) {
        if (piece.equalsIgnoreCase("EMPTY")) {
            return pieceFactory.getEmptyPiece();
        }
        return pieceFactory.getPiece(piece, colour);
    }

    public void checkCollision() {

    }

    public boolean validateSelectedPiece(String input) {
        int x = (int) input.charAt(0);
        int y = (int) input.charAt(1);
        Piece tempPiece = pieceArray[x][y];

        if (tempPiece.getAlive() == 'Y') {
            selectedPiece = tempPiece;
            return true;
        } else {
            System.out.println("Incorrect selection.");
            return false;
        }
    }

    public boolean validateSelectedPieceDestination(String input) {
        int x = (int) input.charAt(0);
        int y = (int) input.charAt(1);
        Piece tempPiece = pieceArray[x][y];

        if (tempPiece instanceof Empty) {
            selectedPiece = tempPiece;
            return true;
        } else if (tempPiece.getColour() == userColour) {
            return true;
        } else {
            return false;
        }
    }
}
