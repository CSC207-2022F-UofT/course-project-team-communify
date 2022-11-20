package View;

import Entities.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchOutputView extends JFrame implements ActionListener {

    private final int FONTSIZE = 10;
    private final int WIDTH = 640;
    private final int HEIGHT = 640;
    private JFrame jframe;
    private JButton submitButton;
    private JButton homeButton;
    private JTextField songNameTextField;

    private User user;


    public SearchOutputView(User user) {
        this.initializeValues();
        this.initializeComponents();
        this.initializeFrame();
        this.user = user;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.submitButton) {
            String songName = this.songNameTextField.getText();

            // run your search use case as needed, may need to add parameters and such,
            // look at sarah's space use case and find a way to output the songs that match the search maybe in a JPanel or Scrollable J panel
            // Refer to swing notes in project's google drive for most of the stuff

        } else if (e.getSource() == this.homeButton) {
            this.jframe.dispose();
            PlaylistView userDashboard = new PlaylistView(user);    //enter a User parameter in playlistView() to open new window
        }
    }


    private void initializeValues() {
        this.jframe = new JFrame();
        this.jframe.setSize(this.WIDTH, this.HEIGHT);
        this.jframe.setResizable(false);
        this.jframe.getContentPane().setBackground(new Color(185, 226, 246));
        this.jframe.setLayout(null);
        this.jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    private void initializeComponents() {
        this.submitButton = new JButton();
        this.submitButton.setBounds(100, 400, 100, 50);
        this.submitButton.setText("Search");
        this.submitButton.setFocusable(false);
        this.submitButton.setHorizontalTextPosition(JButton.CENTER);
        this.submitButton.setForeground(Color.black);
        this.submitButton.setBackground(Color.lightGray);

        this.homeButton = new JButton();
        this.homeButton.setBounds(300, 400, 100, 50);
        this.homeButton.setText("Home");
        this.homeButton.setFocusable(false);
        this.homeButton.setHorizontalTextPosition(JButton.CENTER);
        this.homeButton.setForeground(Color.black);
        this.homeButton.setBackground(Color.lightGray);

        this.songNameTextField = new JTextField();
        this.songNameTextField.setBounds(0, 0, 300, 50);

        this.submitButton.addActionListener(this);
        this.homeButton.addActionListener(this);
    }


    private void initializeFrame() {
        this.jframe.add(submitButton);
        this.jframe.add(songNameTextField);
        this.jframe.add(homeButton);
        this.jframe.setVisible(true);
    }
}