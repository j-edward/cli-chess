package pieces;

public interface IPiece {

    void onMove(int x, int y);

    void onDestroy();

    char getPieceIcon();

    void setPieceIcon(char side);
}
