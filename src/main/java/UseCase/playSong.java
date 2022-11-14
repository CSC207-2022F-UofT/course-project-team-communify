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
    private final Song song;
    private final songOutputBoundary presenter;

    public playSong(songInputData s, songOutputBoundary presenter){
        this.song = s.getSong();
        this.presenter = presenter;
    }

    public static void playAudio(File song){
        // scaffolding for play space
        // TODO: remove
    }

    @Override
    public void play() {
        mp.play(song);
        presenter.songPlayed(new songOutputData(song));
    }
}

// Tester comment