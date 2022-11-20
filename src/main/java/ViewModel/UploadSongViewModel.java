package ViewModel;
import Controller.UploadSongController;
import InputData.UploadSongInputData;
import Presenter.UploadSongPresenter;

public class UploadSongViewModel {

    private final UploadSongController uploadSongController;
    private boolean isUploaded;

    UploadSongViewModel(){
        this.uploadSongController = new UploadSongController(new UploadSongPresenter(this));
    }

    /**
     *
     * @param filepath Filepath to the desired song.
     * @param user The username of the uploading user.
     * @return true iff song was successfully uploaded.
     */
    public boolean upload(String filepath, String user){
        UploadSongInputData inputdata = new UploadSongInputData(filepath, user);
        uploadSongController.upload(inputdata);
        return this.isUploaded;
    }

    /**
     * Updates isUploaded to whether a song was successfully uploaded, called by uploadSongPresenter.
     * @param isUploaded true iff a song was successfully uploaded.
     */
    public void updateIsUploaded(boolean isUploaded){
        this.isUploaded = isUploaded;
    }

}
