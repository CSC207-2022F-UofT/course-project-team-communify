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
    private final Song song;

    /**
     * @param s the song to be played
     * @param songPresenter the presenter for output to the view
     */
    public playSongInteractor(songInputData s, songOutputBoundary songPresenter){
        this.song = s.getSong();
        this.songPresenter = songPresenter;
    }

    /**
     * Plays the given song and updates the view via the presenter.
     */
    @Override
    public void playSong() {
        this.mp.play(this.song);
        this.songPresenter.songPlayed(new songOutputData(this.song));
    }
}