package pieces;

public class Bishop extends Piece {

    private final char whitePiece = '♗';
    private final char blackPiece = '♝';

    public Bishop(char inputColour) {
        super(inputColour);
        setPieceIcon();
    }

    @Override
    public boolean canMove(Piece[][] array, int xTar, int yTar, int xSelec, int ySelec) {
        //Bishop only allows for diagonal movement.
        return (yTar == xTar + xSelec) || (yTar == xTar + (ySelec - xSelec));
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
}
