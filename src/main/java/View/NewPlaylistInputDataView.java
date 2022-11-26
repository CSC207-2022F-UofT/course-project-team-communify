package View;

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
    private final int HEIGHT = 320;
    private InMemoryUser owner;
    private JFrame jframe;
    private JPanel fieldPanel;
    private JButton createButton;
    private JButton homeButton;
    private JTextField playlistNameTextField;
    private playlistView mainWindow;
    private playlistViewModel viewModel;

    /**
     * @param owner the owner of the playlist
     * @param playlistView the main window view
     */
    public NewPlaylistInputDataView(InMemoryUser owner, playlistView playlistView){
        this.mainWindow = playlistView;
        this.initializeValues(owner);
        this.initializeComponents();
        this.initializeFrame();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.createButton) {
            String playlistName = this.playlistNameTextField.getText();
            String outputMessage = this.viewModel.callNewPlaylistUseCase(owner, playlistName);
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
        this.jframe = new JFrame("Create a Playlist");
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

        this.fieldPanel = new JPanel();
        this.fieldPanel.setBounds(0, 0, WIDTH, HEIGHT);
        GridLayout fieldLayout = new GridLayout(2, 1);
        this.fieldPanel.setLayout(fieldLayout);

        JPanel buttonPanel = new JPanel();
        GridLayout buttonLayout = new GridLayout(1, 2);
        buttonPanel.setLayout(buttonLayout);

        this.playlistNameTextField = new JTextField();
        this.playlistNameTextField.setText("Playlist Name");

        this.createButton = new JButton();
        this.createButton.setText("Create!");
        this.createButton.setHorizontalTextPosition(JButton.CENTER);

        this.homeButton = new JButton();
        this.homeButton.setText("Cancel");
        this.homeButton.setHorizontalTextPosition(JButton.CENTER);

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
