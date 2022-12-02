package Controller;
import InputBoundary.NewPlaylistInputBoundary;
import InputData.NewPlaylistInputData;
import ViewModel.PlaylistDsView;
import ViewModel.UserDsView;

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
    /**
     * Creates a playlist with one song
     * @param user RegularUser retrieved from view
     * @param playlistName name to create playlist with
     * @param firstSongID song to create playlist with
     * @return the new playlist in a view layer DS
     */
    public PlaylistDsView createNewPlaylist(UserDsView user, String playlistName, int firstSongID){
        NewPlaylistInputData inputData = new NewPlaylistInputData(playlistName, firstSongID, user.getUsername());
        PlaylistDsView newPlaylist = user.getNewPlaylist();
        this.newPlaylistInputBoundary.newPlaylist(inputData);
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
        NewPlaylistInputData inputData = new NewPlaylistInputData(playlistName, user.getUsername());
        PlaylistDsView newPlaylist = user.getNewPlaylist();
        newPlaylist.setName(playlistName);
        newPlaylist.setId(inputData.getId());
        this.newPlaylistInputBoundary.newPlaylist(inputData);
        return newPlaylist;
    }

}
