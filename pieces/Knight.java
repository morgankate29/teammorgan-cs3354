package pieces;

import utils.Position;
import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece{
    public Knight(String color, Position position) {
        super(color, position);
        pieceRep = "N";
    }

    @Override
    public List<Position> possibleMoves(Piece[][] board) {
        List<Position> moves = new ArrayList<>();

        int row = position.getRow();
        int col = position.getCol();

        /** 
         * Array stores all possible moves for knight
         */
        int[][] allMoves = {
            {1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}
        };

        for(int i = 0; i < allMoves.length; i++) {
            int r = row + allMoves[i][0];
            int c = col + allMoves[i][1];

            if(r >= 0 && r < 8 && c >= 0 && c < 8) {
                Piece target = board[r][c];
                if(target == null || !target.getColor().equals(this.color)) {
                    moves.add(new Position(r, c));
                }
            }
        }

        return moves;

    }

    public Piece copy() {
        return new Knight(this.color, new Position(this.position.getRow(), this.position.getCol()));
    }
}
