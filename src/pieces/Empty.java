package pieces;

public class Empty extends Piece {

    private final char emptyPiece = ' ';

    public Empty() {
        super('1');
        super.setIsAlive(false);
        setPieceIcon(emptyPiece);
    }

    public char getPieceIcon() {
        return emptyPiece;
    }

    @Override
    public void setPieceIcon() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean canMove(Piece[][] array, int destX, int destY, int xSelec, int ySelec) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
