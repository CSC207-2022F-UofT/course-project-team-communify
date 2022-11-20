package View;

import Entities.User;
import ViewModel.PlaylistViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewPlaylistInputDataView extends JFrame implements ActionListener {
    private final int FONTSIZE = 10;
    private final int WIDTH = 640;
    private final int HEIGHT = 640;
    private User owner;

    private int ID;
    private JFrame jframe;
    private JButton createButton;
    private JButton homeButton;
    private JTextField playlistNameTextField;

    private PlaylistViewModel viewModel;

    public NewPlaylistInputDataView(User owner, int ID){
        this.initializeValues(owner, ID);
        this.initializeComponents();
        this.initializeFrame();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.createButton) {
            String playlistname = this.playlistNameTextField.getText();
            String outputMessage = this.viewModel.callNewPlaylistUseCase(ID,owner, playlistname);
            this.jframe.dispose();
            new NewPlaylistOutputDataView(this.owner,outputMessage);
        }
        else if (e.getSource() == this.homeButton) {
            this.jframe.dispose();
            // playlistView userDashboard = new playlistView();    enter a User parameter in playlistView() to open new window
            PlaylistView userDashboard = new PlaylistView(owner);
        }
    }

    private void initializeValues(User owner, int ID) {
        this.owner = owner;
        this.ID = ID;
        this.jframe = new JFrame("Playlist creation");
        this.jframe.setSize(this.WIDTH, this.HEIGHT);
        this.jframe.setResizable(false);
        this.jframe.getContentPane().setBackground(new Color(185, 226, 246));
        this.jframe.setLayout(null);
        this.jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.jframe.setVisible(true);

        this.viewModel = new PlaylistViewModel();
        //this.jframe.getContentPane().setBackground(new Color(34, 139, 34));
        // this.spaceViewModel = new spaceViewModel();
    }
    private void initializeComponents() {
        this.playlistNameTextField = new JTextField();
        this.playlistNameTextField.setBounds(this.WIDTH/2-50, this.HEIGHT/2, 300, 50);

        this.createButton = new JButton();
        this.createButton.setBounds(this.WIDTH/2-50, (this.HEIGHT/2 )+50, 100, 50);
        this.createButton.setText("Create!");
        this.createButton.setFocusable(false);
        this.createButton.setHorizontalTextPosition(JButton.CENTER);
        this.createButton.setForeground(Color.black);
        this.createButton.setBackground(Color.lightGray);
        this.createButton.addActionListener(this);

        this.homeButton = new JButton();
        this.homeButton.setBounds(this.WIDTH/2-50, (this.HEIGHT/2 )+100, 100, 50);
        this.homeButton.setText("Return to Dashboard!");
        this.homeButton.setFocusable(false);
        this.homeButton.setHorizontalTextPosition(JButton.CENTER);
        this.homeButton.setForeground(Color.black);
        this.homeButton.setBackground(Color.lightGray);
        this.homeButton.addActionListener(this);
    }
    private void initializeFrame() {
        this.jframe.add(createButton);
        this.jframe.add(playlistNameTextField);
        this.jframe.add(homeButton);
        this.jframe.setVisible(true);
    }
}
