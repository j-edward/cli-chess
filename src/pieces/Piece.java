package pieces;

public abstract class Piece implements IPiece {

    private char colour;
    private char alive;

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
