/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pieces;

/**
 *
 * @author jhowell
 */
public abstract class Piece implements IPiece {

    private char colour;
    private char alive;

    public Piece(char inputColour) {
        colour = inputColour;
        alive = 'Y';
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
