package InputBoundary;

import InputData.audioInputData;
import javazoom.jl.decoder.JavaLayerException;

import java.io.FileNotFoundException;

/**
 * Add Java Docs after
 */
public interface playAudioInputBoundary {

    /**
     * Add Java Docs after
     * @param songFile
     */
    void playAudio(audioInputData songFile) throws FileNotFoundException, JavaLayerException;

}
