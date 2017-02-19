package pieces;

public class Castle extends Piece {

    private final char whitePiece = '♖';
    private final char blackPiece = '♜';

    public Castle(char inputColour) {
        super(inputColour);
        setPieceIcon();
    }

    @Override
    public boolean canMove(Piece[][] array, int xTar, int yTar, int xSelec, int ySelec) {
        //If target x or y = selected x or y, return true
        return xTar == xSelec || yTar == ySelec;
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
