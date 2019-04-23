package org.egar.makshun.figure.ext;

import org.egar.makshun.figure.Figure;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Class Triangle. Extended from Figure.
 *
 * @author Makshun Aleksey
 */
public abstract class Triangle extends Figure {
    /**
     * Triangle side
     */
    private double side;

    /**
     * Constructor to create a Triangle.
     *
     * @param side Triangle side
     */
    public Triangle(double side) {
        this.side = side;
    }

    /**
     * Constructor to create a Triangle from another figure.
     *
     * @param figure Original figure
     */
    public Triangle(Figure figure) {
        this.side = BigDecimal.valueOf(figure.getMinSize() / 2)
                .setScale(1, BigDecimal.ROUND_HALF_DOWN).doubleValue();
    }

    /**
     * Triangle perimeter search method.
     *
     * @return BigDecimal.valueOf(side * 3).setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
     */
    @Override
    public double getPerimeter() {
        return BigDecimal.valueOf(side * 3).setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
    }

    /**
     * Triangle area search method.
     *
     * @return BigDecimal.valueOf(( side * side * Math.sqrt ( 3)) / 4).setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
     */
    @Override
    public double getArea() {
        return BigDecimal.valueOf((side * side * Math.sqrt(3)) / 4)
                .setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
    }

    /**
     * Min size search method.
     *
     * @return (side * Math.sqrt ( 3)) / 6
     */
    @Override
    public double getMinSize() {
        return (side * Math.sqrt(3)) / 6;
    }

    /**
     * toString override method.
     *
     * @return super.toString() + " side = " + side;
     */
    @Override
    public String toString() {
        return super.toString() +
                " side = " + side;
    }

    /**
     * equals override method.
     *
     * @param o comparable object
     * @return Double.compare(triangle.side, side) == 0;
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (super.equals(o)) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.side, side) == 0;
    }

    /**
     * hashCode override method.
     *
     * @return Objects.hash(side);
     */
    @Override
    public int hashCode() {
        return Objects.hash(side);
    }
}
