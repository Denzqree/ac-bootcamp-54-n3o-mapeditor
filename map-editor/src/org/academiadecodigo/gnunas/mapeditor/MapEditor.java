package org.academiadecodigo.gnunas.mapeditor;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.io.*;

/**
 * Created by codecadet on 21/10/2020.
 */
public class MapEditor implements KeyboardHandler {

    private Field field = null;

    private BufferedReader inputStream = null;

    private Cursor cursor = null;

    public MapEditor(int cols, int rows) {
        this.field = new Field(cols, rows);
    }

    public void readSave() {
        try {
            inputStream = new BufferedReader(new FileReader("resources/savedata/save.dat"));
        } catch (FileNotFoundException e) {
            System.out.println("Save not found !");
            try {
                inputStream.close();
            } catch (IOException e1) {
                System.out.println("Error opening the save data (stream.close() failed)");
            }
        }

        String bufferedLine = "";

        try {
            bufferedLine = inputStream.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(bufferedLine);


    }

    public void start() {

        Keyboard keyboard = new Keyboard(this);
        KeyboardEvent keyboardEventPressW = new KeyboardEvent();
        KeyboardEvent keyboardEventPressS = new KeyboardEvent();
        KeyboardEvent keyboardEventPressA = new KeyboardEvent();
        KeyboardEvent keyboardEventPressD = new KeyboardEvent();
        KeyboardEvent keyboardEventPressSpace = new KeyboardEvent();
        keyboardEventPressW.setKey(KeyboardEvent.KEY_W);
        keyboardEventPressS.setKey(KeyboardEvent.KEY_S);
        keyboardEventPressA.setKey(KeyboardEvent.KEY_A);
        keyboardEventPressD.setKey(KeyboardEvent.KEY_D);
        keyboardEventPressSpace.setKey(KeyboardEvent.KEY_SPACE);
        keyboardEventPressW.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventPressS.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventPressA.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventPressD.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventPressSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventPressW);
        keyboard.addEventListener(keyboardEventPressS);
        keyboard.addEventListener(keyboardEventPressA);
        keyboard.addEventListener(keyboardEventPressD);
        keyboard.addEventListener(keyboardEventPressSpace);

        field.init();

        readSave();

        this.cursor = new Cursor(this.field);

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_W:
                cursor.moveUp();
                break;
            case KeyboardEvent.KEY_D:
                cursor.moveRight();
                break;
            case KeyboardEvent.KEY_S:
                cursor.moveDown();
                break;
            case KeyboardEvent.KEY_A:
                cursor.moveLeft();
                break;
            case KeyboardEvent.KEY_SPACE:
                field.paintAtCursor(this.cursor);
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

}