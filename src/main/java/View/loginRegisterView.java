// **IMPORTANT, READ ME!**
// Strictly here to direct the user to either the artist login page or user login page
// THIS CAN BE CHANGED TO YOUR LIKING BUT I WILL MAKE A BOOLEAN PARAMETER FOR IS_USER
// IF IT IS_ARTIST THEN THE LOGIN INFO IS SENT TO THE ARTIST CREATION USE CASE
// IF IT IS NOT IS_ARTIST THEN THE LOGIN INFO IS SENT TO THE USER CREATION USE CASE

package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginRegisterView extends JFrame implements ActionListener {

    private final int FONTSIZE = 10;
    private final int WIDTH = 640;
    private final int HEIGHT = 640;
    private JFrame jframe;
    private JButton submitButton;
    private JCheckBox isArtistCheckBox;
    private JTextField usernameTextField;
    private JTextField passwordTextField;


    public loginRegisterView () {

        this.initializeValues();
        this.initializeComponents();
        this.initializeFrame();

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == submitButton) {
            String username = this.usernameTextField.getText();
            String password = this.passwordTextField.getText();
            boolean isArtist = isArtistCheckBox.isSelected();

            // I DO NOT KNOW HOW THE USE CASE FOR LOGIN WORKS BUT THIS IS HOW WE SHOULD OPEN THE NEW WINDOWS

            if (isArtist) {                                       // should be: if (isArist && Use Case is successful)

                this.jframe.dispose();
                //artistView artistDashboard = new artistView();    // should need an artist parameter

            } else {                                              // should be: else if (isUser && Use Case is successful)

                this.jframe.dispose();
                // playlistView userDashboard = new playlistView(); <- needs a user parameter, then uncomment

            }

            // The else branch should actually be: isNotSuccessful for either use case and you can prompt them to re-enter information
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
        this.submitButton.setBounds(100, 400, 100, 50);  // fix up the bounds
        this.submitButton.setText("Submit");
        this.submitButton.setFocusable(false);
        this.submitButton.setHorizontalTextPosition(JButton.CENTER);
        this.submitButton.setForeground(Color.cyan);
        this.submitButton.setBackground(Color.lightGray);

        this.isArtistCheckBox = new JCheckBox();
        this.isArtistCheckBox.setBounds(200, 200, 100, 50);
        this.isArtistCheckBox.setText("I am an Artist");
        this.isArtistCheckBox.setFocusable(false);

        this.usernameTextField = new JTextField();
        this.usernameTextField.setBounds(300, 300, 150,75);
        this.usernameTextField.setText("Username");

        this.passwordTextField = new JTextField();
        this.passwordTextField.setBounds(300, 400, 150, 75);
        this.passwordTextField.setText("Password");


        this.submitButton.addActionListener(this);
        this.isArtistCheckBox.addActionListener(this);
    }


    private void initializeFrame() {
        this.jframe.add(this.submitButton);
        this.jframe.add(this.isArtistCheckBox);
        this.jframe.add(this.usernameTextField);
        this.jframe.add(this.passwordTextField);
        this.jframe.setVisible(true);
    }
}