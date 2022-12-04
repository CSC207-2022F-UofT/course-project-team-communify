package inputBoundary;

import inputData.PlaylistInputData;

/**
 * Application Business Rules layer interface to be implemented by a Use Case
 * to allow communication between use cases and UI input (dependency inversion).
 */
public interface RecommendationInputBoundary {
    /**
     * Requests a recommendation.
     * @param data the playlist to recommend a song based on
     */
    void recommendation(PlaylistInputData data);
}
