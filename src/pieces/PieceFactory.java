package pieces;

import pieces.*;

public class PieceFactory {

    char c = 'h';

    public Piece getPiece(String pieceType, char colour) {
        if (pieceType == null) {
            return null;
        }
        if (pieceType.equalsIgnoreCase("BISHOP")) {
            return new Bishop(colour);
        }
        if (pieceType.equalsIgnoreCase("CASTLE")) {
            return new Castle(colour);
        }
        if (pieceType.equalsIgnoreCase("KING")) {
            return new King(colour);
        }
        if (pieceType.equalsIgnoreCase("KNIGHT")) {
            return new Knight(colour);
        }
        if (pieceType.equalsIgnoreCase("PAWN")) {
            return new Pawn(colour);
        }
        if (pieceType.equalsIgnoreCase("QUEEN")) {
            return new Queen(colour);
        }
        return null;
    }

    public Piece getEmptyPiece() {
        return new Empty();
    }
}
