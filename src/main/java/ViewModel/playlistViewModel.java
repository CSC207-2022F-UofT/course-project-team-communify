package ViewModel;

import Controller.EditPlaylistController;
import Controller.newPlaylistController;
import Entities.Song;
import Presenter.playlistPresenter;
import UseCase.CreatePlaylistInteractor;
import UseCase.EditPlaylistInteractor;
import View.InMemoryUser;

/**
 * The interface adapters layer view model which acts as a gateway between the view and the playlist related
 * parts of the program.
 */
public class playlistViewModel {
    private final playlistPresenter playlistPresenter;

    private final newPlaylistController newPlaylistController;

    private final EditPlaylistController editPlaylistController;

    private PlaylistDsView currPlaylist;

    /**
     * Constructor.
     */
    public playlistViewModel(){
        // get necessary information from View to construct a new playlist
        //TODO: This is the controller, just pass this to the controller, move to controller
        //TODO: Create controller once in the view as an instance variable / pass as a parameter in main

        //Blank output data object to extract success message from
        //sets its presenter to itself
        this.playlistPresenter = new playlistPresenter(this, new InMemoryUser());

        this.newPlaylistController = new newPlaylistController(new CreatePlaylistInteractor(playlistPresenter));

        this.editPlaylistController = new EditPlaylistController(new EditPlaylistInteractor(playlistPresenter));
    }

    /**
     * @param message the message to be outputted to the view
     */
    public void setOutputMessage(String message){
    }

    //TODO: keeping this uncommented just in case I may need it later, but will delete in a future push
//    /**
//     *
//     * @param id ID given by view
//     * @param user User object given by view
//     * @param playlistName playlist name given by view
//     *  Overloaded method for creating an empty playlist
//     */
//    public playlistViewModel(int id, RegularUser user, String playlistName){
//        // get necessary information from View to construct a new playlist
//        newPlaylistInputData inputData = new newPlaylistInputData(id,playlistName,user);
//        //Blank output data object to extract success message from
//        this.playlistPresenter = new playlistPresenter(this);
////        this.newPlaylistController = new newPlaylistController(inputData,playlistPresenter);
//    }

    /**
     * @param user the owner of the playlist
     * @param playlistName the name of the playlist
     * @param firstSongID the first song in the playlist
     * @return output message generated by the Controller and update the presenter's outputMessage with it as well
     */

    public String callNewPlaylistUseCase(UserDsView user, String playlistName, int firstSongID){
        this.currPlaylist = this.newPlaylistController.createNewPlaylist(user,playlistName,firstSongID);
        return this.playlistPresenter.getOutputMessage();
    }

    /**
     * @param user the owner of the playlist
     * @param playlistName the name of the playlist
     * @return output message generated by the Controller and update the presenter's outputMessage with it as well
     */
    public String callNewPlaylistUseCase(UserDsView user, String playlistName){
        this.currPlaylist = this.newPlaylistController.createNewPlaylist(user,playlistName);
        return this.playlistPresenter.getOutputMessage();
    }

    /**
     * @param user the owner of the playlist
     * @param playlist the playlist to edit
     * @param song the song to edit the playlist with
     * @return confirmation message
     */
    public String callAddSong(UserDsView user, PlaylistDsView playlist, int song){
        this.editPlaylistController.addSong(user,playlist,song);
        return this.playlistPresenter.getOutputMessage();
    }

    /**
     * @param user the owner of the playlist
     * @param playlist the playlist to edit
     * @param song the song to edit the playlist with
     * @return confirmation message
     */
    public String callRemoveSong(UserDsView user, PlaylistDsView playlist, int song){
        this.editPlaylistController.removeSong(user,playlist,song);
        return this.playlistPresenter.getOutputMessage();
    }

    /**
     * @return the newest playlist
     */
    public PlaylistDsView getCurrPlaylist() {
        return currPlaylist;
    }

    /**
     * @param p the newest playlist
     */
    public void setCurrPlaylist(PlaylistDsView p){
        this.currPlaylist = p;
    }

}
