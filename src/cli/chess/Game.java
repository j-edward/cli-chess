package cli.chess;

import java.util.Scanner;
import pieces.*;

public class Game {

    Board board;
    Scanner inputScanner = new Scanner(System.in);
    Piece[][] pieceArray = new Piece[8][8];
    Piece selectedPiece;
    String player1Input;
    boolean playAgain;
    boolean gameOver;
    boolean move = false;
    int turn;

    public void doTurn() {
        System.out.println("");
        while (!gameOver) {
            
            //Start turn
            switch (turn % 2) {
                case 0:
                    //P1 turn
                    while (!move) {
                        System.out.println("Please select a piece to move: [a-h, 0-8]");
                        validateTurn(player1Input = inputScanner.nextLine());
                    }
                    break;
                case 1:
                    //CPU turn
                    break;
            }
            
            //Do collision detection.
            
            //End of turn, increment turn value
            turn++;
        }
    }

    public boolean validateTurn(String input) {
        int x = (int) input.charAt(0);
        int y = (int) input.charAt(1);
        Piece tempPiece = pieceArray[x][y];

        if (tempPiece.getAlive() == 'Y') {
            selectedPiece = tempPiece;
            return true;
        } else{
            System.out.println("Incorrect selection.");
           return false;   
        }
    }

    //Starts game with user choices.
    public void startGame(char side) {
        System.out.println("Starting game for " + side + " side...");
        System.out.println("_________________________________________________________________________");
        generatePieces(pieceArray, side);
        board.showBoard(pieceArray);
        doTurn();
        System.out.println("Thank you for playing! :)");
    }

    //Create pieces in array.
    public void generatePieces(Piece[][] pieces, char userColour) {
        char oppColour = '1';

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
        for (int row = 0; row < pieces.length; row++) {
            for (int column = 0; column < pieces.length; column++) {
                switch (row) {
                    case 0:
                        generateRoyalRowPieces(pieces, row, column, oppColour);
                        break;
                    case 1:
                        pieces[row][column] = new Pawn(oppColour);
                        break;
                    case 6:
                        pieces[row][column] = new Pawn(userColour);
                        break;
                    case 7:
                        generateRoyalRowPieces(pieces, row, column, userColour);
                        break;
                    default:
                        pieces[row][column] = new Empty(' ');
                }

            }
        }
    }

    //Switch case for 'royal row' on board.
    public void generateRoyalRowPieces(Piece[][] pieces, int row, int column, char colour) {
        switch (column) {
            case 0:
                pieces[row][column] = new Castle(colour);
                break;
            case 1:
                pieces[row][column] = new Knight(colour);
                break;
            case 2:
                pieces[row][column] = new Bishop(colour);
                break;
            case 3:
                pieces[row][column] = new Queen(colour);
                break;
            case 4:
                pieces[row][column] = new King(colour);
                break;
            case 5:
                pieces[row][column] = new Bishop(colour);
                break;
            case 6:
                pieces[row][column] = new Knight(colour);
                break;
            case 7:
                pieces[row][column] = new Castle(colour);
                break;
        }
    }

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
            player1Input = inputScanner.nextLine();
            System.out.println("_________________________________________________________________________");
            System.out.println(player1Input);
            switch (player1Input) {
                case "B":
                    turn = 1;
                    startGame('B');
                    break;
                case "W":
                    turn = 0;
                    startGame('W');
                    break;
                case "exit":
                    playAgain = false;
                    break;
                default:
                    System.out.println(player1Input + " is not a valid input. Please try again.");
            }
        }
    }
}
