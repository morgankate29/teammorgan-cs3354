/**
 * Represents a single square on the chessboard
 */

package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import game.Game;
import pieces.Piece;
import utils.Position;

public class SquarePanel extends JPanel {
    private Position position;
    private Piece piece;
    private Game game;
    private ChessBoardPanel cbp;

    /**
    * Constructor
     * Initializes position, game, and boardPanel
    */
    public SquarePanel(Position position, Game game, ChessBoardPanel cbp) {
        this.position = position;
        this.game = game;
        this.cbp = cbp;

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                GameController.handleClick(position, game, cbp);
            }
        });
    }

    /**
     * Sets a piece on a square
     * Also redraws square
     */
    public void setPiece(Piece piece) {
        this.piece = piece;
        repaint();
    }
}
