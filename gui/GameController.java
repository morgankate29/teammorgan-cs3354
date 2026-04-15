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
     * If no piece is selected, select the piece at the clicked position
     * If a piece is already selected, move the piece to the clicked position if valid
     * If the move results in capturing the king, display a message and terminate the program
     * After click, clear the selection and highlights
     */
    public static void handleClick(Position pos, Game game, ChessBoardPanel cbp) {
        Board board = game.getBoard();
        Piece piece = board.getPiece(pos);

        if(selectedPos == null) {
            if(piece == null) {
                return;
            }

            selectedPos = pos;
            cbp.highlightSquare(pos);
            return;
        }

        Piece movingPiece = board.getPiece(selectedPos);
        Piece targetPiece = board.getPiece(pos);

        boolean moveSuccessful = board.movePiece(selectedPos, pos);

        if(moveSuccessful) {
            if(targetPiece instanceof King) {
                JOptionPane.showMessageDialog(null, movingPiece.getColor() + " wins!");
                System.exit(0);
            }
            cbp.refresh();
        }
        
        selectedPos = null;
        cbp.highlightSquare(pos);
    }

    public static void resetSelection() {
        selectedPos = null;
    }
}
