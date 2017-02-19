package pieces;

public class Empty extends Piece {

    private final char pieceType = ' ';

    public Empty() {
        super('1');
        super.setAlive('N');
    }

    public char getPieceIcon() {
        return pieceType;
    }

    @Override
    public void onDestroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPieceIcon() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
