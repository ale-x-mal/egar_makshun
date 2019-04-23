package org.egar.makshun.paper;

/**
 * Interface Paper.
 *
 * @author Makshun Aleksey
 */
public interface Paper {
    /**
     * Enum class Color
     *
     * @author Makshun Aleksey
     */
    enum Color {
        WHITE, BLACK, RED, GREEN, BLUE, YELLOW
    }

    /**
     * The method displays the color of the figure.
     *
     * @return color
     */
    Color getColor();

    /**
     * The method paints a figure.
     *
     * @param color color
     */
    void setColor(Color color);

    /**
     * Method for painting figures.
     *
     * @return Painted
     */
    Painted getPainted();

    /**
     * Inner class for painting figures.
     *
     * @author Makshun Aleksey
     */
    class Painted {
        private Color color;

        /**
         * The method displays the color of the figure.
         *
         * @return color;
         */
        public Color getColor() {
            return color;
        }

        /**
         * The method paints a figure.
         *
         * @param color color
         */
        public void setColor(Color color) {
            if (this.color == null) {
                this.color = color;
            }
        }
    }


}
