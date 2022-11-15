package UseCase;

import InputBoundary.playAudioInputBoundary;
import InputData.audioInputData;

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
     * Function to play the audio from a given songFile
     * @param songFile is an instance of File which is an MP3 file
     */
    @Override
    public void playAudio(audioInputData songFile) {

        // MusicPlayer.play(songFile);

        //***
        // If this is how the MusicPlayer should be called then I need to change this use case to take in a song not a songFile,
        // small change but I need to confirm that this line will play the audio provided
        // ***
    }
}

// For later: May need some exceptions, look into it
