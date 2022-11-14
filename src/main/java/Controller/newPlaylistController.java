package Controller;
import InputBoundary.newPlaylistInputBoundary;
import InputData.newPlaylistInputData;

/**
 * Controller-layer implementation for create playlist use case
 */
public class newPlaylistController {
    private final newPlaylistInputBoundary newPlaylistInputBoundary;
    private final newPlaylistInputData newPlaylistInputData;
    public newPlaylistController(newPlaylistInputBoundary newPlaylistInputBoundary,newPlaylistInputData newPlaylistInputData){
        this.newPlaylistInputBoundary = newPlaylistInputBoundary;
        this.newPlaylistInputData = newPlaylistInputData;
    }
    /**
     * Calls newPlaylist use case
     * @return String confirmation of the playlist's creation
     */
    public String createPlaylist(){
        return this.newPlaylistInputBoundary.newPlaylist(this.newPlaylistInputData);
    }
    //TODO: If current version doesnt work roll back changes

//    public String createPlaylist(int id, User owner, String playlistName){
//        newPlaylistInputData newPlaylist = new newPlaylistInputData(id,playlistName,owner);
//        return this.newPlaylistInteractor.newPlaylist(newPlaylist);
//    }
}
