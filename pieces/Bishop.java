package pieces;

import utils.Position;
import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece{
    public Bishop(String color, Position position) {
        super(color, position);
    }

    @Override
    public List<Position> possibleMoves(Piece[][] board) {
        List<Position> moves = new ArrayList<>();

        int row = position.getRow();
        int col = position.getCol();

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
