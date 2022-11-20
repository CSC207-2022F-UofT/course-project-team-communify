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

    public LoginController(LoginOutputBoundary loginPresenter) {
        this.loginPresenter = loginPresenter;
        this.loginInteractor = new Login(loginPresenter);
    }
    /**
     * function calling the use case for logging in
     */
    public void login(String username, String password, boolean isArtist){
        LoginInputData loginInputData = new LoginInputData(username, password, isArtist);
        loginInteractor.login(loginInputData);
    }
}
