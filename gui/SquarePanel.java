/**
 * Represents a single square on the chessboard
 * Handles piece display and user interaction on squares
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
    * Initializes squares with position, game reference, chessboard panel reference, and settings
    * Sets layout and adds mouse listener for user interaction
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
     * Sets piece on the square and updates the display
     * If piece is null, clears the square
     * Otherwise, loads the piece image based on piece style settings
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

    /**
     * Generates the image path for the piece based on its type, color, and style settings
     * Path format: /images/{pieceStyle}_{pieceColor}{pieceType}.png
     * @param piece
     * @return
     */
    private String getImagePath(Piece piece) {
        String color = piece.getColor();
        String type = piece.getClass().getSimpleName().toLowerCase();

        return "/images/" + settings.pieceColor + "_"+ color + type + ".png";
    }
    
    /**
     * Highlight the square with a red border if selected
     */
    public void highlight(boolean selected) {
        if(selected) {
            setBorder(BorderFactory.createLineBorder(Color.RED, 3));
        } else {
            setBorder(null);
        }
    }
}
