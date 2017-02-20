package cli.chess;

import java.util.Scanner;
import pieces.*;
import utilities.*;

public class Game {

    private Board board;
    private Utilities util;
    private Console console;
    private Scanner scanner = new Scanner(System.in);
    private Piece selectedPiece;
    private PieceFactory pieceFactory = new PieceFactory();
    private boolean playAgain;
    private char userColour;
    private char oppColour;
    private int turn;

    //Creates pieces, and maps out game.
    //Additionally asks user for side preference.
    public void initGame() {
        console.promptDemo();
        playAgain = true;
        while (playAgain) {
            userColour = scanner.nextLine().toUpperCase().charAt(0);
            console.lineBreak();
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
                    console.promptEndGame();
                    break;
                default:
                    console.promptErrorInvalidColourSelection(userColour);
            }
        }
    }

    //Starts game with user choices.
    public void startGame() {
        boolean gameOver;
        board = new Board(userColour, oppColour);

        console.promptStartingGame(userColour);

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
            
            //End of turn, increment turn value.
            turn++;

        } while (!gameOver);
        console.promptEndGame();
    }

    //Turn functionality.
    public void doTurn(char colour) {
        boolean isLegal;
        int[] locPos = new int[2];
        int[] tarPos = new int[2];
        int locRow;
        int locCol;
        int tarRow;
        int tarCol;
        String pieceName;

        //Select piece.
        do {
            console.promptSelectPiece(colour);

            locPos = util.getCoordsFromInput(scanner.nextLine());
            locRow = locPos[0];
            locCol = locPos[1];

            isLegal = board.selectPiece(locPos[0], locPos[1], colour);

            if (isLegal) {
                selectedPiece = board.getPieceArray()[locPos[0]][locPos[1]];
            }
            console.lineBreak();
        } while (!isLegal);

        pieceName = util.getPieceName(selectedPiece);

        //Select destination.
        do {
            console.promptTargetPiece(pieceName);

            tarPos = util.getCoordsFromInput(scanner.nextLine());
            tarRow = tarPos[0];
            tarCol = tarPos[1];

            isLegal = board.selectPieceDestination(tarPos[0], tarPos[1], colour);

            //If legal move, finally check if piece can actually even move there.
            if (isLegal) {
                if (selectedPiece.canMove(board.getPieceArray(), tarCol, tarRow, locCol, locRow)) {
                    board.doMove(selectedPiece, tarCol, tarRow, locCol, locRow);
                } else {
                    isLegal = false;
                    console.promptErrorPieceMove(pieceName);
                }
            }
        } while (!isLegal);
    }

}
