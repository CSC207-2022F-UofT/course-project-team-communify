package UseCase;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import InputBoundary.playAudioInputBoundary;
import InputData.audioInputData;

/**
 * Add Java docs later
 * This Use Case technically outputs nothing except when it plays audio this might change if we
 * need to return something like a boolean to show the audio is playing successfully
 */
public class playAudioInteractor implements playAudioInputBoundary {

    /**
     * Does not need a constructor since there is no output boundary or presenter need for this usecase?
     */
    public playAudioInteractor() {
    }


    /**
     * Add Java docs later, THIS METHOD NEEDS TO CHANGE AFTER PLAYER IS MADE INTO SINGLETON
     * HAS SOME EXCEPTIONS THAT NEED TO BE HANDLED AS WELL
     * @param songFile
     */
    @Override
    public void playAudio(audioInputData songFile) throws FileNotFoundException, JavaLayerException {

        FileInputStream media = new FileInputStream(songFile.getSongFile().getAbsolutePath());
        Player player = new Player(media);   // Player will later be a part of audioInputData, but for now its just this
        player.play();

    }
}
