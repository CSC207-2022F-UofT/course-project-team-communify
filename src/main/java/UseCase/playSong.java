package UseCase;

import java.io.File;
import Entities.MusicPlayer;
import Entities.Song;
import InputBoundary.playSongInputBoundary;
import InputData.songInputData;

public class playSong implements playSongInputBoundary {
    private final MusicPlayer mp = MusicPlayer.getInstance();
    private final Song song;

    public playSong(songInputData s){
        this.song = s.getSong();
    }

    public static void playAudio(File song){
    // scaffolding for play space
    }

    @Override
    public void play() {
        mp.play(song);
    }
}

// Tester comment