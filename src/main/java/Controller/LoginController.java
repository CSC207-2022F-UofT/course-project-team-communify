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

    public LoginController(loginOutputBoundary loginPresenter) {
        this.loginPresenter = loginPresenter;
        this.loginInteractor = new Login(loginPresenter);
    }
    /**
     * function calling the use case for logging in
     */
    public boolean login(String username, String password, boolean isArtist){
        loginInputData loginInputData = new loginInputData(username, password, isArtist);
        return loginInteractor.login(loginInputData);
    }
}
