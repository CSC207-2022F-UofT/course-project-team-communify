package OutputBoundary;
import OutputData.newPlaylistOutputData;
public interface newPlaylistOutputBoundary {
    public String getOutputMessage();

    public void setPlaylistCreationConfirmation(newPlaylistOutputData outputData);
}
