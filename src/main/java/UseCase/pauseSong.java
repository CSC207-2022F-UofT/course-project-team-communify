package UseCase;

import Entities.MusicPlayer;
import InputBoundary.pauseSongInputBoundary;

/**
 * Application business rules use case class to pause the playing song, or resume if paused.
 */
public class pauseSong implements pauseSongInputBoundary {
    public pauseSong(){

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
