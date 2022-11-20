package UseCase;

import Entities.MusicPlayer;
import Entities.Song;
import InputBoundary.PlaySongInputBoundary;
import InputData.SongInputData;
import OutputBoundary.SongOutputBoundary;
import OutputData.SongOutputData;


public class PlaySongInteractor implements PlaySongInputBoundary {

    private final MusicPlayer mp = MusicPlayer.getInstance();
    private final SongOutputBoundary songPresenter;

    public PlaySongInteractor(SongOutputBoundary songPresenter){
        this.songPresenter = songPresenter;
    }

    @Override
    public void playSong(SongInputData s) {
        Song song = s.getSong();
        this.mp.play(song);
        this.songPresenter.songPlayed(new SongOutputData(song));
    }
}