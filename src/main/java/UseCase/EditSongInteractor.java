package UseCase;
import Database.SaveSongAccessInterface;
import InputBoundary.EditSongInputBoundary;
import InputData.UploadSongInputData;
import OutputBoundary.EditSongOutputBoundary;
import OutputData.EditSongOutputData;

/**
 * Application business rules use case class to edit a song.
 */
public class EditSongInteractor implements EditSongInputBoundary {

    private final SaveSongAccessInterface songLibrary;
    private final EditSongOutputBoundary uploadSongPresenter;


    /**
     * @param uploadSongPresenter the presenter for edit song output
     */
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
