package View;

import Entities.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Output view when a playlist is created
 */
public class NewPlaylistOutputDataView extends JFrame implements ActionListener {
    private JFrame jframe;
    private JButton homeButton;
    private String message;

    /**
     * @param message the message to display
     */
    public NewPlaylistOutputDataView(String message){
        this.initializeValues(message);
        this.initializeComponents();
        this.initializeFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.homeButton) {
            this.jframe.dispose();
        }
    }

    /**
     * @param message the message to display
     */
    private void initializeValues(String message) {
        this.message = message + " Click to return to dashboard!";
        this.jframe = new JFrame();
        this.jframe.setSize(300, 300);
        this.jframe.setResizable(false);
        this.jframe.getContentPane().setBackground(new Color(49, 0, 74));
        this.jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Initializes swing components
     */
    private void initializeComponents() {
        this.homeButton = new JButton(this.message);
        this.homeButton.setBounds(25,25, 75,75);
        this.homeButton.setFocusable(false);
        this.homeButton.setHorizontalTextPosition(JButton.CENTER);
        this.homeButton.setBackground(Color.white);
        this.homeButton.setOpaque(true);

        this.homeButton.addActionListener(this);
    }

    /**
     * Initializes the main window
     */
    private void initializeFrame() {
        this.jframe.add(homeButton);
        this.jframe.setVisible(true);
    }
}
