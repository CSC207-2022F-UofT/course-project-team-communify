package ViewModel;

import Controller.EditPlaylistController;
import Controller.NewPlaylistController;
import Presenter.PlaylistPresenter;
import UseCase.CreatePlaylistInteractor;
import UseCase.EditPlaylistInteractor;
import View.InMemoryUser;

/**
 * The interface adapters layer view model which acts as a gateway between the view and the playlist related
 * parts of the program.
 */
public class PlaylistViewModel {
    private final PlaylistPresenter playlistPresenter;

    private final NewPlaylistController newPlaylistController;

    private final EditPlaylistController editPlaylistController;

    private PlaylistDsView currPlaylist;

    private String message;

    /**
     * Constructor.
     */
    public PlaylistViewModel(){
        // get necessary information from View to construct a new playlist
        //TODO: This is the controller, just pass this to the controller, move to controller
        //TODO: Create controller once in the view as an instance variable / pass as a parameter in main

        //Blank output data object to extract success message from
        //sets its presenter to itself
        this.playlistPresenter = new PlaylistPresenter(this, new InMemoryUser());

        this.newPlaylistController = new NewPlaylistController(new CreatePlaylistInteractor(playlistPresenter));

        this.editPlaylistController = new EditPlaylistController(new EditPlaylistInteractor(playlistPresenter));
        this.message = "";
    }

    /**
     * @param message the message to be outputted to the view
     */
    public void setOutputMessage(String message){
        this.message = message;
    }
    public String returnOutputMessage(){
        return this.message;
    }


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
    public String callNewEmptyPlaylistUseCase(UserDsView user, String playlistName){
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
    public String callRemoveSong(UserDsView user, int playlist, int song){
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