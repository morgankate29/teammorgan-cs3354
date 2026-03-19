package pieces;

import utils.Position;
import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece{
    public Queen(String color, Position position) {
        super(color, position);
    }

    /** 
     * Moves are Rook and Bishop combined
     */
    @Override
    public List<Position> possibleMoves(Piece[][] board) {
        List<Position> moves = new ArrayList<>();

        int row = position.getRow();
        int col = position.getCol();

        /** 
         * Moving up
         */
        for(int i = row - 1; i >= 0; i--) {
            moves.add(new Position(i, col));
            if(board[i][col] != null) {
                break;
            }
        }

        /** 
         * Moving down
         */
        for(int i = row + 1; i < 8; i++) {
            moves.add(new Position(i, col));
            if(board[i][col] != null) {
                break;
            }
        }

        /** 
         * Moving right
         */
        for(int i = col - 1; i >= 0; i--) {
            moves.add(new Position(row, i));
            if(board[row][i] != null) {
                break;
            }
        }

        /** 
         * Moving left
         */
        for(int i = col + 1; i < 8; i++) {
            moves.add(new Position(row, i));
            if(board[row][i] != null) {
                break;
            }
        }

        /** 
         * Move up and to the left
         */
        for(int i = 1; row - i >= 0 && col - 1 >= 0; i++) {
            moves.add(new Position(row - i, col - i));
            if(board[row - i][col - i] != null) {
                break;
            }
        }
        
        /** 
         * Move up and to the right
         */
        for(int i = 1; row - i >= 0 && col + 1 < 8; i++) {
            moves.add(new Position(row - i, col + i));
            if(board[row - i][col + i] != null) {
                break;
            }
        }

        /** 
         * Move down and to the left
         */
        for(int i = 1; row + i < 8 && col - 1 >= 0; i++) {
            moves.add(new Position(row + i, col - i));
            if(board[row + i][col - i] != null) {
                break;
            }
        }

        /** 
         * Move down and to the right
         */
        for(int i = 1; row + i < 8 && col + 1 < 8; i++) {
            moves.add(new Position(row + i, col + i));
            if(board[row + i][col + i] != null) {
                break;
            }
        }

        return moves;
    }
}
