package InputBoundary;

import InputData.songInputData;
import OutputData.songOutputData;

/**
 * interface for wrapping the space controller for the playing the space use case.
 */
public interface playSpaceInputBoundary {

    /**
     * function to play the space
     * @param songInputData data required to play the space
     */
    default void playSpace(songInputData songInputData){}

    /**
     * function to play a random song given that the space controller has no songs queued
     */
    default songOutputData pickRandomSong(){
        return null;
    }

}
