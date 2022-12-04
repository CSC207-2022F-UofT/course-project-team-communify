package useCase;

import entities.MusicPlayer;
import entities.Song;
import inputBoundary.PlaySongInputBoundary;
import inputData.SongInputData;
import outputBoundary.SongOutputBoundary;
import outputData.SongOutputData;

/**
 * Application business rules use case class to play a song.
 */
public class PlaySongInteractor implements PlaySongInputBoundary {

    private final MusicPlayer mp = MusicPlayer.getInstance();
    private final SongOutputBoundary songPresenter;

    /**
     * @param songPresenter the song output presenter
     */
    public PlaySongInteractor(SongOutputBoundary songPresenter){
        this.songPresenter = songPresenter;
    }

    /**
     * @param s the song to play
     */
    @Override
    public void playSong(SongInputData s) {
        Song song = s.getSong();
        this.mp.play(song);
        this.songPresenter.songPlayed(new SongOutputData(song));
    }
}