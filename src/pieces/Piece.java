package pieces;

public abstract class Piece implements IPiece {

    private char colour;
    private char alive;
    private char pieceIcon;
    
    public Piece(char inputColour) {
        colour = inputColour;
        alive = 'Y';
    }
    
    public char getPieceIcon() {
        return pieceIcon;
    }

    public void setPieceIcon(char pieceIcon) {
        this.pieceIcon = pieceIcon;
    }
    
    public char getAlive() {
        return alive;
    }

    public void setAlive(char alive) {
        this.alive = alive;
    }

    public char getColour() {
        return colour;
    }

    public void setColour(char colour) {
        this.colour = colour;
    }
}
