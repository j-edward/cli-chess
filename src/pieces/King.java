package pieces;

public class King extends Piece {

    private final char whitePiece = '♔';
    private final char blackPiece = '♚';

    public King(char inputColour) {
        super(inputColour);
        setPieceIcon();
    }
    
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
    public boolean canMove(Piece[][] array, int destX, int destY, int xSelec, int ySelec) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
