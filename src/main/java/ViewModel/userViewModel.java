package ViewModel;

import Controller.LoginController;
import Presenter.ArtistPresenter;
import Presenter.userPresenter;

public class userViewModel {
    private final LoginController controller;
    private UserDsView currentUser;
    private ArtistUserDsView currentArtistUser;

    public userViewModel(UserDsView user){
        this.controller = new LoginController(new userPresenter(this, user));
    }

    public userViewModel(ArtistUserDsView user){
        this.controller = new LoginController(new ArtistPresenter(this, user));
    }

    public void updateCurrentUser(UserDsView u){
        this.currentUser = u;
    }

    public void updateCurrentUser(ArtistUserDsView u){
        this.currentArtistUser = u;
    }

    public UserDsView getCurrentUser() {
        return currentUser;
    }

    public ArtistUserDsView getCurrentArtistUser() {
        return currentArtistUser;
    }

    public boolean loginAction(String username, String password, boolean isArtist){
        return this.controller.login(username, password, isArtist);
    }


}
