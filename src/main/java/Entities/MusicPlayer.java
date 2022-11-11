package Entities;

import javazoom.jl.decoder.Bitstream;
import javazoom.jl.decoder.BitstreamException;
import javazoom.jl.decoder.Header;
import javazoom.jl.decoder.JavaLayerException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * A 'special' singleton entity that is the engine behind media playback.
 * It handles the currently playing song, as well as deals with the audio output.
 */
public class MusicPlayer {
    private static final MusicPlayer player = new MusicPlayer();
    private JPlayer engine;
    private boolean playing;
    private int position;
    private Song currentSong;

    /**
     * @return the singleton instance of MusicPlayer
     */
    public static MusicPlayer getInstance(){
        return player;
    }

    private MusicPlayer() {
        playing = false;
        position = 0;
    }

    /**
     * Plays a Song object - will override the currently playing song.
     * @param song the Song object to be played
     */
    public void play(Song song) {
        if (playing) {
            engine.close();
        }

        try {
            currentSong = song;
            engine = new JPlayer(new FileInputStream(song.getFile()));

            final Runnable r = () -> {
                try {
                    engine.play();
                } catch (JavaLayerException e) {
                    throw new RuntimeException(e);
                }
            };
            final Thread t = new Thread(r);
            playing = true;
            t.start();
        } catch (JavaLayerException e) {
            System.out.println("Problem with media player.");
        } catch (FileNotFoundException e) {
            System.out.println("Ignored error, this should not happen.");
        }
    }

    /**
     * Pauses the currently playing song, or does nothing if nothing is playing.
     */
    public void pause(){
        if (playing){
            position = engine.getPosition();
            position = (int) (position / msPerFrame());
            engine.close();
            playing = false;
        }
    }

    /**
     * Resumes music if and only if there is a current song that is not playing.
     */
    public void resume() {
        if (!playing & currentSong != null){
            try {
                engine = new JPlayer(new FileInputStream(currentSong.getFile()));

                final Runnable r = () -> {
                    try {
                        engine.play(position, (int) (length() / msPerFrame()));
                    } catch (JavaLayerException e) {
                        throw new RuntimeException(e);
                    }
                };
                final Thread t = new Thread(r);
                playing = true;
                t.start();
            } catch (JavaLayerException e) {
                System.out.println("Problem with media player.");
            } catch (FileNotFoundException e) {
                System.out.println("File not found, this should not happen.");
            }
        }
    }

    /**
     * Check whether there is currently playing music.
     * @return true if and only if there is music playing
     */
    public boolean isPlaying() {
        return playing;
    }

    /**
     * Returns the ms/frame, necessary for resume calculations.
     * @return milliseconds per each frame
     */
    private float msPerFrame() {
        Bitstream bitstream = null;
        try {
            bitstream = new Bitstream(new FileInputStream(currentSong.getFile()));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Header h = null;
        try {
            h = bitstream.readFrame();
        } catch (BitstreamException ex) {
            System.out.println("Bitstream exception.");
        }

        if (h != null)
            return h.ms_per_frame();
        return 1.0F;
    }

    /**
     * Returns the ms length of currentSong, necessary for resume calculations.
     * @return length of current song in milliseconds
     */
    private double length(){
        Bitstream bitstream;
        try {
            bitstream = new Bitstream(new FileInputStream(currentSong.getFile()));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Header h;
        try {
            h = bitstream.readFrame();
        } catch (BitstreamException ex) {
            throw new RuntimeException(ex);
        }

        long tn = currentSong.getFile().length();
        return h.total_ms((int) tn);
    }
}
