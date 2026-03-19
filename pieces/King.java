package pieces;

import utils.Position;
import java.util.ArrayList;
import java.util.List;

public class King extends Piece{
    public King(String color, Position position) {
        super(color, position);
    }

    private boolean valid(int row, int col) {
        if((row >= 0 && row < 8) && (col >= 0 && col <8)) {
            return true;
        } else {
            return false;
        }
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

                if(valid(i, j)) {
                    moves.add(new Position(i, j));
                }
            }
        }
        return moves;
    }
}
