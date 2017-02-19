package pieces;

public interface IPiece {
    //Checks if destination of the piece matches -
    //any possible locations piece can LEGALLY move to.
    public boolean canMove(Piece[][] array, int destX, int destY, int xSelec, int ySelec);
    
    char getPieceIcon();

    void setPieceIcon();
}
