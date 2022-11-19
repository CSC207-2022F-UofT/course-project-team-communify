package InputBoundary;
import InputData.RemoveSongInputData;
import InputData.UploadSongInputData;

public interface EditSongInputBoundary {
    public void saveSong(UploadSongInputData UploadSongInputData);

    public void removeSong(RemoveSongInputData removeSongInputData);
}
