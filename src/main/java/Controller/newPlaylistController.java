package Controller;
import InputBoundary.newPlaylistInputBoundary;
import InputData.newPlaylistInputData;
import UseCase.createPlaylist;
import Presenter.playlistPresenter;

/**
 * Controller-layer implementation for create playlist use case
 */
public class newPlaylistController {
    private final newPlaylistInputBoundary newPlaylistInputBoundary;
    private final newPlaylistInputData newPlaylistInputData;
    private createPlaylist createPlaylist;

    public newPlaylistController(newPlaylistInputData newPlaylistInputData, playlistPresenter presenter){
        this.createPlaylist = new createPlaylist(presenter);
        this.newPlaylistInputBoundary = createPlaylist;
        this.newPlaylistInputData = newPlaylistInputData;
    }
    /**
     * @param presenter presenter object to store output message in
     * @return String confirmation of the playlist's creation
     */
    public void createNewPlaylist(playlistPresenter presenter){
        //TODO: Assuming this section functions like createPlaylist object w/ input data
        // and setting the presenter's output message to the confirmation stored in aforementioned object
        // which is accessed by showConfirmation()
        this.newPlaylistInputBoundary.newPlaylist(this.newPlaylistInputData);
        presenter.setOutputMessage(this.newPlaylistInputBoundary.showConfirmation());
    }

//    public String createPlaylist(int id, User owner, String playlistName){
//        newPlaylistInputData newPlaylist = new newPlaylistInputData(id,playlistName,owner);
//        return this.newPlaylistInteractor.newPlaylist(newPlaylist);
//    }
}
