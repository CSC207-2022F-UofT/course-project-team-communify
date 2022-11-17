package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class artistView extends JFrame implements ActionListener {

    private final int FONTSIZE = 10;
    private final int WIDTH = 640;
    private final int HEIGHT = 640;
    private JFrame jframe;
    private JButton uploadButton;


    public artistView() {
        this.initializeValues();
        this.initializeComponents();
        this.initializeFrame();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // if (e.getSource() == this.uploadButton) {}
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
        //this.uploadButton = new JButton();

        //this.uploadButton.addActionListener(this);
    }


    private void initializeFrame() {
        // this.jframe.add(uploadButton);
        this.jframe.setVisible(true);
    }

}
