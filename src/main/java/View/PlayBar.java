package View;

import ViewModel.musicEngineControllerViewModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * Creates the play bar for the view.
 */
public class PlayBar implements ActionListener {

    private static final ImageIcon PAUSE = new ImageIcon("src/main/java/View/assets/button/pause.png");
    private static final ImageIcon PLAY = new ImageIcon("src/main/java/View/assets/button/play.png");
    private static final ImageIcon FWD = new ImageIcon("src/main/java/View/assets/button/fwd.png");
    private static final ImageIcon PREV = new ImageIcon("src/main/java/View/assets/button/prev.png");
    private JPanel panel;
    private musicEngineControllerViewModel viewModel;
    private final Object sync;
    private JButton prev;
    private JButton pause;
    private JButton skip;
    private JLabel cover;
    private JLabel song;
    private JLabel artist;

    /**
     * @param vm the view model containing the song data
     * @param sync the object to sync the play bar on
     */
    public PlayBar(musicEngineControllerViewModel vm, Object sync) {
        this.sync = sync;
        initializeComponents(vm);
        waitForSong();
    }

    /**
     * @param vm the view model containing the song data
     */
    private void initializeComponents(musicEngineControllerViewModel vm){

        Dimension DEFAULT_DIMENSION = new Dimension(50, 50);

        this.viewModel = vm;
        this.panel = new JPanel();

        int DEFAULT_KERNING = 10;
        int WIDTH = 1280;
        int HEIGHT = 100;

        panel.setBounds(0, 530, WIDTH, HEIGHT);
        FlowLayout barLayout = new FlowLayout(FlowLayout.LEFT, DEFAULT_KERNING, 0);
        this.panel.setLayout(barLayout);

        this.prev = new JButton(PREV);
        this.prev.setFocusable(false);
        this.prev.setOpaque(false);
        this.prev.setBorderPainted(false);
        this.prev.setContentAreaFilled(false);
        this.prev.setPreferredSize(DEFAULT_DIMENSION);

        this.skip = new JButton(FWD);
        this.skip.setFocusable(false);
        this.skip.setOpaque(false);
        this.skip.setBorderPainted(false);
        this.skip.setContentAreaFilled(false);
        this.skip.setPreferredSize(DEFAULT_DIMENSION);

        this.pause = new JButton(PAUSE);
        this.pause.setFocusable(false);
        this.pause.setOpaque(false);
        this.pause.setBorderPainted(false);
        this.pause.setContentAreaFilled(false);
        this.pause.setPreferredSize(DEFAULT_DIMENSION);

        this.skip.addActionListener(this);
        this.pause.addActionListener(this);


        JPanel songArtistPanel = new JPanel();

        GridLayout songArtistLayout = new GridLayout(2, 1);
        songArtistLayout.setVgap(0);
        songArtistPanel.setLayout(songArtistLayout);
        songArtistPanel.setMaximumSize(new Dimension(400, 100));
        songArtistPanel.setMinimumSize(new Dimension(400, 100));

        this.song = new JLabel("Nothing playing");
        this.artist = new JLabel("");
        songArtistPanel.add(this.song);
        songArtistPanel.add(this.artist);


        JPanel coverPanel = new JPanel();
        FlowLayout coverLayout = new FlowLayout(FlowLayout.LEFT, 15, 0);
        coverPanel.setLayout(coverLayout);
        this.cover = new JLabel("cover");

        try {
            BufferedImage tempCover = ImageIO.read(new File(Paths.get("").toAbsolutePath() +
                    "/src/songLib/cover/no_genre.png"));
            this.cover = new JLabel(new ImageIcon(tempCover.getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        coverPanel.setPreferredSize(new Dimension(WIDTH/2 - DEFAULT_KERNING * 2 - DEFAULT_DIMENSION.width * 2, 50));
        coverPanel.add(this.cover);
        coverPanel.add(songArtistPanel);

        this.panel.add(coverPanel);
        this.panel.add(this.prev);
        this.panel.add(this.pause);
        this.panel.add(this.skip);
    }

    /**
     * @return the play bar panel element
     */
    public JPanel getPanel() {
        return panel;
    }


    /**
     * Thread which calls sync method for updating the bar
     */
    private void waitForSong(){
        final Thread t = new Thread(this::updateOnNotify);
        t.start();
    }

    /**
     * Sync method to update the bar
     */
    private void updateOnNotify(){
        synchronized (sync) {
            try {
                sync.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.update();
            waitForSong();
        }
    }

    /**
     * Handles play bar button events.
     * @param actionEvent the button press event
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.skip){
            this.viewModel.skipSongAction();
        }
        else if (actionEvent.getSource() == this.pause){
            this.viewModel.pauseSongAction();
            updatePlayButton(this.pause.getIcon() == PAUSE);
        }
    }

    /**
     * Updates the icon of the play button.
     * @param play true iff song is playing
     */
    public void updatePlayButton(boolean play){
        if (play) this.pause.setIcon(PLAY);
        else this.pause.setIcon(PAUSE);
    }

    /**
     * Updates the play bar data.
     */
    public void update() {
        InMemorySong song = (InMemorySong) viewModel.getPlaying();

        if(song.getName().equals(""))
            return;

        this.song.setFont(UIManager.getFont( "h4.font" ));
        this.song.setText(song.getName());
        this.artist.setText(String.join(", ", song.getArtists()));
        this.cover.setIcon(new ImageIcon(song.getCover().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
        if (viewModel.getMediaType() == 2){ //SPACE
            this.prev.setEnabled(false);
            this.skip.setEnabled(false);
            this.pause.setEnabled(false);
        }
        if (viewModel.getMediaType() == 0){ //SONG
            this.prev.setEnabled(false);
            this.skip.setEnabled(false);
            this.pause.setEnabled(true);
        }
        if (viewModel.getMediaType() == 1){ //PLAYLIST
            this.prev.setEnabled(true);
            this.skip.setEnabled(true);
            this.pause.setEnabled(true);
        }
        updatePlayButton(true);
    }
}
