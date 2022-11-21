package View;

import Entities.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewPlaylistOutputDataView extends JFrame implements ActionListener {
    private final int FONTSIZE = 10;
    private final int WIDTH = 400;
    private final int HEIGHT = 400;
    private JFrame jframe;
    private JButton homeButton;

    private String message;

    private User user;

    public NewPlaylistOutputDataView(User user, String message){
        this.initializeValues(user,message);
        this.initializeComponents();
        this.initializeFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.homeButton) {
            this.jframe.dispose();
            playlistView userDashboard = new playlistView(user);
        }
    }

    private void initializeValues(User user, String message) {

        this.user = user;
        this.message = message + " Click to Return to dashboard!";
        this.jframe = new JFrame();
        this.jframe.setSize(this.WIDTH, this.HEIGHT);
        this.jframe.setResizable(false);
        this.jframe.getContentPane().setBackground(new Color(49, 0, 74));
        //this.jframe.getContentPane().setBackground(new Color(34, 139, 34));
        this.jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initializeComponents() {

        this.homeButton = new JButton(this.message);
        this.homeButton.setBounds(25,25, 75,75);
        this.homeButton.setFocusable(false);
        this.homeButton.setHorizontalTextPosition(JButton.CENTER);
        this.homeButton.setBackground(Color.white);
        this.homeButton.setOpaque(true);

        this.homeButton.addActionListener(this);
    }

    private void initializeFrame() {
        this.jframe.add(homeButton);
        this.jframe.setVisible(true);
    }
}
