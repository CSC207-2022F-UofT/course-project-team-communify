package View;

import Entities.Song;
import ViewModel.playlistViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * view for making a new playlist
 */
public class NewPlaylistInputDataView extends JFrame implements ActionListener {
    private final int WIDTH = 640;
    private final int HEIGHT = 640;
    private InMemoryUser owner;
    private JFrame jframe;
    private JButton createButton;
    private JButton homeButton;
    private JTextField playlistNameTextField;
    private playlistView mainWindow;
    private playlistViewModel viewModel;

    private Song song;

    /**
     * @param owner the owner of the playlist
     * @param playlistView the main window view
     */
    public NewPlaylistInputDataView(InMemoryUser owner, playlistView playlistView){
        this.mainWindow = playlistView;
        this.initializeValues(owner);
        this.initializeComponents();
        this.initializeFrame();
        this.song = null;
    }

    public NewPlaylistInputDataView(InMemoryUser owner, playlistView playlistView, Song song){
        this.mainWindow = playlistView;
        this.song = song;
        this.initializeValues(owner);
        this.initializeComponents();
        this.initializeFrame();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.createButton) {
            String playlistName = this.playlistNameTextField.getText();
            String outputMessage;
            if (song == null) {
                outputMessage = this.viewModel.callNewPlaylistUseCase(owner, playlistName);
            }
            else{
                outputMessage = this.viewModel.callNewPlaylistUseCase(owner, playlistName, song);
            }
            mainWindow.updateUser(this.viewModel.getCurrPlaylist());
            this.jframe.dispose();
            new NewPlaylistOutputDataView(outputMessage);
        }
        else if (e.getSource() == this.homeButton) {
            this.jframe.dispose();
        }
    }

    /**
     * @param owner the owner of the playlist
     */
    private void initializeValues(InMemoryUser owner) {
        this.owner = owner;
        this.jframe = new JFrame("Playlist creation");
        this.jframe.setSize(this.WIDTH, this.HEIGHT);
        this.jframe.setResizable(false);
        this.jframe.getContentPane().setBackground(new Color(185, 226, 246));
        this.jframe.setLayout(null);
        this.jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.jframe.setVisible(true);

        this.viewModel = new playlistViewModel();
    }

    /**
     * Initializes Swing components.
     */
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

    /**
     * Initializes main window
     */
    private void initializeFrame() {
        this.jframe.add(createButton);
        this.jframe.add(playlistNameTextField);
        this.jframe.add(homeButton);
        this.jframe.setVisible(true);
    }
}
