package InputBoundary;

import InputData.songInputData;

/**
 * interface for wrapping the space controller for the adding a song to the space.
 */
public interface spaceAddInputBoundary {
    /**
     * @param songInputData data required to add a specific song to the space
     */
    default void spaceAddSong(songInputData songInputData){}
}
