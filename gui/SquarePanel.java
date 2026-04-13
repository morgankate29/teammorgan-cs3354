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

    private JLabel pieceLabel;

    /**
    * Constructor
     * Initializes position, game, and boardPanel
    */
    public SquarePanel(Position position, Game game, ChessBoardPanel cbp) {
        this.position = position;
        this.game = game;
        this.cbp = cbp;

        setLayout(new BorderLayout());

        pieceLabel = new JLabel();
        pieceLabel.setHorizontalAlignment(JLabel.CENTER);
        pieceLabel.setVerticalAlignment(JLabel.CENTER);
        add(pieceLabel, BorderLayout.CENTER);

        addMouseListener(new MouseAdapter() {
            @Override
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

        if(piece == null) {
            pieceLabel.setIcon(null);
        } else {
            String path = getImagePath(piece);
            ImageIcon icon = new ImageIcon(getClass().getResource(path));
            Image image = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            pieceLabel.setIcon(new ImageIcon(image));
        }
        repaint();
    }

    private String getImagePath(Piece piece) {
        String color = piece.getColor();
        String type = piece.getClass().getSimpleName().toLowerCase();

        return "/images/" + color + type + ".png";
    }

    public void highlight(boolean selected) {
        if(selected) {
            setBorder(BorderFactory.createLineBorder(Color.RED, 3));
        } else {
            setBorder(null);
        }
    }
}
