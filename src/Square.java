import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;


/**
 * A class written to support the TicTacToe Game.
 *
 * Each Square object is one position of the TicTacToe
 * board. It maintains information on the marker, its
 * location on the board, and whether it is part
 * of the winning set.
 *
 * @author: Nandhini Namasivayam
 * @version: Jan 2023
 */

public class Square {

    private String marker;
    private int row;
    private int col;

    private final static int SQUARE_WIDTH = 150;

    private final static int SQUARE_HEIGHT = 150;

    private final static int STARTING_X = 75;
    private final static int STARTING_Y = 150;
    private boolean isWinningSquare;



    /**
     * Constructor to initialize one Square of the
     * TicTacToe board
     * @param row the row the square is in
     * @param col the column the square is in
     */
    public Square(int row, int col) {
        this.row = row;
        this.col = col;

        this.marker = TicTacToe.BLANK;
        this.isWinningSquare = false;
    }

    /******************** Getters and Setters ********************/
    public String getMarker() {
        return this.marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public void setWinningSquare() {
        this.isWinningSquare = true;
    }

    /**
     * Checks if the square has the BLANK marker
     * @return True if the square is empty, False otherwise
     */
    public boolean isEmpty() {
        return this.marker.equals(TicTacToe.BLANK);
    }

    /**
     * @return the marker for the square
     */
    public String toString() {
        return this.marker;
    }

    public void draw(Graphics g, Image x, Image y, TicTacToeViewer w) {
        g.setColor(Color.black);
        int my_x = STARTING_X + SQUARE_WIDTH * col;
        int my_y = STARTING_Y + SQUARE_WIDTH * row;
        g.drawRect(my_x,my_y, SQUARE_WIDTH, SQUARE_HEIGHT);
        if (this.getMarker().equals("X")) {
            g.drawImage(x, my_x,my_y ,SQUARE_WIDTH, SQUARE_HEIGHT, w);
        }
        if (this.getMarker().equals("O")) {
            g.drawImage(y, my_x,my_y ,SQUARE_WIDTH, SQUARE_HEIGHT, w);
        }
    }
}
