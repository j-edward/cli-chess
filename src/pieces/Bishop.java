/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pieces;

/**
 *
 * @author jhowell
 */
public class Bishop extends Piece {

    private final char whitePiece = '♗';
    private final char blackPiece = '♝';
    private char pieceIcon;

    public void setPieceType(char side) {
        switch (side) {
            case 'W':
                pieceIcon = whitePiece;
                break;
            case 'B':
                pieceIcon = blackPiece;
                break;
        }
    }

    public char getPieceType() {
        return pieceIcon;
    }

    public Bishop(char inputColour) {
        super(inputColour);
        setPieceType(inputColour);
    }

    @Override
    public void onMove(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onDestroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
