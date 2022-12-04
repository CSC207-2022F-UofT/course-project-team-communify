package view;

import viewModel.MusicEngineViewModel;
import viewModel.PlaylistViewModel;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Creates the main playlist panel for the view.
 */
public class PlaylistPanelView implements ActionListener {

    private static final ImageIcon NO_SONG_FULL = new ImageIcon("src/main/java/View/assets/no_song.png");
    private static final ImageIcon NO_SONG = new ImageIcon(NO_SONG_FULL.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
    private static final ImageIcon PAUSE = new ImageIcon("src/main/java/View/assets/button/pause_small.png");
    private static final ImageIcon REC = new ImageIcon("src/main/java/View/assets/button/rec_small.png");
    private JPanel panel;
    private JScrollPane pane;
    private ArrayList<IDButton> buttons;
    private ArrayList<IDButton> rButtons;

    private ArrayList<DoubleIDButton> dButtons;
    private MusicEngineViewModel viewModel;

    private final PlaylistViewModel playlistViewModel;

    private final InMemoryUser user;


    /**
     * @param u the user logged in
     * @param vm the view model with the song data
     */
    public PlaylistPanelView(InMemoryUser u, MusicEngineViewModel vm){
        initializeComponents(u.getPlaylists(), vm);
        this.user = u;
        this.playlistViewModel = new PlaylistViewModel();
    }

    /**
     * @param playlistList the playlists owned by the user
     * @param vm the view model with the song data
     */
    private void initializeComponents(ArrayList<InMemoryPlaylist> playlistList, MusicEngineViewModel vm) {

        Dimension DEFAULT_DIMENSION = new Dimension(50,50);

        int DEFAULT_KERNING = 20;


        this.viewModel = vm;
        this.panel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(this.panel, BoxLayout.Y_AXIS);
        this.panel.setLayout(boxLayout);
        int WIDTH = 1240;
        int HEIGHT = 400;
        panel.setBounds(0, 0, WIDTH, HEIGHT);
        this.pane = new JScrollPane(panel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        pane.setBounds(15, 110, WIDTH, HEIGHT);

        this.buttons = new ArrayList<>();
        this.rButtons = new ArrayList<>();
        this.dButtons = new ArrayList<>();
        for (InMemoryPlaylist p : playlistList){

            JPanel mainPanel = new JPanel();
            BoxLayout playlistLayout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
            mainPanel.setLayout(playlistLayout);

            JPanel headerPanel = new JPanel();
            FlowLayout headerLayout = new FlowLayout(FlowLayout.LEFT, DEFAULT_KERNING, DEFAULT_KERNING);
            headerPanel.setLayout(headerLayout);

            JLabel pCover = new JLabel();
            pCover.setIcon(NO_SONG);

            JPanel namePanel = new JPanel();
            GridLayout nameLayout = new GridLayout(2, 1);
            namePanel.setLayout(nameLayout);

            JPanel buttonPanel = new JPanel();
            FlowLayout buttonLayout = new FlowLayout(FlowLayout.LEFT, 0, 0);
            buttonPanel.setLayout(buttonLayout);

            JLabel name = new JLabel(p.getName());
            name.setFont(UIManager.getFont( "h0.font" ));

            IDButton button = new IDButton(p.getId());
            IDButton recommend = new IDButton(p.getId());
            button.addActionListener(this);
            recommend.addActionListener(this);

            buttonPanel.add(button);
            buttonPanel.add(recommend);

            namePanel.add(name);
            namePanel.add(buttonPanel);

            button.setIcon(PAUSE);
            button.setPreferredSize(DEFAULT_DIMENSION);

            recommend.setIcon(REC);
            recommend.setPreferredSize(DEFAULT_DIMENSION);

            headerPanel.add(pCover);
            headerPanel.add(namePanel);

            this.buttons.add(button);
            this.rButtons.add(recommend);
            mainPanel.add(headerPanel);

            JPanel songPanel = new JPanel();
            GridLayout songLayout = new GridLayout(p.getSongs().size(), 4);
            songLayout.setVgap(DEFAULT_KERNING);
            songLayout.setHgap(DEFAULT_KERNING);
            songPanel.setLayout(songLayout);
            for (InMemorySong s : p.getSongs()){
                //S is the song just call the ID

                JPanel thisSongPanel = new JPanel();
                FlowLayout thisSongLayout = new FlowLayout(FlowLayout.LEFT, DEFAULT_KERNING, 0);
                thisSongPanel.setLayout(thisSongLayout);

                BufferedImage rawCover = s.getCover();
                if(pCover.getIcon() == NO_SONG) pCover.setIcon(new ImageIcon(rawCover.getScaledInstance(150, 150, Image.SCALE_DEFAULT)));
                JLabel cover = new JLabel(new ImageIcon(rawCover.getScaledInstance(50, 50, Image.SCALE_DEFAULT)));

                JLabel songName = new JLabel(s.getName());
                JLabel artists = new JLabel(String.join(", ", s.getArtists()));
                JLabel genre = new JLabel(s.getGenre());

                thisSongPanel.add(cover);
                thisSongPanel.add(songName);
                //IDButton removeSong = new IDButton(s.getId(),"Remove Song");
                //new ID button class that stores both a song's ID and its playlist's associated ID
                DoubleIDButton removeSong = new DoubleIDButton(p.getId(),s.getId(),"Remove Song");
                removeSong.addActionListener(this);
                this.dButtons.add(removeSong);

                songPanel.add(thisSongPanel);
                songPanel.add(artists);
                songPanel.add(genre);
                songPanel.add(removeSong);
                //Remove song button
            }
            mainPanel.add(songPanel);
            this.panel.add(mainPanel);
        }
    }

    /**
     * @return the scrollable pane containing playlist view data
     */
    public JScrollPane getPane() {
        return pane;
    }

    /**
     * Handles playlist button events.
     * @param actionEvent the button press event
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (buttons.contains(actionEvent.getSource())){
            int id = buttons.indexOf((IDButton) actionEvent.getSource());
            viewModel.playPlaylistAction(buttons.get(id).getId());
        }
        else if (rButtons.contains(actionEvent.getSource())){
            int id = rButtons.indexOf((IDButton) actionEvent.getSource());
            viewModel.getRecommendationAction(rButtons.get(id).getId());
        }
        if (this.dButtons.contains(actionEvent.getSource())){
            int id= dButtons.indexOf((DoubleIDButton) actionEvent.getSource());
            int songID = dButtons.get(id).getSongID();
            int playlistID = dButtons.get(id).getPlaylistID();
            String output = playlistViewModel.callRemoveSong(user,playlistID,songID);
            this.createPopup(output);
        }
        this.refresh();
    }
    private void createPopup(String text){
        JOptionPane pane = new JOptionPane(null);
        pane.setMessage(text);
        JDialog dialog = pane.createDialog(null, text);
        dialog.setVisible(true);
    }

    public void refresh(){
        this.panel.invalidate();
        this.panel.validate();
        this.panel.repaint();
    }
}