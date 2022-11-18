package Controller;

import java.io.File;

import InputBoundary.playAudioInputBoundary;
import InputData.songInputData;

/**
 * Controller for the playAudio use case
 */
public class playAudioController {

    private final playAudioInputBoundary playAudioInteractor;

    /**
     * Constructor.
     * @param playAudioInteractor use case interactor for playing audio from a file
     */
    public playAudioController(playAudioInputBoundary playAudioInteractor) {
        this.playAudioInteractor = playAudioInteractor;
    }

    /**
     * Function calling the use case for playing audio
     * @param songFile is the File object of the MP3 file
     */
    public void playAudio(songInputData songFile) {
        songInputData songInput = new songInputData(songFile.getSong());
        this.playAudioInteractor.playAudio(songInput);
    }

}

// Add exceptions - look at reference