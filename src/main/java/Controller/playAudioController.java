package Controller;

import InputBoundary.playAudioInputBoundary;
import InputData.audioInputData;

/**
 * Add Java docs after
 */
public class playAudioController {

    private final playAudioInputBoundary playAudioInteractor;
    private final audioInputData songFile;

    /**
     * Add Java docs after
     */
    public playAudioController(playAudioInputBoundary playAudioInteractor, audioInputData songFile) {
        this.playAudioInteractor = playAudioInteractor;
        this.songFile = songFile;
    }

    /**
     * Add Java Docs after
     */
    public void playAudio() {
        this.playAudioInteractor.playAudio(this.songFile);
    }

}
