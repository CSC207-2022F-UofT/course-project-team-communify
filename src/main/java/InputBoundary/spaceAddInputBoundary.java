package InputBoundary;

import InputData.spaceInputData;

/**
 * interface for wrapping the space controller for the adding a song to the space use case.
 */
public interface spaceAddInputBoundary {
    /**
     * @param spaceInputData data required to add a specific song to the space
     */
    default void spaceAddSong(spaceInputData spaceInputData){}
}
