package org.egar.makshun.film.impl;

import org.egar.makshun.figure.Figure;
import org.egar.makshun.figure.ext.Circle;
import org.egar.makshun.film.Film;

/**
 * Class FilmCircle extends Circle and implements Film.
 *
 * @author Makshun Aleksey
 */
public class FilmCircle extends Circle implements Film {
    /**
     * Constructor to create a FilmCircle.
     *
     * @param radius Circle radius
     */
    public FilmCircle(double radius) {
        super(radius);
    }

    /**
     * Constructor to create a FilmCircle from another figure.
     *
     * @param filmFigure Original figure
     */
    public FilmCircle(Film filmFigure) {
        super((Figure) filmFigure);
    }


}
