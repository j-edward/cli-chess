package pieces;

public class Queen extends Piece {

    private final char whitePiece = '♕';
    private final char blackPiece = '♛';

    public Queen(char inputColour) {
        super(inputColour);
        setPieceIcon();
    }

    @Override
    public boolean canMove(Piece[][] array, int xTar, int yTar, int xSelec, int ySelec) {
        //Queen behaviour is a combination of Bishop and Castle.
        return (yTar == xTar + xSelec) || (yTar == xTar + (ySelec - xSelec))
                || (xTar == xSelec || yTar == ySelec);
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
}
