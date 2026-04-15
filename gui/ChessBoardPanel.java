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
    private Settings settings;

    /**
     * Constructor with game object
     * Creates 8x8 grid with squares
     * Alternates colors on grid, depending on the setting colors
     * Gets pieces from Board
     */
    public ChessBoardPanel(Game game, Settings settings) {
        this.game = game;
        this.settings = settings;

        setLayout(new GridLayout(8, 8));

        for(int r = 0; r < 8; r++) {
            for(int c = 0; c < 8; c++) {
                Position position = new Position(r, c);
                SquarePanel sp = new SquarePanel(position, game, this, settings);
                squarePlaces[r][c] = sp;

                if((r + c) % 2 == 0) {
                    sp.setBackground(settings.lightColor);
                } else {
                    sp.setBackground(settings.darkColor);
                }

                add(sp);
            }
        }

        refresh();
    }

    /**
     * Refreshes the board
     * Gets pieces form Board and updates the squares accordingly
     */
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

    /**
     * Highlights the square at the given position
     * @param pos
     */
    public void highlightSquare(Position pos) {
        for(int r = 0; r < 8; r++) {
            for(int c = 0; c < 8; c++) {
                squarePlaces[r][c].highlight(false);
            }
        }
        squarePlaces[pos.getRow()][pos.getCol()].highlight(true);
    }


    /**
     * Clears all highlights on the board
     */
    public void clearHighlight() {
        for(int r = 0; r < 8; r++) {
            for(int c = 0; c < 8; c++) {
                squarePlaces[r][c].highlight(false);
            }
        }
    }

    /**
     * Applies the settings to the board (square size and color)
     */
    public void applySettings() {
        int squareSize = settings.squareSize;
        int boardSize = squareSize * 8;
        setPreferredSize(new Dimension(boardSize, boardSize));

        for(int r = 0; r < 8; r++) {
            for(int c = 0; c < 8; c++) {
                SquarePanel sp = squarePlaces[r][c];
                sp.setPreferredSize(new Dimension(squareSize, squareSize));

                if((r + c) % 2 == 0) {
                    sp.setBackground(settings.lightColor);
                } else {
                    sp.setBackground(settings.darkColor);
                }
            }
        }

        revalidate();
        repaint();
    }

}