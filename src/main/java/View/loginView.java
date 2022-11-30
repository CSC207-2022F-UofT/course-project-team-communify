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
    private JButton backButton;
    private JLabel logo;

    private int UI_TOP_LEFT;

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

        if(e.getSource() == this.backButton){
            this.jframe.dispose();
            new launchView(icon, logoImg);
        }

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
            if (username.equals("")){
                JOptionPane.showMessageDialog(this.jframe, "Empty Username. Please enter a username.");
            }
            else if (password.equals("")){
                JOptionPane.showMessageDialog(this.jframe, "Empty Password. Please enter a password.");
            }
            else if (viewModel.loginAction(username, password, isArtist)){
                this.jframe.dispose();
                if (isArtist) {
                    artist = (InMemoryArtistUser) this.viewModel.getCurrentArtistUser();
                    new artistView(this.icon, this.logoImg, artist);

                } else {
                    user = (InMemoryUser) this.viewModel.getCurrentUser();
                    new playlistView(user, icon, logoImg);
                }
            }
            else {
                JOptionPane.showMessageDialog(this.jframe, "Sorry, invalid credentials. Please double-check your password.");
            }
        }
        else if (e.getSource() == this.submitButton & register){
            if (viewModel.registerAction(username, password, isArtist, artistName)){
                this.jframe.dispose();
                this.jframe.dispose();
                if (isArtist) {
                    artist = (InMemoryArtistUser) this.viewModel.getCurrentArtistUser();
                    new artistView(this.icon, this.logoImg, artist);

                } else {
                    user = (InMemoryUser) this.viewModel.getCurrentUser();
                    new playlistView(user, icon, logoImg);
                }
            }
            else {
                JOptionPane.showMessageDialog(this.jframe, "Sorry, that username is taken.");
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
        int WIDTH = 1280;
        this.jframe.setSize(WIDTH, HEIGHT);
        this.jframe.setResizable(false);
        this.jframe.setLayout(null);
        this.jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.jframe.setLocationRelativeTo(null);
    }

    /**
     * Initializes Swing related components.
     */
    private void initializeComponents() {

        int DEFAULT_WIDTH = 280;
        int DEFAULT_HEIGHT = 40;
        int DEFAULT_KERNING = 10;

        this.logo = new JLabel(logoImg);
        this.logo.setBounds((this.jframe.getWidth() - logoImg.getIconWidth())/2, 120, logoImg.getIconWidth(), logoImg.getIconHeight());

        this.artistTextField = new JTextField();
        this.artistTextField.setBounds((this.jframe.getWidth() - DEFAULT_WIDTH)/2, 240, DEFAULT_WIDTH,DEFAULT_HEIGHT);
        this.artistTextField.setText("Artist Name");
        this.artistTextField.setVisible(false);

        this.usernameTextField = new JTextField();
        this.usernameTextField.setBounds((this.jframe.getWidth() - DEFAULT_WIDTH)/2, 290, DEFAULT_WIDTH,DEFAULT_HEIGHT);
        this.usernameTextField.setText("Username");

        this.passwordTextField = new JTextField();
        this.passwordTextField.setBounds((this.jframe.getWidth() - DEFAULT_WIDTH)/2, 340, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        this.passwordTextField.setText("Password");

        this.isArtistCheckBox = new JCheckBox();
        this.isArtistCheckBox.setBounds((this.jframe.getWidth() - DEFAULT_WIDTH)/2, 380, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        this.isArtistCheckBox.setText("I am an Artist");
        this.isArtistCheckBox.setFocusable(false);

        this.submitButton = new JButton();
        this.submitButton.setBounds((this.jframe.getWidth() - DEFAULT_WIDTH)/2, 420, DEFAULT_WIDTH, DEFAULT_HEIGHT);  // fix up the bounds

        if (!this.register) this.submitButton.setText("Login");
        else this.submitButton.setText("Register");

        this.submitButton.setFocusable(false);
        this.submitButton.setHorizontalTextPosition(JButton.CENTER);

        this.backButton = new JButton("Back");
        this.backButton.setBounds((this.jframe.getWidth() - DEFAULT_WIDTH)/2, 460, DEFAULT_WIDTH, DEFAULT_HEIGHT);  // fix up the bounds
        this.backButton.setOpaque(false);
        this.backButton.setContentAreaFilled(false);
        this.backButton.setBorderPainted(false);


        this.submitButton.addActionListener(this);
        this.isArtistCheckBox.addActionListener(this);
        this.backButton.addActionListener(this);
    }

    /**
     * Initializes the main window frame and adds components.
     */
    private void initializeFrame() {
        this.jframe.add(this.logo);
        this.jframe.add(this.submitButton);
        this.jframe.add(this.isArtistCheckBox);
        this.jframe.add(this.usernameTextField);
        this.jframe.add(this.passwordTextField);
        this.jframe.add(this.artistTextField);
        this.jframe.add(this.backButton);
        this.jframe.setVisible(true);
    }
}