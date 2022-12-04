package inputBoundary;
import inputData.EditPlaylistInputData;
/**
 * Use case layer input boundary that allows communication between outer layers and the edit playlist use case.
 */
public interface EditPlaylistInputBoundary {
    /**
     * Remove a song from a playlist
     * @param inputData the data containing playlist and song to remove
     */
    void removeSong(EditPlaylistInputData inputData);
    /**
     * Add a song to a playlist
     * @param inputData the data containing playlist and song to add
     */
    void addSong(EditPlaylistInputData inputData);
}
