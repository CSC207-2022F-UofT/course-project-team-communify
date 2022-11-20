package OutputBoundary;
import OutputData.EditPlaylistOutputData;
import OutputData.NewPlaylistOutputData;
public interface NewPlaylistOutputBoundary {
    public String getOutputMessage();

    public void setPlaylistCreationConfirmation(NewPlaylistOutputData outputData);

    public void setEditPlaylistConfirmation(EditPlaylistOutputData outputData);
}
