/**
 * Displays the 8x8 board
 * Gets data from the Game and Board classes
 */

package gui;

import javax.swing.*;

import java.awt.*;

import game.Game;
import pieces.Piece;
import board.Board;
import utils.Position;

public class ChessBoardPanel extends JPanel {
    private SquarePanel[][] squarePlaces = new SquarePanel[8][8];
    private Game game;

    /**
     * Constructor with game object
     * Creates 8x8 grid with squares
     * Alternates colors on grid
     * Gets pieces from Board
     */
    public ChessBoardPanel(Game game) {
        this.game = game;
        setLayout(new GridLayout(8, 8));

        for(int r = 0; r < 8; r++) {
            for(int c = 0; c < 8; c++) {
                Position position = new Position(r, c);
                SquarePanel sp = new SquarePanel(position, game, null);
                squarePlaces[r][c] = sp;

                if((r + c) % 2 == 0) {
                    sp.setBackground(Color.WHITE);
                } else {
                    sp.setBackground(Color.BLACK);
                }

                add(sp);
            }
        }
    }

    public void refresh() {
        Board board = game.getBoard();
        
        for (int r = 0; r < 8; r++) {
            for (int c = 0;c < 8; c++) {
                Position pos = new Position(r,c);
                Piece piece = board.getPiece(pos);
                squarePlaces[r][c].setPiece(piece);
            }
        }
        repaint();
    }

}