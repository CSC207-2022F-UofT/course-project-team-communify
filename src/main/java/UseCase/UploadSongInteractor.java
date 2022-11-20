package UseCase;
import Database.SaveSongAccessInterface;
import Database.SongLibrary;
import InputBoundary.UploadSongInputBoundary;
import InputData.UploadSongInputData;
import OutputBoundary.UploadSongOutputBoundary;
import OutputData.UploadSongOutputData;

public class UploadSongInteractor implements UploadSongInputBoundary {

    private final SaveSongAccessInterface songLibrary;
    private final UploadSongOutputBoundary uploadSongPresenter;


    public UploadSongInteractor(UploadSongOutputBoundary uploadSongPresenter){
        this.songLibrary = SongLibrary.getInstance();
        this.uploadSongPresenter = uploadSongPresenter;
    }

    /**
     * Execute the uploadSong use case. Inform the presenter whether or not it was a success.
     * @param usid contains filepath and uploading user.
     */
    public void saveSong(UploadSongInputData usid) {
        boolean success = songLibrary.saveSong(usid.getUploader(), usid.getFilepath());
        uploadSongPresenter.isUploaded(new UploadSongOutputData(success));
    }
}
