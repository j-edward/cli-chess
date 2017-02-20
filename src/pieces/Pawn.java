package pieces;

public class Pawn extends Piece {

    private final char whitePiece = '♙';
    private final char blackPiece = '♟';
    private boolean isFirstGo;

    public Pawn(char inputColour) {
        super(inputColour);
        setPieceIcon();
        isFirstGo = true;
    }

    public boolean isIsFirstGo() {
        return isFirstGo;
    }

    public void setIsFirstGo(boolean isFirstGo) {
        this.isFirstGo = isFirstGo;
    }

    @Override
    public boolean canMove(Piece[][] array, int xTar, int yTar, int xSelec, int ySelec) {
        Piece tempPiece = array[xTar][yTar];

        if (tempPiece instanceof Empty) {
            if (isFirstGo) {
                if (xTar == xSelec && yTar - ySelec == 2) {
                    return true;
                }
            }
            return xTar == xSelec && (yTar - ySelec == 1);
        } else {
            return yTar - 1 == ySelec && (xTar == xSelec + 1 || xTar == xSelec - 1);
        }
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
