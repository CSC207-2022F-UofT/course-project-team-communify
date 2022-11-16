package Controller;
import InputBoundary.uploadSongInputBoundary;
import InputData.uploadSongInputData;
import OutputBoundary.uploadSongOutputBoundary;
import UseCase.UploadSongInteractor;
import ViewModel.uploadSongViewModel;

public class uploadSongController {

    uploadSongOutputBoundary uploadSongPresenter;
    UploadSongInteractor uploadSong;

    public uploadSongController(uploadSongOutputBoundary uploadSongPresenter){
        this.uploadSongPresenter = uploadSongPresenter;
    }
    public void upload(uploadSongInputData uploadSongInputData){
         uploadSong = new UploadSongInteractor(this.uploadSongPresenter);
         uploadSong.saveSong(uploadSongInputData);
    }

}
