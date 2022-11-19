package UseCase;

import Entities.MusicPlayer;
import InputBoundary.pauseSongInputBoundary;

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
