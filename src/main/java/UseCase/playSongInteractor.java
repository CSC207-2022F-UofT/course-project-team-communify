package UseCase;

import Entities.MusicPlayer;
import Entities.Song;
import InputBoundary.playSongInputBoundary;
import InputData.songInputData;
import OutputBoundary.songOutputBoundary;
import OutputData.songOutputData;

/**
 * Application business rules use case class to play a song.
 */
public class playSongInteractor implements playSongInputBoundary {

    private final MusicPlayer mp = MusicPlayer.getInstance();
    private final songOutputBoundary songPresenter;

    /**
     * @param songPresenter the song output presenter
     */
    public playSongInteractor(songOutputBoundary songPresenter){
        this.songPresenter = songPresenter;
    }

    /**
     * @param s the song to play
     */
    @Override
    public void playSong(songInputData s) {
        Song song = s.getSong();
        this.mp.play(song);
        this.songPresenter.songPlayed(new songOutputData(song));
    }
}