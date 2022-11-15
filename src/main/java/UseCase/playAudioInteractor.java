package UseCase;

import InputData.audioInputData;
import InputBoundary.playAudioInputBoundary;
import Entities.MusicPlayer;

/**
 * Use case for playing audio from a given MP3 file
 * This use case does not need anything related to outputs such as an output boundary because
 * its purpose is to be used by the playSpace and playSong use cases which will do the output work
 */
public class playAudioInteractor implements playAudioInputBoundary {

    /**
     * Empty constructor
     */
    public playAudioInteractor() {
    }


    /**
     * Function to play the audio from a given song
     *
     * @param song is an instance of Song which is an MP3
     */
    public void playAudio(audioInputData song) {
        MusicPlayer.getInstance().play(song.getSong());
    }
}