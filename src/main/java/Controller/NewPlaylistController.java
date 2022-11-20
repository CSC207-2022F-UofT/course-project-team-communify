package Controller;
import Entities.RegularUser;
import Entities.Song;
import InputBoundary.NewPlaylistInputBoundary;
import InputData.NewPlaylistInputData;
/**
 * Controller-layer implementation for create playlist use case
 */
public class NewPlaylistController {
    private final NewPlaylistInputBoundary newPlaylistInputBoundary;

    /**
     *
     * @param createPlaylistInteractor interactor object to be passed into controller for use case
     */
    public NewPlaylistController(NewPlaylistInputBoundary createPlaylistInteractor){
        this.newPlaylistInputBoundary = createPlaylistInteractor;
    }
    //TODO: remove uncommented lines later
    //TODO: this is given info via the view

    /**
     * Creates a playlist with one song
     * @param id randomly generated ID to create new playlist with
     * @param user RegularUser retrieved from view
     * @param playlistName name to create playlist with
     * @param firstSong song to create playlist with
     *
     */
    public void createNewPlaylist(int id, RegularUser user, String playlistName, Song firstSong){
        NewPlaylistInputData inputData = new NewPlaylistInputData(id,playlistName,firstSong,user);
        this.newPlaylistInputBoundary.newPlaylist(inputData);
    }

    /**
     * Creates an empty playlist
     * @param id randomly generated ID to create new playlist with
     * @param user RegularUser retrieved from view
     * @param playlistName name to create playlist with
     */
    public void createNewPlaylist(int id, RegularUser user, String playlistName){
        NewPlaylistInputData inputData = new NewPlaylistInputData(id,playlistName,user);
        this.newPlaylistInputBoundary.newPlaylist(inputData);
    }

}
