package InputBoundary;

import InputData.playSpaceInputData;
import OutputData.songOutputData;

/**
 * interface for wrapping the space controller for the playing the space use case.
 */
public interface playSpaceInputBoundary {

    /**
     * function to play the space
     * @param songInputData data required to play the space
     */
    void playSpace(playSpaceInputData songInputData);

    /**
     * function to play a random song given that the space controller has no songs queued
     */
    default songOutputData pickRandomSong(){
        return null;
    }

}
