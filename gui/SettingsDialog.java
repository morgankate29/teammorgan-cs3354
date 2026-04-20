/**
 * SettingsDialog class
 * Dialog window for customizing chess board settings
 * Allows user to change board colors, piece styles, and square size
 */
package gui;

import javax.swing.*;
import java.awt.*;

public class SettingsDialog extends JDialog{
    /**
     * Constructor to initialize the settings dialog
     * Creates colors for board, piece styles, and square size options
     * Adds action listener to apply button to update settings and referesh the board
     * 
     * @param parent
     * @param settings
     * @param cbp
     */
    public SettingsDialog(JFrame parent, Settings settings, ChessBoardPanel cbp) {
        super(parent, "Settings", true);
        setSize(300, 300);
        setLayout(new GridLayout(4, 2));

        JComboBox<String> colorChoice = new JComboBox<>(new String[]{"Green(Default)", "Pink", "Blue"});
        JComboBox<String> pieceChoice = new JComboBox<>(new String[]{"Default", "Brown"});
        JComboBox<String> sizeChoice = new JComboBox<>(new String[]{"Small", "Medium", "Large"});

        JButton applyButton = new JButton("Apply");

        add(new JLabel("Board Color:"));
        add(colorChoice);

        add(new JLabel("Piece Color:"));
        add(pieceChoice);

        add(new JLabel("Board Size:"));
        add(sizeChoice);

        add(new JLabel());
        add(applyButton);

        applyButton.addActionListener(e -> {
            if(colorChoice.getSelectedItem().equals("Green(Default)")) {
                settings.lightColor = new Color(175, 196, 175);
                settings.darkColor = new Color(54, 79, 54);
            } else if(colorChoice.getSelectedItem().equals("Pink")) {
                settings.lightColor = new Color(232, 174, 199);
                settings.darkColor = new Color(156, 59, 101);
            } else {
                settings.lightColor = new Color(138, 159, 209);
                settings.darkColor = new Color(46, 71, 130);
            }

            settings.pieceColor = (String) pieceChoice.getSelectedItem();

            switch((String) sizeChoice.getSelectedItem()) {
                case "Small":
                    settings.squareSize = 60;
                    break;
                case "Medium":
                    settings.squareSize = 80;
                    break;
                case "Large":
                    settings.squareSize = 100;
                    break;
            }

            cbp.applySettings();
            cbp.revalidate();
            cbp.repaint();
            
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(cbp);
            frame.pack();

        });
        setVisible(true);
    }
}
