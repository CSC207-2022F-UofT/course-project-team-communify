package view;

import viewModel.PlaylistDsView;
import viewModel.SearchViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * view for the user dashboard
 */
public class PlaylistView extends JFrame implements ActionListener {

    private static final ImageIcon SEARCH = new ImageIcon("src/main/java/View/assets/button/search.png");
    private static final ImageIcon SPACE = new ImageIcon("src/main/java/View/assets/button/space.png");
    private static final ImageIcon ADD_TO = new ImageIcon("src/main/java/View/assets/button/add_to.png");
    private final int WIDTH = 1280;
    private final int HEIGHT = 640;
    private InMemoryUser user;
    private JFrame jframe;
    private JPanel panel;
    private JButton spaceButton;
    private JButton searchButton;
    private JButton newPlaylistButton;
    private JLabel title;
    private JTextField searchBar;
    private viewModel.MusicEngineViewModel musicEngineViewModel;
    private SearchViewModel searchViewModel;
    private PlaylistPanelView playlistPanel;
    private PlayBar playBar;

    private final ImageIcon icon;
    private final ImageIcon logoImg;
    private final ImageIcon logoSmall;
    private JLabel logo;

    private final int DEFAULT_WIDTH = 40;
    private final int DEFAULT_HEIGHT = 40;
    private final int DEFAULT_KERNING = 20;


    /**
     * constructor
     * @param user takes in the user's data to display their own dashboard!
     * @param icon the icon
     * @param logoImg the logo image object
     */
    public PlaylistView(InMemoryUser user, ImageIcon icon, ImageIcon logoImg){
        this.icon = icon;
        this.logoImg = logoImg;
        this.logoSmall = new ImageIcon(logoImg.getImage().getScaledInstance((int)(logoImg.getIconWidth()*0.7), (int)(logoImg.getIconHeight()*0.7), Image.SCALE_SMOOTH));
        this.initializeValues(user);
        this.initializeComponents();            // set up space button

        // set screen visible
        this.initializeFrame();

    }

    /**
     * @param user the user logged in
     * @param vm old view model
     * @param pb the current play bar
     * @param icon the icon
     * @param logoImg the logo image object
     */
    public PlaylistView(InMemoryUser user, viewModel.MusicEngineViewModel vm, PlayBar pb, ImageIcon icon, ImageIcon logoImg) {
        this.icon = icon;
        this.logoImg = logoImg;
        this.logoSmall = new ImageIcon(logoImg.getImage().getScaledInstance((int)(logoImg.getIconWidth()*0.7), (int)(logoImg.getIconHeight()*0.7), Image.SCALE_SMOOTH));
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
            if (this.musicEngineViewModel.getMediaType() != 2){
                this.musicEngineViewModel.callPlaySpace();
            }
            else{
                this.createSpacePopup();
            }
        } else if(e.getSource() == this.searchButton){
            String searchText = this.searchBar.getText();
            this.searchViewModel.search(searchText);
            this.jframe.dispose();
            new SearchOutputView(searchText, this.user, this.musicEngineViewModel, this.playBar, icon, logoImg,this);
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
        this.jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.musicEngineViewModel = new viewModel.MusicEngineViewModel(new InMemoryPlaylist());
        this.playBar = new PlayBar(musicEngineViewModel, musicEngineViewModel.getSync());

        this.searchViewModel = new SearchViewModel(new InMemoryUser());
    }

    /**
     * @param user the logged-in user
     * @param vm the old view model
     * @param pb the current play bar
     */
    private void initializeValues(InMemoryUser user, viewModel.MusicEngineViewModel vm, PlayBar pb){
        this.user = user;

        this.jframe = new JFrame(this.user.getUsername() + "'s Dashboard");
        this.jframe.setSize(this.WIDTH, this.HEIGHT);
        this.jframe.setResizable(false);
        this.jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.jframe.setIconImage(this.icon.getImage());

        this.musicEngineViewModel = vm;
        this.playBar = pb;
        this.playBar.update();

        this.searchViewModel = new SearchViewModel(new InMemoryUser());
    }

