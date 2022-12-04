package inputBoundary;

import inputData.PlaySpaceInputData;
import outputData.SongOutputData;

/**
 * interface for wrapping the space controller for the playing the space use case.
 */
public interface PlaySpaceInputBoundary {

    /**
     * function to play the space
     */
    void playSpace();

    /**
     * function to stop space from queuing next song
     */
    void stopSpace();

    /**
     * in the case that the space is updated while it is playing, this method is called after adding to space
     * @param playSpaceInputData the new space list
     */
    void updateSpace(PlaySpaceInputData playSpaceInputData);
}
