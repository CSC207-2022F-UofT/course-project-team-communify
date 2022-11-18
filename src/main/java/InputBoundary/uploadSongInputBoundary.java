package InputBoundary;
import InputData.uploadSongInputData;

public interface uploadSongInputBoundary {
    /**
     * Uploads the given song to the program and database.
     * @param uploadSongInputData the song to be uploaded.
     */
    public void saveSong(uploadSongInputData uploadSongInputData);
}
