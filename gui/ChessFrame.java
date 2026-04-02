package gui;

import javax.swing.*;
import java.awt.*;

public class ChessFrame extends JFrame {
    public ChessFrame() {
        setTitle("Chess Game");
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setVisible(true);
    }
}
