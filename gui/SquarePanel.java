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
    private Settings settings;

    private JLabel pieceLabel;

    /**
    * Constructor
     * Initializes position, game, and boardPanel
    */
    public SquarePanel(Position position, Game game, ChessBoardPanel cbp, Settings settings) {
        this.position = position;
        this.game = game;
        this.cbp = cbp;
        this.settings = settings;

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

            int size = settings.squareSize - 10;
            java.net.URL url = getClass().getResource(path);

            if(url != null) {
                ImageIcon icon = new ImageIcon(url);
                Image image = icon.getImage().getScaledInstance(size, size, Image.SCALE_SMOOTH);
                pieceLabel.setIcon(new ImageIcon(image));
            } else {
                System.out.println("IMAGENOT FOUND" + path);
                pieceLabel.setIcon(null);
                return;
            }
        }
        repaint();
    }

    private String getImagePath(Piece piece) {
        String color = piece.getColor();
        String type = piece.getClass().getSimpleName().toLowerCase();

        return "/images/" + settings.pieceColor + "_"+ color + type + ".png";
    }

    public void highlight(boolean selected) {
        if(selected) {
            setBorder(BorderFactory.createLineBorder(Color.RED, 3));
        } else {
            setBorder(null);
        }
    }
}
