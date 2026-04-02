package gui;

import javax.swing.*;
import game.Game;

public class ChessBoardPanel extends JPanel {
    private SquarePanel[][] squarePlaces = new SquarePanel[8][8];
    private Game game;
}