package org.egar.makshun.figure;

/**
 * Abstract class for all figure.
 *
 * @author Makshun Aleksey
 */
public abstract class Figure {

    /**
     * Perimeter search method.
     *
     * @return Perimeter
     */
    public abstract double getPerimeter();

    /**
     * Area search method.
     *
     * @return Area
     */
    public abstract double getArea();

    /**
     * Min size search method.
     *
     * @return MinSize
     */
    public abstract double getMinSize();

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    public boolean equals(Object o) {
        return getClass() != o.getClass();
    }
}
