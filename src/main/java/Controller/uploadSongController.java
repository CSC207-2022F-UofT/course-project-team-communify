package Controller;
import InputBoundary.uploadSongInputBoundary;
import InputData.uploadSongInputData;
import OutputBoundary.uploadSongOutputBoundary;
import UseCase.UploadSongInteractor;

/**
 * Interface adapters layer controller for the upload song use case.
 */
public class uploadSongController {

    uploadSongOutputBoundary uploadSongPresenter;
    uploadSongInputBoundary uploadSong;

    /**
     * @param uploadSongPresenter the presenter to return info to the view
     */
    public uploadSongController(uploadSongOutputBoundary uploadSongPresenter){
        this.uploadSongPresenter = uploadSongPresenter;
        this.uploadSong = new UploadSongInteractor(this.uploadSongPresenter);
    }

    /**
     * Call the use case to upload a given song.
     * @param uploadSongInputData contains filepath and uploading user.
     */
    public void upload(uploadSongInputData uploadSongInputData){
         uploadSong.saveSong(uploadSongInputData);
    }

}
