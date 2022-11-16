package Controller;
import Entities.RegularUser;
import Entities.Song;
import InputBoundary.newPlaylistInputBoundary;
import InputData.newPlaylistInputData;
import UseCase.CreatePlaylistInteractor;
import Presenter.playlistPresenter;

/**
 * Controller-layer implementation for create playlist use case
 */
public class newPlaylistController {
    private final newPlaylistInputBoundary newPlaylistInputBoundary;

//    private final newPlaylistInputData newPlaylistInputData;
//
//    private CreatePlaylistInteractor createPlaylist;

    public newPlaylistController(CreatePlaylistInteractor createPlaylist){
//        this.createPlaylist = createPlaylist;
        this.newPlaylistInputBoundary = createPlaylist;
//        this.newPlaylistInputData = newPlaylistInputData;
    }
    //TODO: remove uncommented lines later


    //TODO: this is given info via the view
    public void createNewPlaylist(int id, RegularUser user, String playlistName, Song firstSong){

        newPlaylistInputData inputData = new newPlaylistInputData(id,playlistName,firstSong,user);
        //TODO: Move input data here
        //TODO: Assuming this section functions like createPlaylist object w/ input data
        // and setting the presenter's output message to the confirmation stored in aforementioned object
        // which is accessed by showConfirmation()
        this.newPlaylistInputBoundary.newPlaylist(inputData);
    }
    public void createNewPlaylist(int id, RegularUser user, String playlistName){
        newPlaylistInputData inputData = new newPlaylistInputData(id,playlistName,user);
        this.newPlaylistInputBoundary.newPlaylist(inputData);
    }



//    public String createPlaylist(int id, User owner, String playlistName){
//        newPlaylistInputData newPlaylist = new newPlaylistInputData(id,playlistName,owner);
//        return this.newPlaylistInteractor.newPlaylist(newPlaylist);
//    }
}
