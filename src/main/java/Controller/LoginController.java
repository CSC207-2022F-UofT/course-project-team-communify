package Controller;

import InputBoundary.loginInputBoundary;
import InputData.loginInputData;
import OutputBoundary.loginOutputBoundary;
import UseCase.Login;


/**
 * Controller for login and register use cases.
 */
public class LoginController {
    loginInputBoundary loginInteractor;
    loginOutputBoundary loginPresenter;

    /**
     * @param loginPresenter the presenter to return login info to the view
     */
    public LoginController(loginOutputBoundary loginPresenter) {
        this.loginPresenter = loginPresenter;
        this.loginInteractor = new Login(loginPresenter);
    }

    /**
     * function calling the use case for logging in
     * @param username the username of the user
     * @param password the password of the user
     * @param isArtist whether the user is an artist
     * @return true if and only if the login occurs
     */
    public boolean login(String username, String password, boolean isArtist){
        loginInputData loginInputData = new loginInputData(username, password, isArtist);
        return loginInteractor.login(loginInputData);
    }
}
