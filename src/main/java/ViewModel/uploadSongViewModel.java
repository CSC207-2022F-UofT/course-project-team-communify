package ViewModel;
import Controller.uploadSongController;
import InputData.uploadSongInputData;
import Presenter.uploadSongPresenter;

public class uploadSongViewModel {

    private final uploadSongController uploadSongController;
    private boolean isUploaded;

    public uploadSongViewModel(){
        this.uploadSongController = new uploadSongController(new uploadSongPresenter(this));
    }

    /**
     *
     * @param filepath Filepath to the desired song.
     * @param user The username of the uploading user.
     * @return true iff song was successfully uploaded.
     */
    public boolean upload(String filepath, String user){
        uploadSongInputData inputdata = new uploadSongInputData(filepath, user);
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
