package org.egar.makshun.paper.impl;

import org.egar.makshun.figure.Figure;
import org.egar.makshun.figure.ext.Triangle;
import org.egar.makshun.paper.Paper;

import java.util.Objects;

/**
 * Class PaperTriangle extends Triangle and implements Paper.
 *
 * @author Makshun Aleksey
 */
public class PaperTriangle extends Triangle implements Paper {

    private Painted painted = new Painted();

    /**
     * Constructor to create a PaperTriangle.
     *
     * @param side Triangle side
     */
    public PaperTriangle(double side) {
        super(side);
    }

    /**
     * Constructor to create a PaperTriangle from another figure.
     *
     * @param paperFigure Original figure
     */
    public PaperTriangle(Paper paperFigure) {
        super((Figure) paperFigure);
        painted = paperFigure.getPainted();
    }

    /**
     * The method displays the color of the figure.
     *
     * @return painted.getColor();
     */
    @Override
    public Color getColor() {
        return painted.getColor();
    }

    /**
     * The method paints a figure.
     *
     * @param color color
     */
    @Override
    public void setColor(Color color) {
        painted.setColor(color);
    }

    /**
     * Method for painting figures.
     *
     * @return painted
     */
    @Override
    public Painted getPainted() {
        return painted;
    }

    /**
     * toString override method.
     *
     * @return super.toString() + " color: " + painted.getColor();
     */
    @Override
    public String toString() {
        return super.toString() + " color: " + painted.getColor();
    }

    /**
     * equals override method.
     *
     * @param o comparable object
     * @return Objects.equals(painted, that.painted);
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        PaperTriangle that = (PaperTriangle) o;
        return Objects.equals(painted, that.painted);
    }

    /**
     * hashCode override method.
     *
     * @return Objects.hash(super.hashCode (), painted);
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), painted);
    }
}
