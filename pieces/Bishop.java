package pieces;

import utils.Position;
import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece{
    public Bishop(String color, Position position) {
        super(color, position);
        pieceRep = "B";
    }

    @Override
    public List<Position> possibleMoves(Piece[][] board) {
        List<Position> moves = new ArrayList<>();

        int row = position.getRow();
        int col = position.getCol();

        /** 
         * Move up and to the left
         */
        for(int i = 1; row - i >= 0 && col - i >= 0; i++) {
            if(!addMove(board, moves, row - i, col - i)) {
                break;
            }
        }
        
        /**
         * Move up and to the right
         */
        for(int i = 1; row - i >= 0 && col + i < 8; i++) {
            if(!addMove(board, moves, row - i, col + i)) {
                break;
            }
        }

        /** 
         * Move down and to the left
         */
        for(int i = 1; row + i < 8 && col - i >= 0; i++) {
            if(!addMove(board, moves, row + i, col - i)) {
                break;
            }
        }

        /** 
         * Move down and to the right
         */
        for(int i = 1; row + i < 8 && col + i < 8; i++) {
            if(!addMove(board, moves, row + i, col + i)) {
                break;
            }
        }

        return moves;
    }

    private boolean addMove(Piece[][] board, List<Position> moves, int r, int c) {
        Piece target = board[r][c];

        if(board[r][c] == null) {
            moves.add(new Position(r, c));
            return true;
        }
        if(!target.getColor().equals(this.color)) {
            moves.add(new Position(r, c));
        }

        return false;
    }

    public Piece copy() {
        return new Bishop(this.color, new Position(this.position.getRow(), this.position.getCol()));
    }
}
