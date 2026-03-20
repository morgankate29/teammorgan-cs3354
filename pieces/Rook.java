package pieces;

import utils.Position;
import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece{
    public Rook(String color, Position position) {
        super(color, position);
        pieceRep = "R";
    }

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

        return moves;
    }
}
