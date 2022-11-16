package UseCase;

import Entities.MusicPlayer;
import Entities.Song;
import InputBoundary.playSongInputBoundary;
import InputData.songInputData;
import OutputBoundary.songOutputBoundary;
import OutputData.songOutputData;


public class playSongInteractor implements playSongInputBoundary {

    private final MusicPlayer mp = MusicPlayer.getInstance();
    private final songOutputBoundary songPresenter;
    private final Song song;

    public playSongInteractor(songInputData s, songOutputBoundary songPresenter){
        this.song = s.getSong();
        this.songPresenter = songPresenter;
    }

    @Override
    public void playSong() {
        this.mp.play(this.song);
        this.songPresenter.songPlayed(new songOutputData(this.song));
    }
}