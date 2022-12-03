package ViewModel;
import Controller.EditSongController;
import Controller.GetArtistSongController;
import InputData.UploadSongInputData;
import InputData.GetArtistSongInputData;
import Presenter.EditSongPresenter;
import Presenter.GetArtistSongPresenter;
/**
 * The interface adapters layer view model which acts as a gateway between the view and the artist related
 * parts of the program.
 */
public class ArtistViewModel {

    private ArtistUserDsView currentArtist;
    private final EditSongController editSongController;
    private final GetArtistSongController getArtistSongController;

    private String[][] songTable;
    private boolean isUploaded;

    /**
     * @param currentArtist the artist who is currently loaded in the program
     */
    public ArtistViewModel(ArtistUserDsView currentArtist){
        this.currentArtist = currentArtist;
        this.editSongController = new EditSongController(new EditSongPresenter(this));
        this.getArtistSongController = new GetArtistSongController(new GetArtistSongPresenter(this));
    }

    /**
     * @param filepath Filepath to the desired song.
     * @return true iff song was successfully uploaded.
     */
    public boolean upload(String filepath){
        UploadSongInputData inputdata = new UploadSongInputData(filepath, this.currentArtist.getUsername());
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

    /**
     * @return String[][] of all songs.
     */
    public String[][] getArtistSongs(){
        GetArtistSongInputData inputdata = new GetArtistSongInputData(this.currentArtist.getUsername());
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

    /**
     * @return the name of the artist
     */
    public String getArtistName(){
        return this.currentArtist.getArtistName();
    }
}
