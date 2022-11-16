package UseCase;
import Database.SaveSongAccessInterface;
import InputBoundary.uploadSongInputBoundary;
import InputData.uploadSongInputData;
import OutputBoundary.uploadSongOutputBoundary;
import OutputData.uploadSongOutputData;

public class UploadSongInteractor implements uploadSongInputBoundary{

    private final SaveSongAccessInterface songLibrary;
    private final uploadSongOutputBoundary uploadSongPresenter;


    public UploadSongInteractor(uploadSongOutputBoundary uploadSongPresenter){
        this.songLibrary = Database.songLibrary.getInstance();
        this.uploadSongPresenter = uploadSongPresenter;
    }

    public void saveSong(uploadSongInputData usid) {
        boolean success = songLibrary.saveSong(usid.getUploader(), usid.getFilepath());
        uploadSongPresenter.isUploaded(new uploadSongOutputData(success));
    }
}
