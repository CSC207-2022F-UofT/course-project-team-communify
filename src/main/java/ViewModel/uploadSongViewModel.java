package ViewModel;
import Controller.uploadSongController;
import InputData.uploadSongInputData;
import Presenter.uploadSongPresenter;

public class uploadSongViewModel {

    private final uploadSongController uploadSongController;
    private boolean isUploaded;

    uploadSongViewModel(){
        this.uploadSongController = new uploadSongController(new uploadSongPresenter(this));
    }

    public void upload(String filepath, String user){
        uploadSongInputData inputdata = new uploadSongInputData(filepath, user);
        uploadSongController.upload(inputdata);
    }

    public void updateIsUploaded(boolean isUploaded){
        this.isUploaded = isUploaded;
    }

}
