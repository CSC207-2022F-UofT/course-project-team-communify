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

    public playSongInteractor(songOutputBoundary songPresenter){
        this.songPresenter = songPresenter;
    }

    @Override
    public void playSong(songInputData s) {
        Song song = s.getSong();
        this.mp.play(song);
        this.songPresenter.songPlayed(new songOutputData(song));
    }
}