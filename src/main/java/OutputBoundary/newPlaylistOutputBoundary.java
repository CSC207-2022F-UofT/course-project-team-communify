package OutputBoundary;
import OutputData.editPlaylistOutputData;
import OutputData.newPlaylistOutputData;
public interface newPlaylistOutputBoundary {
    public String getOutputMessage();

    public void setPlaylistCreationConfirmation(newPlaylistOutputData outputData);

    public void setEditPlaylistConfirmation(editPlaylistOutputData outputData);
}
