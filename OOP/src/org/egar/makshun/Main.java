package org.egar.makshun;

import org.egar.makshun.figure.Figure;
import org.egar.makshun.film.impl.FilmCircle;
import org.egar.makshun.film.impl.FilmRectangle;
import org.egar.makshun.film.impl.FilmTriangle;
import org.egar.makshun.paper.impl.PaperCircle;
import org.egar.makshun.paper.impl.PaperRectangle;
import org.egar.makshun.paper.impl.PaperTriangle;
import org.egar.makshun.paper.Paper;

import java.util.ArrayList;
import java.util.List;

/**
 * Main class.
 *
 * @author Makshun Aleksey
 */
public class Main {

    /**
     * Main method.
     *
     * @param args arguments
     */
    public static void main(String[] args) {

        List<Figure> figureList = new ArrayList<>();

        FilmCircle filmCircle1 = new FilmCircle(10);
        figureList.add(filmCircle1);

        FilmRectangle filmRectangle1 = new FilmRectangle(10, 20);
        figureList.add(filmRectangle1);

        FilmTriangle filmTriangle1 = new FilmTriangle(7);
        figureList.add(filmTriangle1);

        PaperCircle paperCircle1 = new PaperCircle(10);
        paperCircle1.setColor(Paper.Color.RED);
        figureList.add(paperCircle1);

        PaperRectangle paperRectangle1 = new PaperRectangle(15, 30);
        paperRectangle1.setColor(Paper.Color.GREEN);
        figureList.add(paperRectangle1);

        PaperTriangle paperTriangle1 = new PaperTriangle(15);
        paperTriangle1.setColor(Paper.Color.BLUE);
        figureList.add(paperTriangle1);

        FilmCircle filmCircle2 = new FilmCircle(filmRectangle1);
        figureList.add(filmCircle2);

        FilmRectangle filmRectangle2 = new FilmRectangle(filmTriangle1);
        figureList.add(filmRectangle2);

        FilmTriangle filmTriangle2 = new FilmTriangle(filmCircle1);
        figureList.add(filmTriangle2);

        PaperCircle paperCircle2 = new PaperCircle(paperTriangle1);
        figureList.add(paperCircle2);

        PaperRectangle paperRectangle2 = new PaperRectangle(paperCircle1);
        figureList.add(paperRectangle2);

        PaperTriangle paperTriangle2 = new PaperTriangle(paperRectangle1);
        figureList.add(paperTriangle2);

        StringBuilder sb = new StringBuilder("---------------------\n");
        figureList.forEach(e -> sb.append(e).append("\n"));
        System.out.println("In the figureList " + figureList.size() + " figures:\n" + sb);

    }

}
