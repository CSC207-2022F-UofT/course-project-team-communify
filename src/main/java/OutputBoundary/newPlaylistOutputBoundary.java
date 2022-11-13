package OutputBoundary;
import OutputData.newPlaylistOutputData;
public interface newPlaylistOutputBoundary {
    default String playlistCreationConfirmation(newPlaylistOutputData newPlaylistOutputData){
        return null;
    }
}
