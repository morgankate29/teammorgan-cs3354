/**
 * 
 */

package gui;

import javax.swing.*;

import game.Game;
import pieces.Piece;
import utils.Position;

public class SquarePanel extends JPanel {
    private Position position;
    private Piece piece;

    public SquarePanel(Position position, Game game) {
        this.position = position;
    }
}
