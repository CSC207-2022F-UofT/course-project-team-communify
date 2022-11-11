package InputBoundary;

import InputData.audioInputData;
import javazoom.jl.decoder.JavaLayerException;

import java.io.FileNotFoundException;

/**
 * Interface for the playAudioInteractor to implement for the use case
 */
public interface playAudioInputBoundary {

    void playAudio(audioInputData songFile);

}
