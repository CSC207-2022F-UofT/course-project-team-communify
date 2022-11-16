package ViewModel;
import Controller.newPlaylistController;
import Entities.RegularUser;
import Entities.Song;
import InputData.newPlaylistInputData;
import OutputData.newPlaylistOutputData;


import Presenter.playlistPresenter;
public class playlistViewModel {
    private final newPlaylistController newPlaylistController;
    private  playlistPresenter playlistPresenter;

    /**
     *
     * @param id ID given by view
     * @param user User object given by view
     * @param playlistName playlist name given by view
     * @param firstSong song object given by view
     */
    public playlistViewModel(int id, RegularUser user, String playlistName, Song firstSong){
        // get necessary information from View to construct a new playlist
        newPlaylistInputData inputData = new newPlaylistInputData(id,playlistName,firstSong,user);
        //Blank output data object to extract success message from
        newPlaylistOutputData outputData = new newPlaylistOutputData("");
        //sets its presenter to itself
        this.playlistPresenter = new playlistPresenter(this);
//        newPlaylistInputBoundary newPlaylistInputBoundary = InputBoundary.newPlaylistInputBoundary;
        this.newPlaylistController = new newPlaylistController(inputData,playlistPresenter);
    }
    /**
     *
     * @param id ID given by view
     * @param user User object given by view
     * @param playlistName playlist name given by view
     *  Overloaded method for creating an empty playlist
     */
    public playlistViewModel(int id, RegularUser user, String playlistName){
        // get necessary information from View to construct a new playlist
        newPlaylistInputData inputData = new newPlaylistInputData(id,playlistName,user);
        //Blank output data object to extract success message from
        newPlaylistOutputData outputData = new newPlaylistOutputData("");
        this.playlistPresenter = new playlistPresenter(this);
        this.newPlaylistController = new newPlaylistController(inputData,playlistPresenter);
    }

    /**
     * @return output message generated by the Controller and update the presenter's outputMessage with it as well
     */
    public String callNewPlaylistUseCase(){
        this.newPlaylistController.createNewPlaylist();
        String msg = this.playlistPresenter.getOutputMessage();
        return msg;
    }
}
