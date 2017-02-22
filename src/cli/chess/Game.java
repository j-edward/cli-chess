package cli.chess;

import java.util.Scanner;
import utilities.*;

public class Game {

    private Board board;
    private final Utilities util = new Utilities();
    private final Console console = new Console();
    private final Scanner scanner = new Scanner(System.in);
    private boolean playAgain;
    private int turn;

    //Creates pieces, and maps out game.
    //Additionally asks user for side preference.
    public void initGame() {
        char p1Colour;
        console.promptDemo();
        playAgain = true;
        while (playAgain) {
            p1Colour = scanner.nextLine().toUpperCase().charAt(0);
            console.lineBreak();
            switch (p1Colour) {
                case 'B':
                    turn = 1;
                    startGame(p1Colour);
                    break;
                case 'W':
                    turn = 0;
                    startGame(p1Colour);
                    break;
                case 'E':
                    playAgain = false;
                    console.promptEndGame();
                    break;
                default:
                    console.promptErrorInvalidColourSelection(p1Colour);
            }
        }
    }

    //Starts game with user choices.
    public void startGame(char p1Colour) {
        boolean gameOver;
        char p2Colour;
        
        //Create board.
        board = new Board(p1Colour);

        //Assign colours based on board properties.
        p1Colour = board.getP1Colour();
        p2Colour = board.getP2Colour();
        
        console.promptStartingGame(p1Colour);

        gameOver = false;
        do {
            board.showBoard();

            //Start turn
            switch (turn % 2) {
                case 0:
                    //P1 turn.
                    doTurn(p1Colour);
                    break;
                case 1:
                    //CPU turn.
                    doTurn(p2Colour);
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

            isLegal = board.selectPiece(locRow, locCol, colour);
            console.lineBreak();
        } while (!isLegal);

        pieceName = util.getPieceName(board.getPieceArray()[locRow][locCol]);

        //Select destination.
        do {
            console.promptTargetPiece(pieceName);

            tarPos = util.getCoordsFromInput(scanner.nextLine());
            tarRow = tarPos[0];
            tarCol = tarPos[1];

            isLegal = board.selectPieceDestination(tarRow, tarCol, colour);

            //If legal move, finally check if piece can actually even move there.
            if (isLegal) {
                if (board.getPieceArray()[locRow][locCol].canMove(board.getPieceArray(),
                        tarCol, tarRow, locCol, locRow)) {
                    board.doMove(board.getPieceArray()[locRow][locCol], tarCol, tarRow, locCol, locRow);
                } else {
                    isLegal = false;
                    console.promptErrorPieceMove(pieceName);
                }
            }
        } while (!isLegal);
    }

}
