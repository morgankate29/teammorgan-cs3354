/**
 * Main JFrame window for the GUI
 */

package gui;

import javax.swing.*;

import java.awt.*;

import game.Game;
import utils.GameIO;

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
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        ChessBoardPanel cbp = new ChessBoardPanel(game);
        add(cbp, BorderLayout.CENTER);

        setJMenuBar(createMenuBar(game, cbp));

        setVisible(true);
    }

    private JMenuBar createMenuBar(Game game, ChessBoardPanel cbp) {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");

        JMenuItem newGame = new JMenuItem("New Game");
        JMenuItem saveGame = new JMenuItem("Save Game");
        JMenuItem loadGame = new JMenuItem("Load Game");

        fileMenu.add(newGame);
        fileMenu.add(saveGame);
        fileMenu.add(loadGame);

        menuBar.add(fileMenu);

        newGame.addActionListener(e -> {
            game.reset();
            cbp.refresh();
        });

        saveGame.addActionListener(e -> {
            GameIO.saveGame(game);
            JOptionPane.showMessageDialog(this, "Game saved!");
        });

        loadGame.addActionListener(e -> {
            Game loaded = GameIO.loadGame();
            if(loaded != null) {
                this.dispose();
                new ChessFrame(loaded);
            }
        });

        return menuBar;
    }
}
