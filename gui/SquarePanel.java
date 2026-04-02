package gui;

import javax.swing.*;
import javax.swing.text.Position;

import game.Game;
import pieces.Piece;

public class SquarePanel extends JPanel {
    private Position position;
    private Piece piece;

    public SquarePanel(Position position, Game game) {
        this.position = position;
    }
}
