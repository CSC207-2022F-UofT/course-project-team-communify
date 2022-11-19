package InputBoundary;

import InputData.playlistInputData;

/**
 * Application Business Rules layer interface to be implemented by a Use Case
 * to allow communication between use cases and UI input (dependency inversion).
 */
public interface recommendationInputBoundary {
    /**
     * Requests a recommendation.
     * @param data the playlist to recommend a song based on
     */
    void recommendation(playlistInputData data);
}
