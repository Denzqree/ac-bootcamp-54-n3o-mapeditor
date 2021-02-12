package org.academiadecodigo.gnunas.mapeditor;

import org.academiadecodigo.simplegraphics.graphics.Color;

/**
 * Created by codecadet on 21/10/2020.
 */
public class Cursor {

    private int col = 0; // CURSOR STARTS AT COL 0
    private int row = 0; // - AND ROW 0
    private Field field;

    private Position position;

    public Cursor(Field field) {
        this.field = field;
        this.position = new Position(field, col, row);
        this.position.colour(Color.CYAN);
        this.position.paint();
    }

    public Position getPosition() {
        return position;
    }

    public void moveUp() {

        if (this.row > 0) {

            this.row -= 1;
            position.moveToRow(this.row);
        }
    }

    public void moveRight() {

        if (this.col < field.getCols() - 1) {

            this.col += 1;
            position.moveToCol(this.col);
        }
    }

    public void moveDown() {

        if (this.row < field.getRows() - 1) {

            this.row += 1;
            position.moveToRow(this.row);
        }
    }

    public void moveLeft() {

        if (this.col > 0) {

            this.col -= 1;
            position.moveToCol(this.col);
        }
    }

}
