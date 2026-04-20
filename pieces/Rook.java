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
            if(!addMove(board, moves, i, col)) {
                break;
            }
        }

        /** 
         * Moving down
         */
        for(int i = row + 1; i < 8; i++) {
            if(!addMove(board, moves, i, col)) {
                break;
            }
        }

        /** 
         * Moving left
         */
        for(int j = col - 1; j >= 0; j--) {
            if(!addMove(board, moves, row, j)) {
                break;
            }
        }

        /** 
         * Moving right
         */
        for(int j = col + 1; j < 8; j++) {
            if(!addMove(board, moves, row, j)) {
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
}
