package Controller;

import InputBoundary.loginInputBoundary;
import InputData.loginInputData;


/**
 * Controller for login and register use cases.
 */
public class LoginController {
    loginInputBoundary loginInteractor;
    /**
     * Constructor.
     * @param loginInteractor use case interactor for user logging in
     */
    public LoginController(loginInputBoundary loginInteractor) {
        this.loginInteractor = loginInteractor;
    }
    /**
     * function calling the use case for logging in
     */
    public void login(String username, String password, boolean isArtist){
        loginInputData loginInputData = new loginInputData(username, password, isArtist);
        loginInteractor.login(loginInputData);
    }
}
