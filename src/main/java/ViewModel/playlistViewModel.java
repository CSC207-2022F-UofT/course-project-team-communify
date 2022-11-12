package ViewModel;
import Controller.newPlaylistController;
import InputBoundary.newPlaylistInputBoundary;
import InputData.newPlaylistInputData;
import UseCase.createPlaylist;


import Presenter.playlistPresenter;
public class playlistViewModel {
    private final newPlaylistController newPlaylistController;
    private final playlistPresenter playlistPresenter;

    public playlistViewModel(){
        this.playlistPresenter = new playlistPresenter();
        newPlaylistInputBoundary newPlaylistInputBoundary = new createPlaylist();
        this.newPlaylistController = new newPlaylistController(newPlaylistInputBoundary, this.playlistPresenter);
    }

    public String callNewPlaylist(newPlaylistInputData newPlaylistInputData){
        return this.newPlaylistController.createPlaylist(newPlaylistInputData);
    }

    //TODO: Add edit playlist Controller later
}
