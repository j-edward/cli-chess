package cli.chess;

import java.util.Scanner;
import pieces.*;

public class Game {

    Board board;
    Piece[][] pieceArray = new Piece[8][8];

    public void getMove(String input) {
        System.out.println("");
    }

    //Starts game with user choices.
    public void startGame(char side) {
        System.out.println("Starting game for " + side + " side...");
        System.out.println("_________________________________________________________________________");
        initBoard(pieceArray, side);
        board.showBoard(pieceArray);
    }

    //Create pieces in array.
    public void initBoard(Piece[][] pieces, char choice) {
        char opp;
        char side;

        if (choice == 'W') {
            opp = 'B';
            side = 'W';
        } else {
            opp = 'W';
            side = 'B';
        }

        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < pieces.length; j++) {
                switch (i) {
                    case 0:
                        royalRow(pieces, i, j, opp);
                        break;
                    case 1:
                        pieces[i][j] = new Pawn(opp);
                        break;
                    case 6:
                        pieces[i][j] = new Pawn(side);
                        break;
                    case 7:
                        royalRow(pieces, i, j, side);
                        break;
                    default:
                        pieces[i][j] = new Empty(' ');
                }

            }
        }
    }

    //Switch case for 'royal row' on board.
    public void royalRow(Piece[][] pieces, int i, int j, char colour) {
        switch (j) {
            case 0:
                pieces[i][j] = new Castle(colour);
                break;
            case 1:
                pieces[i][j] = new Knight(colour);
                break;
            case 2:
                pieces[i][j] = new Bishop(colour);
                break;
            case 3:
                pieces[i][j] = new Queen(colour);
                break;
            case 4:
                pieces[i][j] = new King(colour);
                break;
            case 5:
                pieces[i][j] = new Bishop(colour);
                break;
            case 6:
                pieces[i][j] = new Knight(colour);
                break;
            case 7:
                pieces[i][j] = new Castle(colour);
                break;
        }
    }

    //Creates pieces, and maps out game.
    //Additionally asks user for side preference.
    public void initGame() {
        boolean playAgain;
        Scanner inputScanner = new Scanner(System.in);
        String input;

        board = new Board();
        
        demoBoard();
        System.out.println("                            Welcome to Chess CLI.");
        System.out.println("                         Created by Joe Howell, 2017.");
        System.out.println("_________________________________________________________________________");
        System.out.println("");
        System.out.println("Please enter your choice of colour ('W' or 'B') to start.");
        playAgain = true;

        while (playAgain) {
            input = inputScanner.nextLine();
            System.out.println("_________________________________________________________________________");
            switch (input) {
                case "B":
                    startGame('B');
                    break;
                case "W":
                    startGame('W');
                    break;
                case "exit":
                    playAgain = false;
                    break;
                default:
                    System.out.println(input + " is not a valid input. Please try again.");

            }
        }
    }
    
    //I'm well aware there is 9 spaces on the black rows... still figuring out a solution to the blank space...
    public void demoBoard(){
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
