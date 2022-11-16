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


    //TODO: Removed presenter parameter because I realized that the playlist controller is already initialized with it's
    // own presenter object that was set in the view model
    public void createNewPlaylist(){
        //TODO: Assuming this section functions like createPlaylist object w/ input data
        // and setting the presenter's output message to the confirmation stored in aforementioned object
        // which is accessed by showConfirmation()
        this.newPlaylistInputBoundary.newPlaylist(this.newPlaylistInputData);
//        presenter.setOutputMessage(this.newPlaylistInputBoundary.showConfirmation());
//        presenter.setOutputMessage(presenter.getOutputMessage());
    }


//    public String createPlaylist(int id, User owner, String playlistName){
//        newPlaylistInputData newPlaylist = new newPlaylistInputData(id,playlistName,owner);
//        return this.newPlaylistInteractor.newPlaylist(newPlaylist);
//    }
}
