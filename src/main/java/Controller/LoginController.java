package Controller;

import InputBoundary.loginInputBoundary;
import InputData.loginInputData;


/**
 * Controller for login and register use cases.
 */
public class LoginController {
    private final loginInputBoundary loginInteractor;
    private final loginInputData loginInputData;
    /**
     * Constructor.
     * @param loginInteractor use case interactor for user logging in
     */
    public LoginController(loginInputBoundary loginInteractor, String username, String password, boolean isArtist) {
        this.loginInteractor = loginInteractor;
        this.loginInputData = new loginInputData(username, password, isArtist);
    }
    /**
     * function calling the use case for logging in
     */
    public void login(){
        this.loginInteractor.login(this.loginInputData);
    }
}
