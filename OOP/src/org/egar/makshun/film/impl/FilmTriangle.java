package org.egar.makshun.film.impl;

import org.egar.makshun.figure.Figure;
import org.egar.makshun.figure.ext.Triangle;
import org.egar.makshun.film.Film;

/**
 * Class FilmTriangle extends Triangle and implements Film.
 *
 * @author Makshun Aleksey
 */
public class FilmTriangle extends Triangle implements Film {
    /**
     * Constructor to create a FilmTriangle.
     *
     * @param side Triangle side
     */
    public FilmTriangle(double side) {
        super(side);
    }

    /**
     * Constructor to create a FilmTriangle from another figure.
     *
     * @param filmFigure Original figure
     */
    public FilmTriangle(Film filmFigure) {
        super((Figure) filmFigure);
    }
}
