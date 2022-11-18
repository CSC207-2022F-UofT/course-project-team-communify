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
    songOutputData pickRandomSong();


    /**
     * function to stop space from queuing next song
     */
    void stopSpace();

    /**
     * in the case that the space is updated while it is playing, this method is called after adding to space
     * @param playSpaceInputData the new space list
     */
    void updateSpace(playSpaceInputData playSpaceInputData);
}
