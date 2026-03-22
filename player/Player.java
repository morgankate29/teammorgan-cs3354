// Contains player attributes and actions

package player;
import pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private String color;
    private ArrayList<Piece> availablePieces;

    public Player(String name, String color) {
        this.name = name;
        this.color = color;
        this.availablePieces = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Piece> getAvailablePieces() {
        return availablePieces;
    }
}
