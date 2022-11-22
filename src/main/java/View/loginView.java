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
/**
 * Creates the login view.
 */
public class loginView extends JFrame implements ActionListener {
    private userViewModel viewModel;
    private boolean register;
    private JFrame jframe;
    private JButton submitButton;
    private JCheckBox isArtistCheckBox;
    private JTextField usernameTextField;
    private JTextField passwordTextField;
    private ImageIcon icon;
    private ImageIcon logoImg;
    private JTextField artistTextField;


    /**
     * @param icon the program icon
     * @param logoImg the program logo
     * @param register true if this window is for registering (vs. logging in)
     */
    public loginView(ImageIcon icon, ImageIcon logoImg, boolean register) {
        this.icon = icon;
        this.logoImg = logoImg;
        this.register = register;
        this.initializeValues();
        this.initializeComponents();
        this.initializeFrame();
    }

    /**
     * Handles login button events.
     * @param e the button press event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String username = "", password = "", artistName = "";
        InMemoryUser user;
        InMemoryArtistUser artist;
        boolean isArtist = isArtistCheckBox.isSelected();

        if (e.getSource() != this.isArtistCheckBox){
            username = this.usernameTextField.getText();
            password = this.passwordTextField.getText();
            artistName = this.artistTextField.getText();

            if (isArtist){
                this.viewModel = new userViewModel(new InMemoryArtistUser("", ""));
            }
            else {
                this.viewModel = new userViewModel(new InMemoryUser());
            }
        }

        if (e.getSource() == this.submitButton & !register) {
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
        }
        else if (e.getSource() == this.submitButton & register){
            if (viewModel.registerAction(username, password, isArtist, artistName)){
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
                JOptionPane.showMessageDialog(this.jframe, "Sorry, that username is taken or password is empty.");
            }
        }
        else if (e.getSource() == this.isArtistCheckBox & register){
            this.artistTextField.setVisible(isArtist);
        }
    }

    /**
     * Initializes the values of the main Swing and logic objects.
     */
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

    /**
     * Initializes Swing related components.
     */
    private void initializeComponents() {

        this.submitButton = new JButton();
        this.submitButton.setBounds(100, 400, 100, 50);  // fix up the bounds
        if (!this.register)
            this.submitButton.setText("Login");
        else
            this.submitButton.setText("Register");
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

        this.artistTextField = new JTextField();
        this.artistTextField.setBounds(300, 500, 150,75);
        this.artistTextField.setText("Artist Name");
        this.artistTextField.setVisible(false);


        this.submitButton.addActionListener(this);
        this.isArtistCheckBox.addActionListener(this);
    }

    /**
     * Initializes the main window frame and adds components.
     */
    private void initializeFrame() {
        this.jframe.add(this.submitButton);
        this.jframe.add(this.isArtistCheckBox);
        this.jframe.add(this.usernameTextField);
        this.jframe.add(this.passwordTextField);
        this.jframe.add(this.artistTextField);
        this.jframe.setVisible(true);
    }
}