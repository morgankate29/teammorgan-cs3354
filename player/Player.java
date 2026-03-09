// Contains player attributes and actions

package player;
import pieces.Piece;
import board.Board;
import utils.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    private String name;
    private String color;

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
