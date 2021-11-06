package Inquiry.Recursion;

import acm.graphics.*;
import java.awt.Color;

public class CirclePattern extends PatternExplorer{
    private static final int LIMIT = 20;
    private GOval big_circle;
    private CirclePattern left;
    private CirclePattern right;

    public CirclePattern(double x, double y, double size, GCanvas canvas) {
        double radius = size/2;
        big_circle = new GOval(x,y,size,size);
        canvas.add(big_circle);
        if (size > LIMIT) {
            left = new CirclePattern(big_circle.getX()-(radius/2), big_circle.getY()+(radius/2), radius,canvas);
            right = new CirclePattern(big_circle.getX()+(3*radius/2), big_circle.getY()+(radius/2),radius,canvas);
        } else {
            left = null;
            right = null;
        }
    }
    public void setRandomColor() {
        big_circle.setColor(randColor());
        if (left != null) {
            left.setRandomColor();
        } else if (right != null) {
            right.setRandomColor();
        }
    }
    public Color randColor() {
        return new Color((int)((Math.random()*255)+1),(int)((Math.random()*255)+1),(int)((Math.random()*255)+1));
    }
}
