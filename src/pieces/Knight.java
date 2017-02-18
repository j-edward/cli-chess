package pieces;

public class Knight extends Piece {

    private final char whitePiece = '♘';
    private final char blackPiece = '♞';
    private char pieceIcon;

    public void setPieceIcon(char side) {
        switch (side) {
            case 'W':
                pieceIcon = whitePiece;
                break;
            case 'B':
                pieceIcon = blackPiece;
                break;
        }
    }

    public char getPieceIcon() {
        return pieceIcon;
    }

    public Knight(char inputColour) {
        super.setColour(inputColour);
        setPieceIcon(inputColour);
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
