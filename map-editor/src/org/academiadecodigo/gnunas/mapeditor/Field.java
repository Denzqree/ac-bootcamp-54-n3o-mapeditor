package org.academiadecodigo.gnunas.mapeditor;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.LinkedHashMap;

/**
 * Created by codecadet on 21/10/2020.
 */
public class Field {

    private int CELLSIZE = 30; // CELL SIZE IN PIXELS
    private int PADDING = 10; // PADDING IN PIXELS
    private int cols; // MAX COLUMNS
    private int rows; // MAX ROWS
    private LinkedHashMap<Integer, Position> colMap; // Col map by line
    private LinkedHashMap<Integer, LinkedHashMap<Integer, Position>> positionsMap; // All positions which have a row and a col
    private Rectangle field;

    public Field(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
    }

    public void init() {

        colMap = new LinkedHashMap<>(cols);
        positionsMap = new LinkedHashMap<>(rows);

        field = new Rectangle(PADDING, PADDING, fieldWidth(), fieldHeight());
        field.draw();

        for (int row = 0; row < rows; row++) {
            colMap = new LinkedHashMap<>(cols);
            for (int col = 0; col < cols; col++) {

                Position newPos = new Position(this,col,row);
                colMap.put(col, newPos);
            }

            positionsMap.put(row, colMap);
        }
    }

    public int getPADDING() {
        return PADDING;
    }

    public int getCELLSIZE() {
        return CELLSIZE;
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public int fieldWidth() {
        return cols * CELLSIZE;
    }

    public int fieldHeight() {
        return rows * CELLSIZE;
    }

    public int columnToX(int col) {
        return PADDING + CELLSIZE * col;
    }

    public int rowToY(int row) {
        return PADDING + CELLSIZE * row;
    }

    public void paintAtCursor(Cursor cursor) {
        Position cursorToFieldPosition = positionsMap.get(cursor.getPosition().getRow()).get(cursor.getPosition().getCol());
        cursorToFieldPosition.colour(Color.ORANGE);
        cursorToFieldPosition.paint();
    }
}
