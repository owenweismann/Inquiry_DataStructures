package Inquiry.Recursion;

/**
 * Example Class to created collection
 * of nested squares recursively
 *
 * Use this as a model for other patterns
 *
 * @version October 2021 (and much earlier...)
 * @author J. Smith
 */

import acm.graphics.*;

public class NestedSquares {

    private static final double SHIFT = 2; // offset between squares

    private GRect outerSquare;   // the outermost square
    private NestedSquares rest;       // the rest of the squares

    // create the nested squares at (x,y), where the outermost square
    // has side with length size.
    public NestedSquares(double x, double y, double size, GCanvas canvas) {
        outerSquare = new GRect(x, y, size, size);
        canvas.add(outerSquare);
        if (size > SHIFT * 2) {
            rest = new NestedSquares(x + SHIFT, y + SHIFT, size - SHIFT * 2, canvas);
        } else rest = null;
    }

    // Move nested squares to (x,y)
    public void moveTo(double x, double y) {
        /**
         * move the outersquare
         * if rest is not null, recursively move the rest
         *    rest.moveTo(x, y)
         */
        outerSquare.move(x-outerSquare.getX(),y-outerSquare.getY());
        if (rest != null) {
            rest.moveTo(x,y);
        }
    }

    // remove all squares from canvas
    public void removeFromCanvas() {

    }


}