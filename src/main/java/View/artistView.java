package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class artistView extends JFrame implements ActionListener {

    private final int FONTSIZE = 10;
    private final int WIDTH = 640;
    private final int HEIGHT = 640;
    private JFrame jframe;
    private JButton uploadButton;
    private JButton deleteButton;
    // private JTable ...;
    // private JLabel ...;


    public artistView() {
        this.initializeValues();
        this.initializeComponents();
        this.initializeFrame();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.uploadButton) {

            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showOpenDialog(null);

            if (response == JFileChooser.APPROVE_OPTION) {

                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                String filePath = String.valueOf(file);                                    // String of the filepath

            }

        } // else if (e.getSource() == this.deleteButton) {}     I do not know how the delete button should work
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
        this.uploadButton = new JButton();
        this.uploadButton.setBounds(200, 300, 100, 50);
        this.uploadButton.setText("Upload");
        this.uploadButton.setFocusable(false);
        this.uploadButton.setHorizontalTextPosition(JButton.CENTER);
        this.uploadButton.setForeground(Color.black);
        this.uploadButton.setBackground(Color.lightGray);

        this.deleteButton = new JButton();
        this.deleteButton.setBounds(50, 300, 100, 50);
        this.deleteButton.setText("Delete");
        this.deleteButton.setFocusable(false);
        this.deleteButton.setHorizontalTextPosition(JButton.CENTER);
        this.deleteButton.setForeground(Color.black);
        this.deleteButton.setBackground(Color.lightGray);

        // Setup JTable
        // ...

        this.uploadButton.addActionListener(this);
        this.deleteButton.addActionListener(this);
    }


    private void initializeFrame() {
        this.jframe.add(uploadButton);
        this.jframe.add(deleteButton);
        this.jframe.setVisible(true);
    }

}
