package InputBoundary;

import InputData.spaceInputData;

/**
 * interface for wrapping the space controller for the playing the space use case.
 */
public interface playSpaceInputBoundary {

    /**
     * @param spaceInputData data required to play the space
     */
    default void playSpace(spaceInputData spaceInputData){}
}
