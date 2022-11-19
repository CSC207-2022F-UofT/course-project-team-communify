package ViewModel;
import Controller.EditSongController;
import Controller.getArtistSongController;
import InputData.UploadSongInputData;
import InputData.getArtistSongInputData;
import Presenter.EditSongPresenter;
import Presenter.getArtistSongPresenter;

public class ArtistViewModel {

    private final EditSongController editSongController;
    private final Controller.getArtistSongController getArtistSongController;

    private String[][] songTable;
    private boolean isUploaded;

    public ArtistViewModel(){
        this.editSongController = new EditSongController(new EditSongPresenter(this));
        this.getArtistSongController = new getArtistSongController(new getArtistSongPresenter(this));
    }

    /**
     *
     * @param filepath Filepath to the desired song.
     * @param user The username of the uploading user.
     * @return true iff song was successfully uploaded.
     */
    public boolean upload(String filepath, String user){
        UploadSongInputData inputdata = new UploadSongInputData(filepath, user);
        this.editSongController.upload(inputdata);
        return this.isUploaded;
    }

    /**
     * Updates isUploaded to whether a song was successfully uploaded.
     * @param isUploaded true iff song was uploaded.
     */
    public void updateIsUploaded(boolean isUploaded){
        this.isUploaded = isUploaded;
    }


    public String[][] getArtistSongs(String user){
        getArtistSongInputData inputdata = new getArtistSongInputData(user);
        this.getArtistSongController.getSong(inputdata);
        return this.songTable;
    }

    /**
     * Updates String[][] to all songs artist has uploaded.
     * @param songTable String[][] of all songs artist has uploaded.
     */
    public void updateSongTable(String[][] songTable){
        this.songTable = songTable;
    }
}