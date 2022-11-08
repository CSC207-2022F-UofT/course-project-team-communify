package UseCase;
import Database.songAccessInterface;
import Entities.Song;
import InputBoundary.uploadSongInputBoundary;
import InputData.uploadSongInputData;

public class uploadSong implements uploadSongInputBoundary{

    songAccessInterface songAccessInterface;
    public void uploadSong(uploadSongInputData uploadSongInputData) {
        //TODO: Read file, pass to createSong who uses readMetadata.
    }

    public void readMetadata(){
        // TODO: helper function.
    }

    public Song createSong(){
        //TODO: helper function.
        return null;
    }
}
