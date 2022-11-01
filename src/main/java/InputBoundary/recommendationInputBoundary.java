package InputBoundary;

import InputData.playlistInputData;

/**
 * Application Business Rules layer interface to be implemented by a Use Case
 * to allow communication between use cases and UI input (dependency inversion).
 */
public interface recommendationInputBoundary {
    /**
     * Requests a recommendation on the selected Playlist.
     * @param p the Playlist input data on which the recommendation is requested
     */
    public void recommendation(playlistInputData p);
}
