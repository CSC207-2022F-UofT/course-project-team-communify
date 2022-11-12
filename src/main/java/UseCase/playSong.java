// Use Case may not be 100% working for now and will need to be changed when we test/have a view

package UseCase;

import java.io.File;
import Entities.MusicPlayer;
import Entities.Song;
import InputBoundary.playSongInputBoundary;
import InputData.songInputData;
import OutputBoundary.songOutputBoundary;
import OutputData.songOutputData;


public class playSong implements playSongInputBoundary {

    private final MusicPlayer mp = MusicPlayer.getInstance();
    private final songOutputBoundary songPresenter;
    private final songOutputData songOutputData;
    private final Song song;

    public playSong(songInputData s){
        this.song = s.getSong();
    }

    public static void playAudio(File song){
        // scaffolding for play space
    }

    @Override
    public void playSong(songInputData song) {
        playAudioInteractor.playAudio(song);          // resolve

        this.songOutputData = new songOutputData(this.song);
        this.songPresenter.songPlayed(songOutputData);
    }
}