package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Creates the launch view.
 */
public class launchView extends JFrame implements ActionListener {

    private JButton loginButton;

    private JButton registerButton;
    private final ImageIcon icon;

    private JLabel logo;
    private final ImageIcon logoImg;
    private JFrame jframe;


    /**
     * @param icon the program icon
     * @param logoImg the program logo
     */
    public launchView(ImageIcon icon, ImageIcon logoImg){
        this.icon = icon;
        this.logoImg = logoImg;
        this.initializeValues();
        this.initializeComponents();
        this.initializeFrame();

    }

    /**
     * Handles launch button events.
     * @param e the button press event
     */
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == this.loginButton) {
            this.jframe.dispose();
            new loginView(icon, logoImg, false);
        }
        else if (e.getSource() == this.registerButton){
            this.jframe.dispose();
            new loginView(icon, logoImg, true);
        }
    }

    /**
     * Initializes the values of the main Swing and logic objects.
     */
    private void initializeValues() {

        this.jframe = new JFrame("Communify");
        int WIDTH = 1280;
        int HEIGHT = 640;
        this.jframe.setSize(WIDTH, HEIGHT);
        this.jframe.setLocationRelativeTo(null);

        this.jframe.setLayout(null);
        this.jframe.setResizable(false);
        this.jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.jframe.setIconImage(this.icon.getImage());
    }

    /**
     * Initializes Swing related components.
     */
    private void initializeComponents() {

        this.logo = new JLabel(logoImg);
        this.logo.setBounds((this.jframe.getWidth() - logoImg.getIconWidth())/2, 200, logoImg.getIconWidth(), logoImg.getIconHeight());

        this.registerButton = new JButton();
        this.registerButton.setBounds((this.jframe.getWidth() - 320)/2, 300, 160, 40);
        this.registerButton.setText("Register");
        this.registerButton.setFocusable(false);
        this.registerButton.setHorizontalTextPosition(JButton.CENTER);

        this.loginButton = new JButton();
        this.loginButton.setBounds((this.jframe.getWidth())/2, 300, 160, 40);
        this.loginButton.setText("Login");
        this.loginButton.setFocusable(false);
        this.loginButton.setHorizontalTextPosition(JButton.CENTER);

        this.registerButton.addActionListener(this);
        this.loginButton.addActionListener(this);
    }

    /**
     * Initializes the main window frame and adds components.
     */
    private void initializeFrame() {
        this.jframe.add(this.logo);
        this.jframe.add(this.registerButton);
        this.jframe.add(this.loginButton);
        this.jframe.setVisible(true);
    }
}