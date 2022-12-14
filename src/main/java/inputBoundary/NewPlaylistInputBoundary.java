package inputBoundary;
import inputData.NewPlaylistInputData;

/**
 * Use case layer input boundary that allows communication between outer layers and the new playlist use case.
 */
public interface NewPlaylistInputBoundary {
    /**
     * Creates a new playlist.
     * @param inputData the data containing the songs and name for the new playlist
     */
    void newPlaylist(NewPlaylistInputData inputData);
}
