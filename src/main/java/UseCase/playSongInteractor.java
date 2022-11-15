package UseCase;

import Entities.MusicPlayer;
import Entities.Song;
import InputBoundary.playSongInputBoundary;
import InputData.songInputData;
import OutputBoundary.songOutputBoundary;
import OutputData.songOutputData;
import java.io.File;


public class playSongInteractor implements playSongInputBoundary {

    private final MusicPlayer mp = MusicPlayer.getInstance();
    private final songOutputBoundary songPresenter;
    private final Song song;

    public playSongInteractor(songInputData s, songOutputBoundary songPresenter){
        this.song = s.getSong();
        this.songPresenter = songPresenter;
    }

    public static void playAudio(songInputData songInputData) {
        // Skeletal code for playSpace method, change later.
        playAudioInteractor audio = new playAudioInteractor();
        audio.playAudio(songInputData);
    }

    @Override
    public void play() {

    }

    @Override
    public void playSong(songInputData song) {
        playAudioInteractor audio = new playAudioInteractor();
        audio.playAudio(song);

        OutputData.songOutputData songOutputData = new songOutputData(this.song);
        this.songPresenter.songPlayed(songOutputData);
    }
}