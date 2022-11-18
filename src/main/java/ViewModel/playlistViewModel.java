package ViewModel;
import Entities.RegularUser;
import Entities.User;
import Entities.Song;
import Presenter.playlistPresenter;
import Controller.newPlaylistController;
import UseCase.CreatePlaylistInteractor;
public class playlistViewModel {
    private playlistPresenter playlistPresenter;
    private String outputMessage;

    private final newPlaylistController controller;

    public playlistViewModel(){
        // get necessary information from View to construct a new playlist
        //TODO: This is the controller, just pass this to the controller, move to controller
        //TODO: Create controller once in the view as an instance variable / pass as a parameter in main

        //Blank output data object to extract success message from
        //sets its presenter to itself
        this.playlistPresenter = new playlistPresenter(this);

        this.controller= new newPlaylistController(new CreatePlaylistInteractor(playlistPresenter));
    }
    public void setOutputMessage(String message){
        this.outputMessage = message;
    }

    public String getOutputMessage(){
        return this.outputMessage;

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
     * @return output message generated by the Controller and update the presenter's outputMessage with it as well
     */
    public String callNewPlaylistUseCase(int id, User user, String playlistName, Song firstSong){
        this.controller.createNewPlaylist(id, (RegularUser) user,playlistName,firstSong);
        String msg = this.playlistPresenter.getOutputMessage();
        return msg;
    }

    public String callNewPlaylistUseCase(int id, User user, String playlistName){
        this.controller.createNewPlaylist(id, (RegularUser) user,playlistName);
        String msg = this.playlistPresenter.getOutputMessage();
        return msg;
    }
}
