package cli.chess;

import pieces.Piece;
import pieces.PieceFactory;
import pieces.Empty;

public class Board {

    private final int boardSize = 8;
    private Piece[][] pieceArray = new Piece[boardSize][boardSize];
    private final char p1Colour;
    private final char p2Colour;
    private PieceFactory pieceFactory = new PieceFactory();

    public Board(char p1Colour) {
        //Based on user's choice of side, make set opposition to the opposite.
        this.p1Colour = p1Colour;
        
        switch (this.p1Colour) {
            case 'W':
                p2Colour = 'B';
                break;
            case 'B':
                p2Colour = 'W';
                break;
            default:
                p2Colour = '1';
        }
         generatePieces();
    }

    public char getP1Colour() {
        return p1Colour;
    }

    public char getP2Colour() {
        return p2Colour;
    }

    public Piece[][] getPieceArray() {
        return pieceArray;
    }

    public int getBoardSize() {
        return boardSize;
    }

    //Pass list of pieces to draw on board.
    //Will add 'dead pieces' on side of board.
    public void showBoard() {
        System.out.println("_________________________________________________________________________");
        System.out.println("                    --------------------------------------");
        for (int i = 0; i < boardSize; i++) {
            System.out.println("                    | " + pieceArray[i][0].getPieceIcon() + " | " + pieceArray[i][1].getPieceIcon() + " | " + pieceArray[i][2].getPieceIcon() + " | " + pieceArray[i][3].getPieceIcon()
                    + " | " + pieceArray[i][4].getPieceIcon() + " | " + pieceArray[i][5].getPieceIcon() + " | " + pieceArray[i][6].getPieceIcon() + " | " + pieceArray[i][7].getPieceIcon() + " |");
            System.out.println("                    --------------------------------------");
        }
        System.out.println("_________________________________________________________________________");
    }

    //Create pieces in array.
    private void generatePieces() {
        Piece tempArray[][] = new Piece[boardSize][boardSize];

        //Main loop for generating pieces on board
        for (int row = 0; row < boardSize; row++) {
            for (int column = 0; column < boardSize; column++) {
                switch (row) {
                    case 0:
                        tempArray = createRoyalRowPieces(tempArray, row, column, p2Colour);
                        break;
                    case 1:
                        tempArray[row][column] = createPiece("PAWN", p2Colour);
                        break;
                    case 6:
                        tempArray[row][column] = createPiece("PAWN", p1Colour);
                        break;
                    case 7:
                        tempArray = createRoyalRowPieces(tempArray, row, column, p1Colour);
                        break;
                    default:
                        tempArray[row][column] = createPiece("EMPTY", '1');
                }
            }
        }
        pieceArray = tempArray;
    }

    //Switch case for 'royal row' on board. Probably change this to an enum in time.
    private Piece[][] createRoyalRowPieces(Piece pieceArray[][], int row, int column, char colour) {
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
        return pieceArray;
    }

    public boolean selectPiece(int row, int col, char colour) {

        if (pieceArray[row][col].getColour() == colour) {
            if (pieceArray[row][col].isAlive()) {
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

    public boolean selectPieceDestination(int row, int col, char colour) {

        if (pieceArray[row][col] instanceof Empty) {
            return true;
        } else if (pieceArray[row][col].getColour() != colour) {
            return true;
        } else {
            System.out.println("Incorrect destination.");
            return false;
        }
    }

    public void doMove(Piece piece, int tarCol, int tarRow, int colSelec, int rowSelec) {
        pieceArray[tarRow][tarCol].destroy();
        pieceArray[tarRow][tarCol] = piece;
        pieceArray[rowSelec][colSelec] = createPiece("EMPTY", '1');
    }

    private Piece createPiece(String piece, char colour) {
        if (piece.equalsIgnoreCase("EMPTY")) {
            return pieceFactory.getEmptyPiece();
        } else {
            return pieceFactory.getPiece(piece, colour);
        }
    }
}
