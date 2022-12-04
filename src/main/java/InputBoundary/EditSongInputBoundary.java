package inputBoundary;
import inputData.UploadSongInputData;
/**
 * Use case layer input boundary that allows communication between outer layers and the edit song use case.
 */
public interface EditSongInputBoundary {
    /**
     * @param UploadSongInputData the song to save in the database.
     */
    void saveSong(UploadSongInputData UploadSongInputData);
}
