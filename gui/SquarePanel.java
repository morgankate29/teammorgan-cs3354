/**
 * Represents a single square on the chessboard
 */

package gui;

import javax.swing.*;

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
     * @param cbp 
    */
    public SquarePanel(Position position, Game game, ChessBoardPanel cbp) {
        this.position = position;
        this.game = game;
        this.cbp = cbp;

    }
}
