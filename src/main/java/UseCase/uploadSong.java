package UseCase;

import Database.songAccessInterface;
import InputBoundary.uploadSongInputBoundary;
import InputData.uploadSongInputData;
/**
 * Application business rules use case class to upload a new song.
 */
public class uploadSong implements uploadSongInputBoundary{

    songAccessInterface songAccessInterface;

    /**
     * Uploads a new song.
     * @param uploadSongInputData the song to be uploaded.
     */
    public void uploadSong(uploadSongInputData uploadSongInputData) {
        //TODO
    }
}
