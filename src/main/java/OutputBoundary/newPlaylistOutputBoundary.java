package OutputBoundary;
import OutputData.editPlaylistOutputData;
import OutputData.newPlaylistOutputData;
/**
 * Use case layer input boundary that allows communication between presenters and the new playlist use case.
 */
public interface newPlaylistOutputBoundary {
    /**
     * @return the output message after creating a playlist
     */
    String getOutputMessage();

    /**
     * @param outputData the output to set as confirmation for new playlist
     */
    void setPlaylistCreationConfirmation(newPlaylistOutputData outputData);

    /**
     * @param outputData the output to set as confirmation for edited playlist
     */
    void setEditPlaylistConfirmation(editPlaylistOutputData outputData);
}
