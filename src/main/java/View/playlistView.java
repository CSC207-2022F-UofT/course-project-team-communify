package View;

import Entities.User;
import ViewModel.musicEngineControllerViewModel;
import ViewModel.searchViewModel;

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
    private JTextField searchBar;
    private JButton searchButton;
    private ViewModel.musicEngineControllerViewModel musicEngineControllerViewModel;
    private ViewModel.searchViewModel searchViewModel;

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
        // TODO -- note: when starting to play a playlist, please update the spaceButtonText if it was being played

        // set up search bar
        // TODO
        this.setUpSearchBar();
        this.setUpSearchButton();

        // set up play bar
        // TODO

        // set screen visible
        this.setVisible();

    }

    /**
     * Invoked when an action occurs.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.spaceButton){
            if (!this.spacePlaying){   // clicking on button when space is playing does nothing
                String message = this.musicEngineControllerViewModel.callPlaySpace();
                this.spaceButton.setText(message);
            }
        } else if(e.getSource() == this.searchButton){
            String searchText = this.searchBar.getText();
            this.searchViewModel.search(searchText);
        }
        // TODO -- NOTE: add your action commands as an else-if to this if statement
    }

    private void initializeValues(User user){
        this.user = user;
        this.jframe = new JFrame(this.user.getUsername() + " Dashboard");
        this.panel = new JPanel();
        this.spaceButton = new JButton("Listen to space!");
        this.title = new JLabel(this.user.getUsername() + " Dashboard");
        this.font = new Font(title.getFont().getName(), Font.PLAIN, this.fontSize);
        this.musicEngineControllerViewModel = new musicEngineControllerViewModel();
        this.spacePlaying = false;
        this.searchViewModel = new searchViewModel();

        // set up panel
        // TODO: determine whether this should go in a helper function or not (i.e. how many panels do we want?)
        panel.setLayout(null);
        panel.setBounds(0,0, this.width, this.height);  // TODO: probably want this to be larger
        panel.setBackground(Color.BLUE);
    }

    public void setUpSearchBar(){
        this.searchBar = new JTextField();
        this.searchBar.setBounds(20, 30, 300, 55);
        this.searchBar.setFont(font);
    }

    public void setUpSearchButton(){
        this.searchButton = new JButton("Search");
        this.searchButton.setBounds(325,30, 135,55);
        this.searchButton.setFont(font);
        this.searchButton.addActionListener(this);

    }
    private void setSpaceButton(){
        this.spaceButton.setBounds(475,30, 150,55);
        this.spaceButton.setBackground(Color.GREEN);    // TODO: how to make actually green background
        this.spaceButton.setFont(font);
        this.spaceButton.addActionListener(this);
    }

    private void setVisible(){
        this.jframe.setSize(this.width, this.height);
        this.jframe.setResizable(false);
        this.panel.add(title);
        this.panel.add(this.spaceButton);
        this.panel.add(this.searchBar);
        this.panel.add(this.searchButton);
        this.jframe.add(panel);
        this.jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.jframe.setVisible(true);
    }
}
