package Controller;
import Entities.Song;
import InputBoundary.newPlaylistInputBoundary;
import InputData.newPlaylistInputData;
import ViewModel.PlaylistDsView;
import ViewModel.UserDsView;

/**
 * Controller-layer implementation for create playlist use case
 */
public class newPlaylistController {
    private final newPlaylistInputBoundary newPlaylistInputBoundary;

    /**
     *
     * @param createPlaylistInteractor interactor object to be passed into controller for use case
     */
    public newPlaylistController(newPlaylistInputBoundary createPlaylistInteractor){
        this.newPlaylistInputBoundary = createPlaylistInteractor;
    }
    //TODO: remove uncommented lines later
    //TODO: this is given info via the view

    /**
     * Creates a playlist with one song
     * @param user RegularUser retrieved from view
     * @param playlistName name to create playlist with
     * @param firstSongID song to create playlist with
     * @return the new playlist in a view layer DS
     */
    public PlaylistDsView createNewPlaylist(UserDsView user, String playlistName, int firstSongID){
        newPlaylistInputData inputData = new newPlaylistInputData(playlistName, firstSongID, user.getUsername());
        PlaylistDsView newPlaylist = user.getNewPlaylist();
        newPlaylist.setName(playlistName);
        newPlaylist.setId(inputData.getId());
        return newPlaylist;
    }

    /**
     * Creates an empty playlist
     * @param user RegularUser retrieved from view
     * @param playlistName name to create playlist with
     * @return the new playlist in a view layer DS
     */
    public PlaylistDsView createNewPlaylist(UserDsView user, String playlistName){
        newPlaylistInputData inputData = new newPlaylistInputData(playlistName, user.getUsername());
        PlaylistDsView newPlaylist = user.getNewPlaylist();
        newPlaylist.setName(playlistName);
        newPlaylist.setId(inputData.getId());
        this.newPlaylistInputBoundary.newPlaylist(inputData);
        return newPlaylist;
    }

}
