package OutputBoundary;

import OutputData.songOutputData;

/**
 * Application Business Rules layer interface to be implemented by a Presenter
 * to allow communication between use cases and UI (dependency inversion).
 */
public interface recommendationOutputBoundary {
    /**
     * Recommends a song to be presented. the user
     * @param s the output Song recommendation to be sent to the presenter.
     */
    public void recommendSong(songOutputData s);
}
