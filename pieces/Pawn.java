package pieces;

import utils.Position;
import java.util.ArrayList;
import java.util.List;

// Class for the pawn chess piece
public class Pawn extends Piece{
    public Pawn(String color, Position position) {
        super(color, position);
    }

    // Function to check if the intended move is still on the board
    private boolean valid(int row, int col) {
        if((row >= 0 && row < 8) && (col >= 0 && col <8)) {
            return true;
        }
    }

    @Override
    public List<Position> possibleMoves(Piece[][] board) {
        List<Position> moves = new ArrayList<>();

        int direction;
        if(color.equals("black")) {
            direction = 1;
        } else {
            // If the piece is white
            direction = -1;
        }

        int row = position.getRow();
        int col = position.getCol();

        // Moving forward, only affects the row, not 
        if(valid(row + direction, col) && board[row + direction][col] == null) {
            moves.add(new Position(row + direction, col));
        }

        // Capture on right diagonal
        if(valid(row + direction, col + 1) && board[row + direction][col + 1] != null) {
            moves.add(new Position(row + direction, col + 1));
        }
        
        // Capture on left diagonal
        if(valid(row + direction, col - 1) && board[row + direction][col - 1] != null) {
            moves.add(new Position(row + direction, col - 1));
        }

        return moves;
    }
}
