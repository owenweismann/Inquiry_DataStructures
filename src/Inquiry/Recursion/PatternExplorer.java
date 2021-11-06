package Inquiry.Recursion;
/**
 * Basic user interface for
 * exploring recursive classes
 * that draw fractal patterns
 *
 * Students:
 * Add features, instance fields, etc
 * as needed.
 *
 * @author J. Smith
 * @version October 2021
 */

import java.awt.*;
import acm.graphics.*;
import acm.program.*;
import org.jetbrains.annotations.NotNull;

import java.awt.event.*;

public class PatternExplorer extends GraphicsProgram
{
    private static final double SIZE = 300;

    private CantorSet target;

    public void init ()
    {
        addMouseListeners();
    }
    public void mousePressed(@NotNull MouseEvent e ) {
        Point pt = e.getPoint();
        target = new CantorSet(pt.getX(), pt.getY(), SIZE, getGCanvas());
        Color b = new Color(1,100,255);
        target.color(b);
    }

    public void onMouseRelease(MouseEvent e) {
        //target.removeFromCanvas();
    }

    public static void main (String [] args)
    {
        new PatternExplorer().start();
    }

}