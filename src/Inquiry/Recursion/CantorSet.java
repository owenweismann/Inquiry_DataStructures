package Inquiry.Recursion;

import acm.graphics.*;
import java.awt.Color;

public class CantorSet extends PatternExplorer{
    private static final int LIMIT = 5;
    private GLine big_line;
    private CantorSet left;
    private CantorSet right;

    public CantorSet(double x, double y, double length, GCanvas canvas) {
        double third = length/3;
        big_line = new GLine(x,y,x+length,y);
        canvas.add(big_line);
        if (length > LIMIT) {
            left = new CantorSet(big_line.getX(), big_line.getY()+10, third,canvas);
            right = new CantorSet(big_line.getX()+(2*third), big_line.getY()+10,third,canvas);
        } else {
            left = null;
            right = null;
        }
    }
    public void color(Color c) {
        big_line.setColor(c);
        if (left != null) {
            left.color(c);
        } else if (right != null) {
            right.color(c);
        }
    }
    public void setRandomColor() {
        Color c = new Color((int)((Math.random()*255)+1), (int)((Math.random()*255)+1), (int)((Math.random()*255)+1));
        big_line.setColor(c);
        if (left != null) {
            left.setRandomColor();
        } else if (right != null) {
            right.setRandomColor();
        }
    }
}
