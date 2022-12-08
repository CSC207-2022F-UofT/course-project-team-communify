package outputBoundary;
import outputData.EditPlaylistOutputData;
import outputData.NewPlaylistOutputData;
/**
 * Use case layer output boundary that allows communication between presenters and the new playlist use case.
 */
public interface NewPlaylistOutputBoundary {

    /**
     * @param outputData the output to set as confirmation for new playlist
     */
    void setPlaylistCreationConfirmation(NewPlaylistOutputData outputData);

    /**
     * @param outputData the output to set as confirmation for edited playlist
     */
    void setEditPlaylistConfirmation(EditPlaylistOutputData outputData);
}
