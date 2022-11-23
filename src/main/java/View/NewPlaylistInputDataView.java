package View;

import ViewModel.playlistViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewPlaylistInputDataView extends JFrame implements ActionListener {
    private final int WIDTH = 640;
    private final int HEIGHT = 640;
    private InMemoryUser owner;

    private int ID;
    private JFrame jframe;
    private JButton createButton;
    private JButton homeButton;
    private JTextField playlistNameTextField;

    private ViewModel.playlistViewModel viewModel;

    public NewPlaylistInputDataView(InMemoryUser owner, int ID){
        this.initializeValues(owner, ID);
        this.initializeComponents();
        this.initializeFrame();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.createButton) {
            String playlistName = this.playlistNameTextField.getText();
            String outputMessage = this.viewModel.callNewPlaylistUseCase(ID,owner, playlistName);
            this.jframe.dispose();
            new NewPlaylistOutputDataView(this.owner,outputMessage);
        }
        else if (e.getSource() == this.homeButton) {
            this.jframe.dispose();
            // playlistView userDashboard = new playlistView();    enter a User parameter in playlistView() to open new window
            playlistView userDashboard = new playlistView(owner);
        }
    }

    private void initializeValues(InMemoryUser owner, int ID) {
        this.owner = owner;
        this.ID = ID;
        this.jframe = new JFrame("Playlist creation");
        this.jframe.setSize(this.WIDTH, this.HEIGHT);
        this.jframe.setResizable(false);
        this.jframe.getContentPane().setBackground(new Color(185, 226, 246));
        this.jframe.setLayout(null);
        this.jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.jframe.setVisible(true);

        this.viewModel = new playlistViewModel();
        //this.jframe.getContentPane().setBackground(new Color(34, 139, 34));
        // this.spaceViewModel = new spaceViewModel();
    }
    private void initializeComponents() {

        this.playlistNameTextField = new JTextField();
        this.playlistNameTextField.setBounds(this.WIDTH/2, this.HEIGHT/2, 300, 50);

        this.createButton = new JButton();
        this.createButton.setBounds(this.WIDTH/2, (this.HEIGHT/2 )+50, 100, 50);
        this.createButton.setText("Create!");
        this.createButton.setFocusable(false);
        this.createButton.setHorizontalTextPosition(JButton.CENTER);
        this.createButton.setForeground(Color.black);
        this.createButton.setBackground(Color.lightGray);

        this.homeButton = new JButton();
        this.homeButton.setBounds(this.WIDTH/2, (this.HEIGHT/2 )+100, 100, 50);
        this.homeButton.setText("Home");
        this.homeButton.setFocusable(false);
        this.homeButton.setHorizontalTextPosition(JButton.CENTER);
        this.homeButton.setForeground(Color.black);
        this.homeButton.setBackground(Color.lightGray);

        this.createButton.addActionListener(this);
        this.homeButton.addActionListener(this);
    }
    private void initializeFrame() {
        this.jframe.add(createButton);
        this.jframe.add(playlistNameTextField);
        this.jframe.add(homeButton);
        this.jframe.setVisible(true);
    }
}