    /**
     * Initializes Swing related components.
     */
    private void initializeComponents() {

        this.jframe.setIconImage(icon.getImage());
        this.title = new JLabel(this.user.getUsername() + " Dashboard");

        // TOP BAR
        this.logo = new JLabel(logoSmall);
        this.logo.setBounds(DEFAULT_KERNING,
                DEFAULT_KERNING, logoSmall.getIconWidth(), logoSmall.getIconHeight());

        this.setUpSearchBar();
        this.setUpSearchButton();
        this.setSpaceButton();
        this.setUpPlaylistButton();

        // MIDDLE BAR
        this.playlistPanel = new PlaylistPanelView(this.user, musicEngineViewModel, this);

        // Set up panel
        this.panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 10, 10);

        this.searchButton.addActionListener(this);
        this.spaceButton.addActionListener(this);
        this.newPlaylistButton.addActionListener(this);
    }

    /**
     * Creates the search bar elements
     */
    public void setUpSearchBar(){
        this.searchBar = new JTextField();
        this.searchBar.setBounds(this.logoSmall.getIconWidth() + DEFAULT_KERNING * 2, DEFAULT_KERNING * 2,
                this.jframe.getWidth() - logo.getWidth() - DEFAULT_WIDTH * 3 - DEFAULT_KERNING * 4, DEFAULT_HEIGHT);
    }

    /**
     * Initializes the main window frame and adds components.
     */
    private void initializeFrame() {

        this.jframe.setLocationRelativeTo(null);

        this.jframe.add(this.logo);
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
        this.searchButton = new JButton(SEARCH);
        this.searchButton.setOpaque(false);
        this.searchButton.setBorderPainted(false);
        this.searchButton.setContentAreaFilled(false);

        this.searchButton.setBounds(this.logoSmall.getIconWidth() + this.searchBar.getWidth() + DEFAULT_KERNING * 2,
                DEFAULT_KERNING * 2, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        this.searchButton.setFocusable(false);
        this.searchButton.setHorizontalTextPosition(JButton.CENTER);

    }

    /**
     * Sets up the space button elements.
     */
    private void setSpaceButton(){
        this.spaceButton = new JButton(SPACE);
        this.spaceButton.setOpaque(false);
        this.spaceButton.setBorderPainted(false);
        this.spaceButton.setContentAreaFilled(false);
        this.spaceButton.setBounds(this.logoSmall.getIconWidth() + this.searchBar.getWidth() + this.searchButton.getWidth() + DEFAULT_KERNING * 2,
                DEFAULT_KERNING * 2, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        this.spaceButton.setFocusable(false);
        this.spaceButton.setHorizontalTextPosition(JButton.CENTER);
    }

    /**
     * Sets up the playlist button elements.
     */
    private void setUpPlaylistButton(){
        this.newPlaylistButton =  new JButton(ADD_TO);
        this.newPlaylistButton.setOpaque(false);
        this.newPlaylistButton.setBorderPainted(false);
        this.newPlaylistButton.setContentAreaFilled(false);
        this.newPlaylistButton.setBounds(this.logoSmall.getIconWidth() + this.searchBar.getWidth() + this.searchButton.getWidth() + this.spaceButton.getWidth() + DEFAULT_KERNING * 2,
                DEFAULT_KERNING * 2, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        this.newPlaylistButton.setFocusable(false);
        this.newPlaylistButton.setHorizontalTextPosition(JButton.CENTER);
        this.newPlaylistButton.setOpaque(true);
    }

    /**
     * @param currPlaylist the new playlist to update the user with
     */
    public void updateUser(PlaylistDsView currPlaylist) {
        InMemoryPlaylist toRemove = null;
        for (InMemoryPlaylist p : this.user.getPlaylists()){
            if (currPlaylist.getId() == p.getId()){
                toRemove = p;
            }
        }

        if (toRemove != null){
            this.user.removePlaylist(toRemove);
            this.user.addPlaylist(currPlaylist, true);
        }
        else {
            this.user.addPlaylist(currPlaylist, false);
        }

        this.panel.remove(this.playlistPanel.getPane());
        this.playlistPanel = new PlaylistPanelView(this.user, musicEngineViewModel, this);
        this.panel.add(this.playlistPanel.getPane());
        this.panel.invalidate();
        this.panel.validate();
        this.panel.repaint();
    }

    /**
     * create the popup for the space to play
     */
    private void createSpacePopup(){
        JOptionPane pane = new JOptionPane(null);
        pane.setMessage("space is already playing!");
        JDialog dialog = pane.createDialog(null, "space is already playing!");
        dialog.setVisible(true);
    }
}
