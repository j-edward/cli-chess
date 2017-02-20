package utilities;

import pieces.*;

public class Utilities {

    public String getPieceName(Piece piece) {
        return piece.getClass().getCanonicalName().substring(7);
    }

    public int[] getCoordsFromInput(String input) {
        int[] output = new int[2];
        output[0] = Character.getNumericValue(input.charAt(1) - 1);
        output[1] = Character.getNumericValue(input.charAt(0) - 1);

        return output;
    }
}
