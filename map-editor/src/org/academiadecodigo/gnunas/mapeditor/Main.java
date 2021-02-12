package org.academiadecodigo.gnunas.mapeditor;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import org.academiadecodigo.simplegraphics.graphics.Canvas;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;

/**
 * Created by codecadet on 21/10/2020.
 */
public class Main{

    private static MapEditor mapEditor = null;

    public static void main(String[] args) {

        mapEditor = new MapEditor(30,30);

        mapEditor.start();

    }
}
