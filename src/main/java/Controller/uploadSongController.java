package Controller;
import InputData.uploadSongInputData;
import OutputBoundary.uploadSongOutputBoundary;
import UseCase.UploadSongInteractor;

public class uploadSongController {

    uploadSongOutputBoundary uploadSongPresenter;
    UploadSongInteractor uploadSong;

    public uploadSongController(uploadSongOutputBoundary uploadSongPresenter){
        this.uploadSongPresenter = uploadSongPresenter;
    }

    /**
     * Call the use case to upload a given song.
     * @param uploadSongInputData contains filepath and uploading user.
     */
    public void upload(uploadSongInputData uploadSongInputData){
         uploadSong = new UploadSongInteractor(this.uploadSongPresenter);
         uploadSong.saveSong(uploadSongInputData);
    }

}
