//Aidan Skinner
import javax.swing.*;
import java.awt.*;
import java.util.PrimitiveIterator;


public class TicTacToeViewer extends JFrame {
    // TODO: Complete this class
    private TicTacToe backEnd;
    private Square[][] board;
    // Creates images objects
    private Image xImage;
    private Image oImage;

    public static final int WINDOW_WIDTH = 600;

    public static final int WINDOW_HEIGHT = 700;
    public TicTacToeViewer(Square[][] board, TicTacToe backEnd) {
        // Transfer array from back end to front end
        this.board = board;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Tic Tac Toe");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
        // Sets images from resources
        xImage = new ImageIcon("Resources/X.png").getImage();
        oImage = new ImageIcon("Resources/O.png").getImage();
        this.backEnd = backEnd;
    }

    public void paint(Graphics g) {
        // Clear the window.
        g.setColor(Color.white);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

        // Prints squares
        g.setColor(Color.black);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j].draw(g, xImage, oImage, this);
            }
        }
        // Draws rows and cols on board
        g.drawString("0", 150,125);
        g.drawString("1", 300,125);
        g.drawString("2", 450,125);
        g.drawString("0", 40,225);
        g.drawString("1", 40,375);
        g.drawString("2", 40,525);
        // Prints out the winner
        if (backEnd.getWinner().equals("X"))
        {
            g.setColor(Color.white);
            g.drawString("X Wins!", 275,650);
        }
        else if (backEnd.getWinner().equals("O"))
        {
            g.setColor(Color.white);
            g.drawString("O Wins!",275,650);
        }
    }


}
