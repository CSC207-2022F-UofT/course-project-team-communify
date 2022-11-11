package UseCase;

import Entities.MusicPlayer;
import Entities.Song;
import InputBoundary.playPlaylistInputBoundary;
import InputBoundary.playSongInputBoundary;
import InputData.playlistInputData;
import InputData.songInputData;
import java.util.ArrayList;

/**
 * Use case layer class to play a playlist of songs. Handles the queuing of songs using synchronized
 * methods in tandem with the MusicPlayer, but delegates playing individual songs to the play song
 * use case. Thus, this use case has no output boundary, as the currently playing song is displayed
 * by the play song use case.
 */
public class playPlaylist implements playPlaylistInputBoundary {
    private boolean queue;
    private final ArrayList<Song> playlist;
    private final Object sync;
    private int nextSong;

    public playPlaylist(playlistInputData data){
        this.playlist = data.getSongs();
        queue = true;
        nextSong = 0;
        sync = MusicPlayer.getInstance().getSync();
    }

    /**
     * Plays the playlist given in the constructor.
     */
    @Override
    public void play() {
        if (nextSong < playlist.size()){
            playSongInputBoundary p = new playSong(new songInputData(playlist.get(nextSong)));
            nextSong++;
            final Thread t = new Thread(this::playNext);
            t.start();
            p.play();
        }
    }

    /**
     * Dequeues the playlist, such that after the currently playing song ends the playlist
     * will not continue. Must be called whenever audio source is switched (eg. user plays new song,
     * different playlist, or space).
     */
    @Override
    public void stopQueue() {
        queue = false;
    }

    /**
     * Private helper method that deals with playing the next song in the queue using synchronized blocks.
     */
    private void playNext(){
        synchronized (sync){
            try {
                sync.wait();
            } catch (InterruptedException e){
                System.out.println("Thread interrupted.");
            }
            if (queue){
                play();
            }
        }
    }
}
