/**
 * Main JFrame window for the GUI
 */

package gui;

import javax.swing.*;
import java.awt.*;

import game.Game;

public class ChessFrame extends JFrame {
    /**
     * Constructor to initialize the window
     * Sets title and size of the window
     * Makes sure the program closes when window closes
     * Set a border layout
     * Makes the window visible
     */
    public ChessFrame(Game game) {
        setTitle("Chess Game");
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        add(new ChessBoardPanel(game), BorderLayout.CENTER);

        setVisible(true);
    }
}
