package pieces;

public interface IPiece {

    //Checks if destination of the piece matches -
    //any possible locations piece can LEGALLY move to.
    public boolean canMove(Piece[][] array, int xTar, int yTar, int xSelec, int ySelec);

    char getPieceIcon();

    void setPieceIcon();
}
