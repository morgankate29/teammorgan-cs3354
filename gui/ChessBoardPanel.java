package gui;

import javax.swing.*;
import java.awt.*;

import game.Game;
import utils.Position;

public class ChessBoardPanel extends JPanel {
    private SquarePanel[][] squarePlaces = new SquarePanel[8][8];
    private Game game;

    public ChessBoardPanel(Game game) {
        this.game = game;
        setLayout(new GridLayout(8, 8));

        for(int r = 0; r < 8; r++) {
            for(int c = 0; c < 8; c++) {
                Position position = new Position(r, c);
                SquarePanel sp = new SquarePanel(position, game);
                squarePlaces[r][c] = sp;
                add(sp);
            }
        }
    }
}