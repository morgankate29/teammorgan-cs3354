/**
 * Handles user interaction and gameplay
 */
package gui;

import game.Game;
import utils.Position;

import javax.swing.*;

public class GameController {
    private static Position selectedPos = null;

    /**
     * Handles user mouse clicks
     */
    public static void handleClick(Position pos, Game game, ChessBoardPanel, cbp) {
        if(selectedPos == null) {
            selectedPos = pos;
            return;
        }

        Board board = game.getBoard();
        Piece movingPiece = board.getPiece(selectedPos);
        Piece targetPiece = board.getPiece(pos);

        if(movingPiece == null) {
            selectedPos = null;
            return;
        }
    }
}
