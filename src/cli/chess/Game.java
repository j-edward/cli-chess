package cli.chess;

import java.util.Scanner;
import pieces.*;

public class Game {

    Board board;
    Scanner scanner = new Scanner(System.in);
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

        System.out.println("Starting game for " + userColour + " side...");
        generatePieces();

        gameOver = false;
        do {
            board.showBoard(pieceArray);

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
        int selectedX;
        int selectedY;
        int tarRow;
        int tarCol;
        String input;
        String pieceName;

        //Will add input validation later!
        //Select piece.
        do {
            System.out.println(colour + " Player: Please select a piece to move: [1-8, 1-8]");
            input = scanner.nextLine();
            selectedX = Character.getNumericValue(input.charAt(1) - 1);
            selectedY = Character.getNumericValue(input.charAt(0) - 1);
            isLegal = selectPiece(selectedX, selectedY, colour);
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

            isLegal = selectPieceDestination(tarRow, tarCol, colour);

            //If legal move, finally check if piece can actually even move there.
            if (isLegal) {
                if (pieceArray[selectedX][selectedY].canMove(pieceArray, tarRow, tarCol, selectedX, selectedY)) {
                    pieceArray[tarRow][tarCol].destroy();
                    pieceArray[tarRow][tarCol] = selectedPiece;
                    pieceArray[selectedX][selectedY] = createPiece("EMPTY", '1');
                } else {
                    isLegal = false;
                    System.out.println(pieceName + " is unable to move to that location.");
                    System.out.println("");
                }
            }
        } while (!isLegal);
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

    //Switch case for 'royal row' on board. Probably change this to an enum in time.
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
        } else {
            return pieceFactory.getPiece(piece, colour);
        }
    }

    public boolean selectPiece(int col, int row, char colour) {
        Piece tempPiece = pieceArray[col][row];

        if (tempPiece.getColour() == colour) {
            if (tempPiece.isAlive()) {
                selectedPiece = tempPiece;
                return true;
            } else {
                System.out.println("No piece found!");
                return false;
            }
        } else {
            System.out.println("Please select a piece matching your colour.");
            return false;
        }
    }

    public boolean selectPieceDestination(int col, int row, char colour) {
        Piece tempPiece = pieceArray[col][row];

        if (tempPiece instanceof Empty) {
            return true;
        } else if (tempPiece.getColour() != colour) {
            return true;
        } else {
            System.out.println("Incorrect destination.");
            return false;
        }
    }
}
