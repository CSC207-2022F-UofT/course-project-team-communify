package ViewModel;
import Controller.EditSongController;
import InputData.RemoveSongInputData;
import InputData.UploadSongInputData;
import Presenter.EditSongPresenter;

public class EditSongViewModel {

    private final EditSongController editSongController;

    private String[][] songTable;
    public boolean isUploaded;
    private boolean isDeleted;

    public EditSongViewModel(){
        this.editSongController = new EditSongController(new EditSongPresenter(this));
    }


    public String[][] getArtistSongs(String user){
        return this.songTable;
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

    public boolean delete(int id){
        RemoveSongInputData inputdata = new RemoveSongInputData(id);
        this.editSongController.delete(inputdata);
        return this.isDeleted;
    }

//    /**
//     * Updates String[][] to all songs artist has uploaded.
//     * @param songTable String[][] of all songs artist has uploaded.
//     */
//    public void updateSongTable(String[][] songTable){
//        this.songTable = songTable;
//    }

    /**
     * Updates isUploaded to whether a song was successfully uploaded.
     * @param isUploaded true iff a song was successfully uploaded.
     */
    public void updateIsUploaded(boolean isUploaded){
        this.isUploaded = isUploaded;
    }

    /**
     * Updates isDeleted to whether a song was successfully deleted.
     * @param isDeleted true iff a song was successfully deleted.
     */
    public void updateIsDeleted(boolean isDeleted){
        this.isDeleted = isDeleted;
    }

}
