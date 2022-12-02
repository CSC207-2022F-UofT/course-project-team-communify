package Controller;

import InputBoundary.LoginInputBoundary;
import InputData.LoginInputData;
import OutputBoundary.LoginOutputBoundary;
import UseCase.Login;


/**
 * Controller for login and register use cases.
 */
public class LoginController {
    LoginInputBoundary loginInteractor;
    LoginOutputBoundary loginPresenter;

    /**
     * @param loginPresenter the presenter to return login info to the view
     */
    public LoginController(LoginOutputBoundary loginPresenter) {
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
        LoginInputData loginInputData = new LoginInputData(username, password, isArtist);
        return loginInteractor.login(loginInputData);
    }
}
