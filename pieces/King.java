package pieces;

import utils.Position;
import java.util.ArrayList;
import java.util.List;

public class King extends Piece{
    public King(String color, Position position) {
        super(color, position);
        pieceRep = "K";
    }

    @Override
    public List<Position> possibleMoves(Piece[][] board) {
        List<Position> moves = new ArrayList<>();

        int row = position.getRow();
        int col = position.getCol();

        for(int i = row - 1; i <= row + 1; i++) {
            for(int j = col - 1; j <= col + 1; j++) {
                if(i == row && j == col) {
                    continue;
                }

                if(i >= 0 && i < 8 && j >= 0 && j < 8) {
                    Piece target = board[i][j];
                    if(target == null || !target.getColor().equals(this.color)) {
                        moves.add(new Position(i, j));
                    }
                }
            }
        }
        return moves;
    }
}
