package View;

import Entities.User;
import ViewModel.musicEngineControllerViewModel;
import ViewModel.spaceViewModel;

import javax.swing.*;
import java.awt.*;

/**
 * view for the user dashboard
 */
public class playlistView extends JFrame {
    private final User user;
    private JFrame jframe;
    private JPanel panel;
    private JButton spaceButton;
    private JLabel title;
    private Font font;
    private int fontSize = 10;
    private int width = 640;
    private int height = 640;
    private boolean spacePlaying;

    private final spaceViewModel spaceViewModel;

    private final musicEngineControllerViewModel playerViewModel;
    private IDButton playlistButton;

    /**
     * constructor
     * @param user takes in the user's data to display their own dashboard!
     */
    public playlistView(User user){
        // initialize
        this.user = user;
        this.jframe = new JFrame(this.user.getUsername() + " Dashboard");
        this.panel = new JPanel();
        this.spaceButton = new JButton("Listen to space!");
        this.title = new JLabel(this.user.getUsername() + " Dashboard");
        this.font = new Font(title.getFont().getName(), Font.PLAIN, this.fontSize);
        this.spaceViewModel = new spaceViewModel();
        this.spacePlaying = false;

        // set up panel
        panel.setLayout(null);
        panel.setBounds(0,0, this.width, this.height);  // TODO: probably want this to be larger
        panel.setBackground(Color.BLUE);

        // set up space button
        this.spaceButton.setBounds(350,30, 150,55);
        this.spaceButton.setBackground(Color.GREEN);  // TODO:
        this.spaceButton.setOpaque(true);
        this.spaceButton.setFont(font);
        this.spaceButton.addActionListener(e -> {
            if (!this.spacePlaying){   // clicking on button when space is playing does nothing
                // this.spaceViewModel.callPlaySpace();
                this.spaceButton.setText(this.spaceViewModel.updateSpaceButton());
                // TODO: update playbar
            }
        });

        // set up actual playlists
        // TODO

        // set up search bar
        // TODO

        // set up play bar
        // TODO
        this.playlistButton = new IDButton(-1, "test playlist playing");
        this.playlistButton.setBounds(350, 350, 150, 55);
        this.playlistButton.setBackground(Color.GREEN);  // TODO:
        this.playlistButton.setOpaque(true);
        this.playlistButton.setFont(font);
        this.playerViewModel = new musicEngineControllerViewModel();
        this.playlistButton.addActionListener(e -> {
            String result = playerViewModel.playPlaylistAction(playlistButton.getId());
            playlistButton.setText(result);
            // TODO: add some way of syncing for a thread to update the text
        });

        // set visible
        this.jframe.setSize(this.width, this.height);
        this.jframe.setResizable(false);
        this.panel.add(title);
        this.panel.add(this.spaceButton);
        this.panel.add(this.playlistButton);
        this.jframe.add(panel);
        this.jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.jframe.setVisible(true);

    }

}
