package View;

import Entities.RegularUser;
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
    private final int FONTSIZE = 10;
    private final int WIDTH = 640;
    private final int HEIGHT = 640;
    private InMemoryUser user;
    private JFrame jframe;
    private JPanel panel;
    private JButton spaceButton;
    private JButton searchButton;
    private JLabel title;
    private Font font;
    private boolean spacePlaying;
    private JTextField searchBar;
    private musicEngineControllerViewModel musicEngineControllerViewModel;
    private searchViewModel searchViewModel;
    private PlaylistPanelView playlistPanel;
    private PlayBar playBar;
    private InMemorySpace space;

    /**
     * constructor
     * @param user takes in the user's data to display their own dashboard!
     */
    public playlistView(InMemoryUser user){
        this.initializeValues(user);
        this.initializeComponents();            // set up space button

        // set up actual playlists
        // The playlists will need to be under a Scrollable JPanel - ask Rohan if you have questions,
        // only needs a basic for look in action listener to print out the song data
        // TODO -- note: when starting to play a playlist, please update the spaceButtonText if it was being played


        // *IMPORTANT* WE HAVE DECIDED TO HAVE SEARCH BE ITS OWN PAGE LIKE IN SPOTIFY FOR SWING REASONS - TALK TO ROHAN OR CHRISTINA IF YOU HAVE QUESTIONS
        // SETUP SEARCH FOR SONG BUTTON - TAKES YOU TO searchOutputView.java
        // TODO


        // set up play bar - Raf this playbar needs to be consistent even if we open the search page and
        // go back to this page idk how to keep that consistent? Maybe just copy-paste theplaybar code along with
        // whatever song is playing
        // TODO

        // set screen visible
        this.initializeFrame();

    }

    public playlistView(InMemoryUser user, InMemorySpace space){
        this.initializeValues(user, space);
        this.initializeComponents();            // set up space button

        // set up actual playlists
        // The playlists will need to be under a Scrollable JPanel - ask Rohan if you have questions,
        // only needs a basic for look in action listener to print out the song data
        // TODO -- note: when starting to play a playlist, please update the spaceButtonText if it was being played


        // *IMPORTANT* WE HAVE DECIDED TO HAVE SEARCH BE ITS OWN PAGE LIKE IN SPOTIFY FOR SWING REASONS - TALK TO ROHAN OR CHRISTINA IF YOU HAVE QUESTIONS
        // SETUP SEARCH FOR SONG BUTTON - TAKES YOU TO searchOutputView.java
        // TODO


        // set up play bar - Raf this playbar needs to be consistent even if we open the search page and
        // go back to this page idk how to keep that consistent? Maybe just copy-paste theplaybar code along with
        // whatever song is playing
        // TODO

        // set screen visible
        this.initializeFrame();

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
            System.out.println(searchText);
            this.jframe.dispose();
            new searchOutputView(searchText, this.user, this.space);
        }
        // TODO -- NOTE: add your action commands as an else-if to this if statement
    }

    private void initializeValues(InMemoryUser user){
        this.user = user;

        this.jframe = new JFrame(this.user.getUsername() + "'s Dashboard");
        this.jframe.setSize(this.WIDTH, this.HEIGHT);
        this.jframe.setResizable(false);
        this.jframe.getContentPane().setBackground(new Color(156, 219, 250));
        this.jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.musicEngineControllerViewModel = new musicEngineControllerViewModel(new InMemoryPlaylist());
        this.space = new InMemorySpace(this.musicEngineControllerViewModel);   // initialize empty space
        this.spacePlaying = false;

        this.searchViewModel = new searchViewModel();
    }

    private void initializeValues(InMemoryUser user, InMemorySpace space){
        this.user = user;

        this.jframe = new JFrame(this.user.getUsername() + "'s Dashboard");
        this.jframe.setSize(this.WIDTH, this.HEIGHT);
        this.jframe.setResizable(false);
        this.jframe.getContentPane().setBackground(new Color(156, 219, 250));
        this.jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.musicEngineControllerViewModel = new musicEngineControllerViewModel(new InMemoryPlaylist());
        this.space = space;   // initialize empty space
        this.spacePlaying = false;

        this.searchViewModel = new searchViewModel();
    }

    private void initializeComponents() {
        this.title = new JLabel(this.user.getUsername() + " Dashboard");
        this.font = new Font(title.getFont().getName(), Font.PLAIN, this.FONTSIZE);

        this.setSpaceButton();
        this.setUpSearchButton();

        this.playlistPanel = new PlaylistPanelView(this.user, musicEngineControllerViewModel);
        this.playBar = new PlayBar(musicEngineControllerViewModel, musicEngineControllerViewModel.getSync());

        this.setUpSearchBar();

        // Set up panel
        // TODO: determine whether this should go in a helper function or not (i.e. how many panels do we want?)
        this.panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 10, 10);  // TODO - *Update*: For layout ask Rohan or Christina do not make a panel take up the entire screen size, these are just test dimensions to edit afterwards
        panel.setBackground(new Color(156, 219, 250));

        this.spaceButton.addActionListener(this);
        this.searchButton.addActionListener(this);
    }

    public void setUpSearchBar(){
        this.searchBar = new JTextField();
        this.searchBar.setBounds(20, 30, 300, 55);
        this.searchBar.setFont(font);
    }

    private void initializeFrame() {
        this.panel.add(title);
        this.panel.add(this.spaceButton);
        this.panel.add(this.searchBar);
        this.panel.add(this.playlistPanel.getPane());
        this.panel.add(this.playBar.getPanel());

        this.panel.add(searchButton);
        this.jframe.add(panel);
        this.jframe.setVisible(true);
    }

    public void setUpSearchButton(){
        this.searchButton = new JButton("Seach for a song");
        this.searchButton.setBounds(325,30, 135,55);
        this.searchButton.setFocusable(false);
        this.searchButton.setHorizontalTextPosition(JButton.CENTER);
        this.searchButton.setBackground(Color.white);
        this.searchButton.setFont(font);

    }

    private void setSpaceButton(){
        this.spaceButton = new JButton("Listen to space!");
        this.spaceButton.setBounds(475,30, 150,55);
        this.spaceButton.setFocusable(false);
        this.spaceButton.setHorizontalTextPosition(JButton.CENTER);
        this.spaceButton.setBackground(Color.white);
        this.spaceButton.setFont(font);
    }

    public String callAddToSpace(int id){   // this is for communication between views
        return this.musicEngineControllerViewModel.callAddToSpace(id);
    }
}
