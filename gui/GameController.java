/**
* Handles user interaction and gameplay
*/
package gui;

import game.*;
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
     * Checks for check and checkmate after the move
     * Shows dialog messages for check and checkmate
     * After click, clear the selection and highlights
     */
    public static void handleClick(Position pos, Game game, ChessBoardPanel cbp) {
        Board board = game.getBoard();
        Piece piece = board.getPiece(pos);

        if(selectedPos == null) {
            if(piece == null) {
                return;
            }

            if(!piece.getColor().equals(game.getUserTurn())) {
                return;
            }

            selectedPos = pos;
            cbp.highlightSquare(pos);
            return;
        }

        Piece movingPiece = board.getPiece(selectedPos);

        if(movingPiece == null) {
            selectedPos = null;
            cbp.clearHighlight();
            return;
        }

        MoveResult result = game.makeMove(selectedPos, pos);

        if(result != null && result.moved) {
            cbp.refresh();

            if(result.check) {
                JOptionPane.showMessageDialog(null, "Check!");
            }

            if(result.checkmate) {
                JOptionPane.showMessageDialog(null, "Checkmate! " + game.getUserTurn() + " wins!");
                System.exit(0);
            }
        }

        selectedPos = null;
        cbp.clearHighlight();
    }

    /**
     * Resets the selected position to null, clearing any selection
     */
    public static void resetSelection() {
        selectedPos = null;
    }

}
