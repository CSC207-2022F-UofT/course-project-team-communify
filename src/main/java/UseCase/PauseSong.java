package UseCase;

import Entities.MusicPlayer;
import InputBoundary.PauseSongInputBoundary;

/**
 * Application business rules use case class to pause the playing song, or resume if paused.
 */
public class PauseSong implements PauseSongInputBoundary {
    /**
     * Empty constructor
     */
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
