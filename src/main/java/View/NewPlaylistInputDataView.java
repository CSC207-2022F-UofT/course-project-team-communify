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
    private final int HEIGHT = 300;
    private InMemoryUser owner;
    private JFrame jframe;
    private JPanel fieldPanel;
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
        this.jframe = new JFrame("Create Playlist");
        this.jframe.setSize(this.WIDTH, this.HEIGHT);
        this.jframe.setResizable(false);
        this.jframe.setLayout(null);
        this.jframe.setLocationRelativeTo(null);
        this.jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.jframe.setVisible(true);

        this.viewModel = new playlistViewModel();
    }

    /**
     * Initializes Swing components.
     */
    private void initializeComponents() {

        int DEFAULT_WIDTH = 280;
        int DEFAULT_HEIGHT = 120;

        this.fieldPanel = new JPanel();
        this.fieldPanel.setBounds((this.jframe.getWidth() - DEFAULT_WIDTH)/2, (this.jframe.getHeight() - DEFAULT_HEIGHT)/3, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        GridLayout fieldLayout = new GridLayout(2, 1);
        this.fieldPanel.setLayout(fieldLayout);
        fieldLayout.setHgap(20);
        fieldLayout.setVgap(20);


        JPanel buttonPanel = new JPanel();
        GridLayout buttonLayout = new GridLayout(1, 2);
        buttonPanel.setLayout(buttonLayout);
        buttonLayout.setHgap(20);
        buttonLayout.setVgap(20);

        this.playlistNameTextField = new JTextField();
        this.playlistNameTextField.setText("Playlist Name");
        this.playlistNameTextField.setPreferredSize(new Dimension(DEFAULT_WIDTH * 2, DEFAULT_HEIGHT));

        this.createButton = new JButton();
        this.createButton.setText("Create!");
        this.createButton.setHorizontalTextPosition(JButton.CENTER);
        this.createButton.setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));

        this.homeButton = new JButton();
        this.homeButton.setText("Cancel");
        this.homeButton.setHorizontalTextPosition(JButton.CENTER);
        this.homeButton.setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));

        buttonPanel.add(createButton);
        buttonPanel.add(homeButton);

        this.fieldPanel.add(this.playlistNameTextField);
        this.fieldPanel.add(buttonPanel);

        this.createButton.addActionListener(this);
        this.homeButton.addActionListener(this);
    }

    /**
     * Initializes main window
     */
    private void initializeFrame() {
        this.jframe.add(fieldPanel);
        this.jframe.setVisible(true);
    }
}
