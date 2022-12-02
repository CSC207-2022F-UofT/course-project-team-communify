package UseCase;

import Entities.MusicPlayer;
import Entities.Song;
import InputBoundary.PlayPlaylistInputBoundary;
import InputBoundary.PlaySongInputBoundary;
import InputData.PlaylistInputData;
import InputData.SongInputData;
import OutputBoundary.SongOutputBoundary;

import java.util.ArrayList;

/**
 * Use case layer class to play a playlist of songs. Handles the queuing of songs using synchronized
 * methods in tandem with the MusicPlayer, but delegates playing individual songs to the play song
 * use case. Thus, this use case has no output boundary, as the currently playing song is displayed
 * by the play song use case.
 */
public class PlayPlaylistInteractor implements PlayPlaylistInputBoundary {
    private boolean queue;
    private final Object sync;
    private int nextSong;
    SongOutputBoundary presenter;
    private PlaylistInputData data;

    /**
     * @param presenter the song output presenter
     */
    public PlayPlaylistInteractor(SongOutputBoundary presenter){
        queue = true;
        nextSong = 0;
        sync = MusicPlayer.getInstance().getSync();
        this.presenter = presenter;
    }

    /**
     * Plays the playlist given in the constructor.
     * @return whether there are songs left to play
     */
    @Override
    public boolean play(PlaylistInputData data) {
        this.data = data;
        ArrayList<Song> playlist = data.getSongs();
        if (nextSong < playlist.size()){
            PlaySongInputBoundary p = new PlaySongInteractor(presenter);
            int songToPlay = nextSong;
            nextSong++;
            final Thread t = new Thread(this::playNext);
            t.start();
            p.playSong(new SongInputData(playlist.get(songToPlay)));
            System.out.println("Now playing " + playlist.get(songToPlay).getName());
            return true;
        }
        else {
            presenter.songPlayed(null);
            System.out.println("Playlist over");
            return false;
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
                play(this.data);
            }
        }
    }
}
