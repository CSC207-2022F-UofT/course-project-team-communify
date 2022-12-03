package OutputBoundary;
import OutputData.EditPlaylistOutputData;
import OutputData.NewPlaylistOutputData;
/**
 * Use case layer output boundary that allows communication between presenters and the new playlist use case.
 */
public interface NewPlaylistOutputBoundary {
    /**
     * @return the output message after creating a playlist
     */
    String getOutputMessage();

    /**
     * @param outputData the output to set as confirmation for new playlist
     */
    void setPlaylistCreationConfirmation(NewPlaylistOutputData outputData);

    /**
     * @param outputData the output to set as confirmation for edited playlist
     */
    void setEditPlaylistConfirmation(EditPlaylistOutputData outputData);
}
