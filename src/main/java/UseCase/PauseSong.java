package UseCase;

import Entities.MusicPlayer;
import InputBoundary.PauseSongInputBoundary;

public class PauseSong implements PauseSongInputBoundary {
    public PauseSong(){

    }

    /**
     * Pauses or resumes the audio, depending on if there is a song playing
     */
    @Override
    public void pause() {
        MusicPlayer mp = MusicPlayer.getInstance();
        if (mp.isPlaying()){
            mp.pause();
        }
        else {
            mp.resume();
        }
    }
}
