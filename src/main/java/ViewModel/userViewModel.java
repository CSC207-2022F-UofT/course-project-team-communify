package ViewModel;

import Controller.LoginController;
import Presenter.userPresenter;

public class userViewModel {
    private final LoginController controller;
    private UserDsView currentUser;

    public userViewModel(UserDsView user){
        this.controller = new LoginController(new userPresenter(this, user));
    }

    public void updateCurrentUser(UserDsView u){
        this.currentUser = u;
    }

    public UserDsView getCurrentUser() {
        return currentUser;
    }

    public boolean loginAction(String username, String password, boolean isArtist){
        return this.controller.login(username, password, isArtist);
    }


}
