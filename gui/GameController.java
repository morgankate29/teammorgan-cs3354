/**
 * Handles user interaction and gameplay
 */
package gui;

import game.Game;
import pieces.King;
import pieces.Piece;
import utils.Position;

import javax.swing.*;

import board.Board;

public class GameController {
    private static Position selectedPos = null;

    /**
     * Handles user mouse clicks
     */
    public static void handleClick(Position pos, Game game, ChessBoardPanel cbp) {
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

        if(targetPiece instanceof King) {
            JOptionPane.showMessageDialog(null, movingPiece.getColor() + " wins!");
            System.exit(0);
        }
        
        board.movePiece(selectedPos, pos);
        cbp.refresh();
        selectedPos = null;
    }
}
