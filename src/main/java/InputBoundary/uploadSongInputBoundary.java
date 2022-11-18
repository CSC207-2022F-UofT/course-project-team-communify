package InputBoundary;
import InputData.uploadSongInputData;
/**
 * Use case layer input boundary that allows communication between outer layers and the upload song use case.
 */
public interface uploadSongInputBoundary {
    /**
     * Uploads the given song to the program and database.
     * @param uploadSongInputData the song to be uploaded.
     */
    void uploadSong(uploadSongInputData uploadSongInputData);
}
