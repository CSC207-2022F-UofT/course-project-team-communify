package View;

import ViewModel.musicEngineControllerViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Creates the main playlist panel for the view.
 */
public class PlaylistPanelView implements ActionListener {

    private static final ImageIcon PAUSE = new ImageIcon("src/main/java/View/assets/button/pause_small.png");
    private static final ImageIcon REC = new ImageIcon("src/main/java/View/assets/button/rec_small.png");
    private final int WIDTH = 1240;
    private final int HEIGHT = 400;
    private JPanel panel;
    private JScrollPane pane;
    private ArrayList<IDButton> buttons;
    private ArrayList<IDButton> rButtons;
    private musicEngineControllerViewModel viewModel;

    /**
     * @param u the user logged in
     * @param vm the view model with the song data
     */
    public PlaylistPanelView(InMemoryUser u, musicEngineControllerViewModel vm){
        initializeComponents(u.getPlaylists(), vm);
    }

    /**
     * @param playlistList the playlists owned by the user
     * @param vm the view model with the song data
     */
    private void initializeComponents(ArrayList<InMemoryPlaylist> playlistList, musicEngineControllerViewModel vm) {

        Dimension DEFAULT_DIMENSION = new Dimension(50,50);
        int DEFAULT_WIDTH = 130;
        int DEFAULT_HEIGHT = 40;
        int DEFAULT_KERNING = 20;


        this.viewModel = vm;
        this.panel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(this.panel, BoxLayout.Y_AXIS);
        this.panel.setLayout(boxLayout);
        panel.setBounds(0, 0, WIDTH, HEIGHT);
        this.pane = new JScrollPane(panel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        pane.setBounds(15, 110, WIDTH, HEIGHT);

        this.buttons = new ArrayList<>();
        this.rButtons = new ArrayList<>();
        for (InMemoryPlaylist p : playlistList){
            JPanel mainPanel = new JPanel();
            BoxLayout playlistLayout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
            mainPanel.setLayout(playlistLayout);

            JPanel namePanel = new JPanel();
            FlowLayout nameLayout = new FlowLayout(FlowLayout.LEFT, 20, 0);
            namePanel.setLayout(nameLayout);

            JLabel name = new JLabel(p.getName());
            name.setFont(UIManager.getFont( "h2.font" ));
            name.setPreferredSize(new Dimension(640, 100));

            IDButton button = new IDButton(p.getId());
            IDButton recommend = new IDButton(p.getId());
            button.addActionListener(this);
            recommend.addActionListener(this);

            button.setIcon(PAUSE);
            button.setPreferredSize(DEFAULT_DIMENSION);

            recommend.setIcon(REC);
            recommend.setPreferredSize(DEFAULT_DIMENSION);

            namePanel.add(name);
            namePanel.add(button);
            namePanel.add(recommend);
            this.buttons.add(button);
            this.rButtons.add(recommend);
            mainPanel.add(namePanel);

            JPanel songPanel = new JPanel();
            GridLayout songLayout = new GridLayout(p.getSongs().size(), 4);
            songLayout.setVgap(DEFAULT_KERNING);
            songLayout.setHgap(DEFAULT_KERNING);
            songPanel.setLayout(songLayout);
            for (InMemorySong s : p.getSongs()){
                JPanel thisSongPanel = new JPanel();
                FlowLayout thisSongLayout = new FlowLayout(FlowLayout.LEFT, DEFAULT_KERNING, 0);
                thisSongPanel.setLayout(thisSongLayout);
                JLabel cover = new JLabel(new ImageIcon(s.getCover().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
                JLabel songName = new JLabel(s.getName());
                JLabel artists = new JLabel(String.join(", ", s.getArtists()));
                JLabel genre = new JLabel(s.getGenre());
                thisSongPanel.add(cover);
                thisSongPanel.add(songName);

                songPanel.add(thisSongPanel);
                songPanel.add(artists);
                songPanel.add(genre);
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
        if (buttons.contains((IDButton) actionEvent.getSource())){
            int id = buttons.indexOf((IDButton) actionEvent.getSource());
            viewModel.playPlaylistAction(buttons.get(id).getId());
        }
        else if (rButtons.contains((IDButton) actionEvent.getSource())){
            int id = rButtons.indexOf((IDButton) actionEvent.getSource());
            viewModel.getRecommendationAction(rButtons.get(id).getId());
        }
    }
}
