package View;

import Entities.User;
import ViewModel.musicEngineControllerViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * View for the user dashboard
 */
public class playlistView extends JFrame implements ActionListener {

    private final int FONTSIZE = 10;
    private final int WIDTH = 640;
    private final int HEIGHT = 640;
    private User user;
    private JFrame jframe;
    private JPanel panel;
    private JButton spaceButton;
    private JLabel title;
    private Font font;
    private boolean spacePlaying;
    private ViewModel.musicEngineControllerViewModel musicEngineControllerViewModel;

    /**
     * constructor
     * @param user takes in the user's data to display their own dashboard!
     */
    public playlistView(User user){

        this.initializeValues(user);
        this.initializeComponents();            // set up space button

        // set up actual playlists
        // TODO -- note: when starting to play a playlist, please update the spaceButtonText if it was being played


        // set up search bar
        // TODO


        // set up play bar
        // TODO

        this.initializeFrame();
    }


    /**
     * Invoked when an action occurs.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.spaceButton){

            if (!this.spacePlaying) {                          // clicking on button when space is playing does nothing
                String message = this.musicEngineControllerViewModel.callPlaySpace();
                this.spaceButton.setText(message);

            }
        } // TODO -- NOTE: add your action commands as an else-if to this if statement

    }


    private void initializeValues(User user) {

        this.user = user;

        this.jframe = new JFrame(this.user.getUsername() + "'s Dashboard");
        this.jframe.setSize(this.WIDTH, this.HEIGHT);
        this.jframe.setResizable(false);
        this.jframe.getContentPane().setBackground(new Color(185, 226, 246));
        this.jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // set up panel
        // TODO: determine whether this should go in a helper function or not (i.e. how many panels do we want?)
        this.panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 10, 10);  // TODO - *Update*: For layout ask Rohan or Christina do not make a panel take up the entire screen size, these are just test dimensions to edit afterwards
        panel.setBackground(Color.GREEN);

        this.spaceButton = new JButton("Listen to space!");
        this.title = new JLabel(this.user.getUsername() + " Dashboard");
        this.font = new Font(title.getFont().getName(), Font.PLAIN, this.FONTSIZE);

        // this.spaceViewModel = new spaceViewModel();
        this.musicEngineControllerViewModel = new musicEngineControllerViewModel();
        this.spacePlaying = false;

    }


    private void initializeComponents() {
        this.spaceButton.setBounds(350,30, 150,55);
        this.spaceButton.setFocusable(false);
        this.spaceButton.setHorizontalTextPosition(JButton.CENTER);
        this.spaceButton.setBackground(Color.white);
        this.spaceButton.setOpaque(true);
        this.spaceButton.setFont(font);
        this.spaceButton.addActionListener(this);
    }


    private void initializeFrame() {
        this.panel.add(title);
        this.panel.add(this.spaceButton);
        this.jframe.add(panel);
        this.jframe.setVisible(true);
    }
}
