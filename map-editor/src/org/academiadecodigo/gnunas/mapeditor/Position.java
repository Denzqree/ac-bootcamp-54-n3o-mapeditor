package org.academiadecodigo.gnunas.mapeditor;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by codecadet on 21/10/2020.
 */
public class Position{

    private final Field field;
    private Rectangle frame;
    private int col;
    private int row;
    private int positionIndex;
    private int CELLSIZE;
    private int x;
    private int y;
    private boolean isPainted;

    public Position(Field field, int col, int row){
        this.field = field;
        this.col = col;
        this.row = row;
        this.CELLSIZE = this.field.getCELLSIZE();
        this.x = this.field.columnToX(this.col);
        this.y = this.field.rowToY(this.row);
        frame = new Rectangle(x,y,CELLSIZE,CELLSIZE);
        frame.draw();
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public void paint() {
        if(!isPainted){
            frame.fill();
            isPainted = true;
            return;
        }

        frame.setColor(Color.BLACK);
        frame.draw();
        isPainted = false;
    }

    public void colour(Color color){
        frame.setColor(color);
    }

    public void setX(int col){
        this.x = this.field.columnToX(col);
    }

    public void setY(int row){
        this.y = this.field.rowToY(row);
    }

    public void moveToCol(int col) {
        int xBefore = field.columnToX(this.col);
        this.col = col;
        setX(this.col);
        frame.translate(x-xBefore,0);
    }

    public void moveToRow(int row) {
        int yBefore = field.rowToY(this.row);
        this.row = row;
        setY(this.row);
        frame.translate(0,y-yBefore);
    }
}
