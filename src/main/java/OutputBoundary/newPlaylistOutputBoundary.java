package OutputBoundary;
import OutputData.newPlaylistOutputData;
public interface newPlaylistOutputBoundary {
    default String getPlaylistCreationConfirmation(newPlaylistOutputData outputData){
        return null;
    }
}
