package UseCase;
import Database.SaveSongAccessInterface;
import InputBoundary.EditSongInputBoundary;
import InputData.UploadSongInputData;
import OutputBoundary.EditSongOutputBoundary;
import OutputData.EditSongOutputData;

public class EditSongInteractor implements EditSongInputBoundary {

    private final SaveSongAccessInterface songLibrary;
    private final EditSongOutputBoundary uploadSongPresenter;


    public EditSongInteractor(EditSongOutputBoundary uploadSongPresenter){
        this.songLibrary = Database.songLibrary.getInstance();
        this.uploadSongPresenter = uploadSongPresenter;
    }

    /**
     * Execute the uploadSong use case. Inform the presenter whether it was a success.
     * @param usid contains filepath and uploading user.
     */
    @Override
    public void saveSong(UploadSongInputData usid) {
        boolean success = songLibrary.saveSong(usid.getUploader(), usid.getFilepath());
        uploadSongPresenter.isUploaded(new EditSongOutputData(success));
    }
}
