package pieces;

import utils.Position;
import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece{
    public Knight(String color, Position position) {
        super(color, position);
    }

    @Override
    public List<Position> possibleMoves(Piece[][] board) {
        List<Position> moves = new ArrayList<>();

        int row = position.getRow();
        int col = position.getCol();
    }
}
