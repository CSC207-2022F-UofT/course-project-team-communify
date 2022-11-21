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

public class PlayBar implements ActionListener {
    private JPanel panel;
    private musicEngineControllerViewModel viewModel;
    private final Object sync;
    private JButton pause;
    private JButton skip;
    private JLabel cover;
    private JLabel song;
    private JLabel artist;

    public PlayBar(musicEngineControllerViewModel vm, Object sync) {
        this.sync = sync;
        initializeComponents(vm);
        waitForSong();
    }

    private void initializeComponents(musicEngineControllerViewModel vm){
        this.viewModel = vm;
        this.panel = new JPanel();
        int WIDTH = 640;
        int HEIGHT = 100;
        panel.setBounds(0, 540, WIDTH, HEIGHT);
        FlowLayout barLayout = new FlowLayout(FlowLayout.CENTER, 50, 0);
        this.panel.setLayout(barLayout);
        this.skip = new JButton("Skip");
        this.pause = new JButton("Pause");
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
        coverPanel.add(this.cover);
        coverPanel.add(songArtistPanel);

        this.panel.add(coverPanel);
        this.panel.add(this.pause);
        this.panel.add(this.skip);
    }

    public JPanel getPanel() {
        return panel;
    }


    private void waitForSong(){
        final Thread t = new Thread(this::updateOnNotify);
        t.start();
    }

    private void updateOnNotify(){
        synchronized (sync) {
            try {
                sync.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            InMemorySong song = (InMemorySong) viewModel.getPlaying();
            this.song.setText(song.getName());
            this.artist.setText(String.join(", ", song.getArtists()));
            this.cover.setIcon(new ImageIcon(song.getCover().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
            waitForSong();
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.skip){
            this.viewModel.skipSongAction();
        }
        else if (actionEvent.getSource() == this.pause){
            this.viewModel.pauseSongAction();
            if (this.pause.getText().equals("Pause"))
                this.pause.setText("Resume");
            else
                this.pause.setText("Pause");
        }
    }
}