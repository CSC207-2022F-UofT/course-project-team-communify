package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class launchView extends JFrame implements ActionListener {

    private final int WIDTH = 1280;
    private final int HEIGHT = 640;

    private JButton loginButton;

    private JButton registerButton;
    private final ImageIcon icon;

    private JLabel logo;
    private final ImageIcon logoImg;
    private JFrame jframe;



    public launchView(ImageIcon icon, ImageIcon logoImg){
        this.icon = icon;
        this.logoImg = logoImg;
        this.initializeValues();
        this.initializeComponents();
        this.initializeFrame();

    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == this.loginButton){
            this.jframe.dispose();
            new loginView();
        }

        // else registerView
    }


    private void initializeValues() {

        this.jframe = new JFrame("Communify");
        this.jframe.setSize(this.WIDTH, this.HEIGHT);
        this.jframe.setLocationRelativeTo(null);

        this.jframe.setLayout(null);
        this.jframe.setResizable(false);
        this.jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.jframe.setIconImage(this.icon.getImage());
    }


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


    private void initializeFrame() {
        this.jframe.add(this.logo);
        this.jframe.add(this.registerButton);
        this.jframe.add(this.loginButton);
        this.jframe.setVisible(true);
    }
}