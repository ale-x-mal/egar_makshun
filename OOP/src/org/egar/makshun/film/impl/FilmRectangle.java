package org.egar.makshun.film.impl;

import org.egar.makshun.figure.Figure;
import org.egar.makshun.figure.ext.Rectangle;
import org.egar.makshun.film.Film;

/**
 * Class FilmRectangle extends Rectangle and implements Film.
 *
 * @author Makshun Aleksey
 */
public class FilmRectangle extends Rectangle implements Film {
    /**
     * Constructor to create a FilmRectangle.
     *
     * @param width  Rectangle width
     * @param height Rectangle height
     */
    public FilmRectangle(double width, double height) {
        super(width, height);
    }

    /**
     * Constructor to create a FilmRectangle from another figure.
     *
     * @param filmFigure Original figure
     */
    public FilmRectangle(Film filmFigure) {
        super((Figure) filmFigure);
    }
}
