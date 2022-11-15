package InputBoundary;
import InputData.newPlaylistInputData;

public interface newPlaylistInputBoundary {
    void newPlaylist(newPlaylistInputData inputData);

    default String showConfirmation(){
        return null;
    }
}
