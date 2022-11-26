package View;

import ViewModel.PlaylistDsView;
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
    private final int WIDTH = 640;
    private final int HEIGHT = 640;
    private InMemoryUser user;
    private JFrame jframe;
    private JPanel panel;
    private JButton spaceButton;
    private JButton searchButton;
    private JButton newPlaylistButton;
    private JLabel title;
    private Font font;
    private boolean spacePlaying;
    private JTextField searchBar;
    private musicEngineControllerViewModel musicEngineControllerViewModel;
    private searchViewModel searchViewModel;
    private PlaylistPanelView playlistPanel;
    private PlayBar playBar;

    /**
     * constructor
     * @param user takes in the user's data to display their own dashboard!
     */
    public playlistView(InMemoryUser user){
        this.initializeValues(user);
        this.initializeComponents();            // set up space button

        // set screen visible
        this.initializeFrame();

    }

    /**
     * @param user the user logged in
     * @param vm old view model
     * @param pb the current play bar
     */
    public playlistView(InMemoryUser user, musicEngineControllerViewModel vm, PlayBar pb) {
        this.initializeValues(user, vm, pb);
        this.initializeComponents();            // set up space button
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
                this.spaceButton.setEnabled(false);
            }
        } else if(e.getSource() == this.searchButton){
            String searchText = this.searchBar.getText();
            this.searchViewModel.search(searchText);
            System.out.println(searchText);
            this.jframe.dispose();
            new searchOutputView(searchText, this.user, this.musicEngineControllerViewModel, this.playBar);
        }
        else if(e.getSource() == this.newPlaylistButton){
            new NewPlaylistInputDataView(this.user, this);
        }
    }

    /**
     * Initializes the values of the main Swing and logic objects.
     * @param user the logged-in user
     */
    private void initializeValues(InMemoryUser user){
        this.user = user;

        this.jframe = new JFrame(this.user.getUsername() + "'s Dashboard");
        this.jframe.setSize(this.WIDTH, this.HEIGHT);
        this.jframe.setResizable(false);
        this.jframe.getContentPane().setBackground(new Color(156, 219, 250));
        this.jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.musicEngineControllerViewModel = new musicEngineControllerViewModel(new InMemoryPlaylist());
        this.playBar = new PlayBar(musicEngineControllerViewModel, musicEngineControllerViewModel.getSync());
        this.spacePlaying = false;

        this.searchViewModel = new searchViewModel();
    }

    /**
     * @param user the logged-in user
     * @param vm the old view model
     * @param pb the current play bar
     */
    private void initializeValues(InMemoryUser user, musicEngineControllerViewModel vm, PlayBar pb){
        this.user = user;

        this.jframe = new JFrame(this.user.getUsername() + "'s Dashboard");
        this.jframe.setSize(this.WIDTH, this.HEIGHT);
        this.jframe.setResizable(false);
        this.jframe.getContentPane().setBackground(new Color(156, 219, 250));
        this.jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.musicEngineControllerViewModel = vm;
        this.playBar = pb;
        this.playBar.update();
        this.spacePlaying = false;

        this.searchViewModel = new searchViewModel();
    }

    /**
     * Initializes Swing related components.
     */
    private void initializeComponents() {
        this.title = new JLabel(this.user.getUsername() + " Dashboard");
        int FONTSIZE = 10;
        this.font = new Font(title.getFont().getName(), Font.PLAIN, FONTSIZE);

        this.setSpaceButton();
        this.setUpSearchButton();
        this.setUpPlaylistButton();

        this.playlistPanel = new PlaylistPanelView(this.user, musicEngineControllerViewModel);

        this.setUpSearchBar();

        // Set up panel
        this.panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 10, 10);
        panel.setBackground(new Color(156, 219, 250));

        this.spaceButton.addActionListener(this);
        this.searchButton.addActionListener(this);
        this.newPlaylistButton.addActionListener(this);
    }

    /**
     * Creates the search bar elements
     */
    public void setUpSearchBar(){
        this.searchBar = new JTextField();
        this.searchBar.setBounds(20, 30, 230, 55);
        this.searchBar.setFont(font);
    }

    /**
     * Initializes the main window frame and adds components.
     */
    private void initializeFrame() {
        this.panel.add(title);
        this.panel.add(this.spaceButton);
        this.panel.add(this.searchBar);
        this.panel.add(newPlaylistButton);
        this.panel.add(this.playlistPanel.getPane());
        this.panel.add(this.playBar.getPanel());

        this.panel.add(searchButton);
        this.jframe.add(panel);
        this.jframe.setVisible(true);
    }

    /**
     * Sets up the search button elements.
     */
    public void setUpSearchButton(){
        this.searchButton = new JButton("Search");
        this.searchButton.setBounds(260, 30, 100, 55);
        this.searchButton.setFocusable(false);
        this.searchButton.setHorizontalTextPosition(JButton.CENTER);
        this.searchButton.setBackground(Color.white);
        this.searchButton.setFont(font);

    }

    /**
     * Sets up the space button elements.
     */
    private void setSpaceButton(){
        this.spaceButton = new JButton("Listen to space!");
        this.spaceButton.setBounds(370, 30, 100, 55);
        this.spaceButton.setFocusable(false);
        this.spaceButton.setHorizontalTextPosition(JButton.CENTER);
        this.spaceButton.setBackground(Color.white);
        this.spaceButton.setFont(font);
    }

    /**
     * Sets up the playlist button elements.
     */
    private void setUpPlaylistButton(){
        this.newPlaylistButton =  new JButton("Create New Playlist!");
        this.newPlaylistButton.setBounds(480, 30, 140, 55);
        this.newPlaylistButton.setFocusable(false);
        this.newPlaylistButton.setHorizontalTextPosition(JButton.CENTER);
        this.newPlaylistButton.setBackground(Color.white);
        this.newPlaylistButton.setOpaque(true);
        this.newPlaylistButton.setFont(font);
    }

    /**
     * @param currPlaylist the new playlist to update the user with
     */
    public void updateUser(PlaylistDsView currPlaylist) {
        this.user.addPlaylist(currPlaylist);
        this.panel.remove(this.playlistPanel.getPane());
        this.playlistPanel = new PlaylistPanelView(this.user, musicEngineControllerViewModel);
        this.panel.add(this.playlistPanel.getPane());
    }
}
