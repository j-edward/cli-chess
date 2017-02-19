package pieces;

public abstract class Piece implements IPiece {

    private char colour;
    private boolean isAlive;
    private char pieceIcon;

    public Piece(char inputColour) {
        colour = inputColour;
        isAlive = true;
    }

    public void destroy() {
        isAlive = false;
    }

    public char getPieceIcon() {
        return pieceIcon;
    }

    public void setPieceIcon(char pieceIcon) {
        this.pieceIcon = pieceIcon;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setIsAlive(boolean alive) {
        this.isAlive = alive;
    }

    public char getColour() {
        return colour;
    }

    public void setColour(char colour) {
        this.colour = colour;
    }
}
