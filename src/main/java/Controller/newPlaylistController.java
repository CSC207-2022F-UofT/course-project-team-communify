package Controller;
import InputBoundary.newPlaylistInputBoundary;
import InputData.newPlaylistInputData;
import Entities.User;
import Entities.Song;
import Presenter.playlistPresenter;

/**
 * Controller-layer implementation for create playlist use case
 */
public class newPlaylistController {
    private final newPlaylistInputBoundary newPlaylistInteractor;
    private final playlistPresenter playlistPresenter;

    public newPlaylistController(newPlaylistInputBoundary newPlaylistInteractor, playlistPresenter playlistPresenter){
        this.newPlaylistInteractor = newPlaylistInteractor;
        this.playlistPresenter = playlistPresenter;
    }
    /**
     * Calls newPlaylist use case
     */
    public String createPlaylist(newPlaylistInputData newPlaylistInputData){
        return this.newPlaylistInteractor.newPlaylist(newPlaylistInputData);
    }

//    public String createPlaylist(int id, User owner, String playlistName){
//        newPlaylistInputData newPlaylist = new newPlaylistInputData(id,playlistName,owner);
//        return this.newPlaylistInteractor.newPlaylist(newPlaylist);
//    }
}
