// **IMPORTANT, READ ME!**
// Strictly here to direct the user to either the artist login page or user login page
// THIS CAN BE CHANGED TO YOUR LIKING BUT I WILL MAKE A BOOLEAN PARAMETER FOR IS_USER
// IF IT IS_ARTIST THEN THE LOGIN INFO IS SENT TO THE ARTIST CREATION USE CASE
// IF IT IS NOT IS_ARTIST THEN THE LOGIN INFO IS SENT TO THE USER CREATION USE CASE

package View;

import ViewModel.userViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginView extends JFrame implements ActionListener {
    private userViewModel viewModel;
    private JFrame jframe;
    private JButton submitButton;
    private JCheckBox isArtistCheckBox;
    private JTextField usernameTextField;
    private JTextField passwordTextField;
    private ImageIcon icon;
    private ImageIcon logoImg;
    private JButton registerButton;


    public loginView(ImageIcon icon, ImageIcon logoImg) {
        this.icon = icon;
        this.logoImg = logoImg;
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
            InMemoryUser user;
            InMemoryArtistUser artist;

            if (isArtist){
                this.viewModel = new userViewModel(new InMemoryArtistUser("", ""));
            }
            else {
                this.viewModel = new userViewModel(new InMemoryUser());
            }

            if (viewModel.loginAction(username, password, isArtist)){
                this.jframe.dispose();
                if (isArtist) {
                    artist = (InMemoryArtistUser) this.viewModel.getCurrentArtistUser();
                    new artistView(this.icon, this.logoImg, artist);

                } else {

                    user = (InMemoryUser) this.viewModel.getCurrentUser();
                    new playlistView(user);
                }
            }
            else {
                JOptionPane.showMessageDialog(this.jframe, "Sorry, your password was incorrect. Please double-check your password.");
            }



            // The else branch should actually be: isNotSuccessful for either use case and you can prompt them to re-enter information
        }
    }


    private void initializeValues() {
        this.jframe = new JFrame();
        int HEIGHT = 640;
        int WIDTH = 640;
        this.jframe.setSize(WIDTH, HEIGHT);
        this.jframe.setResizable(false);
        this.jframe.getContentPane().setBackground(new Color(185, 226, 246));
        this.jframe.setLayout(null);
        this.jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.jframe.setLocationRelativeTo(null);
    }


    private void initializeComponents() {

        this.submitButton = new JButton();
        this.submitButton.setBounds(100, 400, 100, 50);  // fix up the bounds
        this.submitButton.setText("Login");
        this.submitButton.setFocusable(false);
        this.submitButton.setHorizontalTextPosition(JButton.CENTER);
        this.submitButton.setForeground(Color.cyan);
        this.submitButton.setBackground(Color.lightGray);
        this.registerButton = new JButton();
        this.registerButton.setBounds(100, 500, 100, 50);  // fix up the bounds
        this.registerButton.setText("Register");
        this.registerButton.setFocusable(false);
        this.registerButton.setHorizontalTextPosition(JButton.CENTER);
        this.registerButton.setForeground(Color.cyan);
        this.registerButton.setBackground(Color.lightGray);

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
        this.registerButton.addActionListener(this);
    }


    private void initializeFrame() {
        this.jframe.add(this.submitButton);
        this.jframe.add(this.registerButton);
        this.jframe.add(this.isArtistCheckBox);
        this.jframe.add(this.usernameTextField);
        this.jframe.add(this.passwordTextField);
        this.jframe.setVisible(true);
    }
}