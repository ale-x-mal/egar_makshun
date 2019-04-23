package org.egar.makshun.figure.ext;

import org.egar.makshun.figure.Figure;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Class Circle. Extended from Figure.
 *
 * @author Makshun Aleksey
 */
public abstract class Circle extends Figure {
    /**
     * Circle radius
     */
    private double radius;

    /**
     * Constructor to create a Circle.
     *
     * @param radius Circle radius
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * Constructor to create a Circle from another figure.
     *
     * @param figure Original figure
     */
    public Circle(Figure figure) {
        this.radius = BigDecimal.valueOf(figure.getMinSize() / 4)
                .setScale(1, BigDecimal.ROUND_HALF_DOWN).doubleValue();
    }

    /**
     * Circle perimeter search method.
     *
     * @return BigDecimal.valueOf(2 * getArea ()).setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
     */
    @Override
    public double getPerimeter() {
        return BigDecimal.valueOf(2 * getArea())
                .setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
    }

    /**
     * Circle area search method.
     *
     * @return BigDecimal.valueOf(Math.PI * radius * radius).setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
     */
    @Override
    public double getArea() {
        return BigDecimal.valueOf(Math.PI * radius * radius)
                .setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
    }

    /**
     * Min size search method.
     *
     * @return radius
     */
    @Override
    public double getMinSize() {
        return radius;
    }

    /**
     * toString override method.
     *
     * @return super.toString() + " radius = " + radius;
     */
    @Override
    public String toString() {
        return super.toString() +
                " radius = " + radius;
    }

    /**
     * equals override method.
     *
     * @param o comparable object
     * @return Double.compare(circle.radius, radius) == 0;
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (super.equals(o)) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0;
    }

    /**
     * hashCode override method.
     *
     * @return Objects.hash(radius);
     */
    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }
}
