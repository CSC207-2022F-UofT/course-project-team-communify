package Controller;
import InputBoundary.uploadSongInputBoundary;
import InputData.uploadSongInputData;
import OutputBoundary.uploadSongOutputBoundary;
import UseCase.UploadSongInteractor;

public class uploadSongController {

    uploadSongOutputBoundary uploadSongPresenter;
    uploadSongInputBoundary uploadSong;

    public uploadSongController(uploadSongOutputBoundary uploadSongPresenter){
        this.uploadSongPresenter = uploadSongPresenter;
        uploadSong = new UploadSongInteractor(this.uploadSongPresenter);
    }

    /**
     * Call the use case to upload a given song.
     * @param uploadSongInputData contains filepath and uploading user.
     */
    public void upload(uploadSongInputData uploadSongInputData){
         uploadSong.saveSong(uploadSongInputData);
    }

}
