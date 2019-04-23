package org.egar.makshun.figure.ext;

import org.egar.makshun.figure.Figure;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Class Rectangle. Extended from Figure.
 *
 * @author Makshun Aleksey
 */
public abstract class Rectangle extends Figure {
    /**
     * Rectangle width
     */
    private double width;
    /**
     * Rectangle height
     */
    private double height;

    /**
     * Constructor to create a Rectangle.
     *
     * @param width  Rectangle width
     * @param height Rectangle height
     */
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Constructor to create a Rectangle from another figure.
     *
     * @param figure Original figure
     */
    public Rectangle(Figure figure) {
        this.width = BigDecimal.valueOf(figure.getMinSize() / 5)
                .setScale(1, BigDecimal.ROUND_HALF_DOWN).doubleValue();
        this.height = BigDecimal.valueOf(figure.getMinSize() / 4)
                .setScale(1, BigDecimal.ROUND_HALF_DOWN).doubleValue();

    }

    /**
     * Rectangle perimeter search method.
     *
     * @return BigDecimal.valueOf(2 * ( width + height)).setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
     */
    @Override
    public double getPerimeter() {
        return BigDecimal.valueOf(2 * (width + height))
                .setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
    }

    /**
     * Rectangle area search method.
     *
     * @return BigDecimal.valueOf(width * height).setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
     */
    @Override
    public double getArea() {
        return BigDecimal.valueOf(width * height)
                .setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
    }

    /**
     * Min size search method.
     *
     * @return Math.min(width, height)
     */
    @Override
    public double getMinSize() {
        return Math.min(width, height);
    }

    /**
     * toString override method.
     *
     * @return super.toString() +
     * " width=" + width +
     * ", height=" + height;
     */
    @Override
    public String toString() {
        return super.toString() +
                " width = " + width +
                ", height = " + height;
    }

    /**
     * equals override method.
     *
     * @param o comparable object
     * @return Double.compare(rectangle.width, width) == 0 && Double.compare(rectangle.height, height) == 0;
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (super.equals(o)) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.width, width) == 0 &&
                Double.compare(rectangle.height, height) == 0;
    }

    /**
     * hashCode override method.
     *
     * @return Objects.hash(width, height);
     */
    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }
}
