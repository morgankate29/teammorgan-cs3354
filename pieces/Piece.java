package pieces;

import utils.Position;
import java.util.List;
import java.io.Serializable;

public abstract class Piece implements Serializable {
    protected String color;
    protected Position position;
    protected String pieceRep;

    public Piece(String color, Position position) {
        this.color = color;
        this.position = position;
    }

    public String getColor() {
        return color;
    }

    public Position getPosition() {
        return position;
    }

    public void move(Position newPosition) {
        this.position = newPosition;
    }

    public abstract List<Position> possibleMoves(Piece[][] board);

    @Override
    public String toString() {
        if(color.equals("white")) {
            return "w" + pieceRep;
        } else {
            return "b" + pieceRep;
        }
    }

}
