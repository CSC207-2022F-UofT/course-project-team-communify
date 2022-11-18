package ViewModel;
import Controller.uploadSongController;
import InputData.uploadSongInputData;
import Presenter.uploadSongPresenter;

/**
 * The interface adapters layer view model which acts as a gateway between the view and the uploading related
 * parts of the program.
 */
public class uploadSongViewModel {

    private final uploadSongController uploadSongController;
    private boolean isUploaded;

    uploadSongViewModel(){
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
