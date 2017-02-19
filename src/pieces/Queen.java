package pieces;

public class Queen extends Piece {

    private final char whitePiece = '♕';
    private final char blackPiece = '♛';

    public Queen(char inputColour) {
        super(inputColour);
        setPieceIcon();
    }
    
    //Override super-class setter to set piece symbol, based on colour.
    @Override
    public void setPieceIcon() {
        switch (getColour()) {
            case 'W':
                this.setPieceIcon(whitePiece);
                break;
            case 'B':
                this.setPieceIcon(blackPiece);
                break;
        }
    }

    @Override
    public void onDestroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
