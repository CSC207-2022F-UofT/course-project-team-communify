package View;

import Entities.User;
import ViewModel.musicEngineControllerViewModel;
import ViewModel.spaceViewModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * view for the user dashboard
 */
public class playlistView extends JFrame implements ActionListener {
    private User user;
    private JFrame jframe;
    private JPanel panel;
    private JButton spaceButton;
    private JLabel title;
    private Font font;
    private int fontSize = 10;
    private int width = 640;
    private int height = 640;
    private boolean spacePlaying;
    private ViewModel.spaceViewModel spaceViewModel;

    /**
     * constructor
     * @param user takes in the user's data to display their own dashboard!
     */
    public playlistView(User user){
        // initialize values and panels
        this.initializeValues(user);

        // set up space button
        this.setSpaceButton();

        // set up actual playlists
        // TODO

        // set up search bar
        // TODO

        // set up play bar
        // TODO

        // set screen visible
        this.setVisible();

    }

    /**
     * Invoked when an action occurs.
     * NOTE: add your action commands in the outermost if-statement.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.spaceButton){
            if (!this.spacePlaying){   // clicking on button when space is playing does nothing
                this.spaceViewModel.callPlaySpace();
                this.spaceButton.setText(this.spaceViewModel.getSpaceButtonMesssage());
                // TODO: update playbar by calling this.spaceViewModel.getSongPlaying();
            }
        }
    }

    private void initializeValues(User user){
        this.user = user;
        this.jframe = new JFrame(this.user.getUsername() + " Dashboard");
        this.panel = new JPanel();
        this.spaceButton = new JButton("Listen to space!");
        this.title = new JLabel(this.user.getUsername() + " Dashboard");
        this.font = new Font(title.getFont().getName(), Font.PLAIN, this.fontSize);
        this.spaceViewModel = new spaceViewModel();
        this.spacePlaying = false;

        // set up panel
        // TODO: determine whether this should go in a helper function or not (i.e. how many panels do we want?)
        panel.setLayout(null);
        panel.setBounds(0,0, this.width, this.height);  // TODO: probably want this to be larger
        panel.setBackground(Color.BLUE);
    }

    private void setSpaceButton(){
        this.spaceButton.setBounds(350,30, 150,55);
        this.spaceButton.setBackground(Color.GREEN);    // TODO: how to make actually green background
        this.spaceButton.setOpaque(true);
        this.spaceButton.setFont(font);this.spaceButton.addActionListener(this);
    }

    private void setVisible(){
        this.jframe.setSize(this.width, this.height);
        this.jframe.setResizable(false);
        this.panel.add(title);
        this.panel.add(this.spaceButton);
        this.jframe.add(panel);
        this.jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.jframe.setVisible(true);
    }
}
