package Controller;
import InputBoundary.newPlaylistInputBoundary;
import InputData.newPlaylistInputData;
import Entities.User;
import Entities.Song;

/**
 * Controller-layer implementation for create playlist use case
 */
public class newPlaylistController {
    private final newPlaylistInputBoundary newPlaylistInteractor;

    public newPlaylistController(newPlaylistInputBoundary newPlaylistInteractor){
        this.newPlaylistInteractor = newPlaylistInteractor;
    }
    /**
     *
     * @param id Assign a unique ID to this playlist
     * @param owner Assign an Owner to this playlist
     * @param playlistName Assign a name to this playlist
     * @return String confirmation of the playlist's creation and addition to playlist database
     */
    public String createPlaylist(int id, User owner, String playlistName){
        newPlaylistInputData newPlaylist = new newPlaylistInputData(id,playlistName,owner);
        return this.newPlaylistInteractor.newPlaylist(newPlaylist);
    }

    /**
     *
     * @param id Assign a unique ID to this playlist
     * @param owner Assign an Owner to this playlist
     * @param playlistName Assign a name to this playlist
     * @param firstSong Create a new playlist with a singular song
     * @return String confirmation of the playlist's creation and addition to playlist database
     */
    public String createPlaylist(int id, User owner, String playlistName, Song firstSong){
        newPlaylistInputData newPlaylist = new newPlaylistInputData(id,playlistName,firstSong,owner);
        return this.newPlaylistInteractor.newPlaylist(newPlaylist);
    }
}
