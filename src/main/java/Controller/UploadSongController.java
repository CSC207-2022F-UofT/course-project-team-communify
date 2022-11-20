package Controller;
import InputBoundary.UploadSongInputBoundary;
import InputData.UploadSongInputData;
import OutputBoundary.UploadSongOutputBoundary;
import UseCase.UploadSongInteractor;

public class UploadSongController {

    UploadSongOutputBoundary uploadSongPresenter;
    UploadSongInputBoundary uploadSong;

    public UploadSongController(UploadSongOutputBoundary uploadSongPresenter){
        this.uploadSongPresenter = uploadSongPresenter;
        this.uploadSong = new UploadSongInteractor(this.uploadSongPresenter);
    }

    /**
     * Call the use case to upload a given song.
     * @param uploadSongInputData contains filepath and uploading user.
     */
    public void upload(UploadSongInputData uploadSongInputData){
         uploadSong.saveSong(uploadSongInputData);
    }

}
