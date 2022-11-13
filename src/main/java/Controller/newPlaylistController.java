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
    private final newPlaylistInputData newPlaylistInputData;
    private final playlistPresenter playlistPresenter;
    //TODO: Take out presenter later probably ?
    public newPlaylistController(newPlaylistInputBoundary newPlaylistInteractor, playlistPresenter playlistPresenter, newPlaylistInputData newPlaylistInputData){
        this.newPlaylistInteractor = newPlaylistInteractor;
        this.playlistPresenter = playlistPresenter;
        this.newPlaylistInputData = newPlaylistInputData;
    }
    /**
     * Calls newPlaylist use case
     */
    public void createPlaylist(){
        this.newPlaylistInteractor.newPlaylist(this.newPlaylistInputData);
    }
    //TODO: If current version doesnt work roll back changes

//    public String createPlaylist(int id, User owner, String playlistName){
//        newPlaylistInputData newPlaylist = new newPlaylistInputData(id,playlistName,owner);
//        return this.newPlaylistInteractor.newPlaylist(newPlaylist);
//    }
}
