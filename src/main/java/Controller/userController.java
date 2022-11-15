package Controller;

import InputBoundary.loginInputBoundary;
import InputBoundary.RegisterInputBoundary;
import InputData.loginInputData;


/**
 * Controller for login and register use cases.
 */
public class userController {
    private final loginInputBoundary loginInteractor;
    private final RegisterInputBoundary registerInteractor;
    private final loginInputData loginInputData;
    private final loginInputData registerInputData;
    /**
     * Constructor.
     * @param loginInteractor use case interactor for adding a song to the space
     * @param registerInteractor use case interactor for playing the space
     */
    public userController(loginInputBoundary loginInteractor, RegisterInputBoundary registerInteractor,
                          String username, String password, boolean isArtist) {
        this.loginInteractor = loginInteractor;
        this.loginInputData = new loginInputData(username, password, isArtist);
        this.registerInteractor = registerInteractor;
        this.registerInputData = new loginInputData(username, password, isArtist);
    }

    /**
     * function calling the use case for logging in
     */
    public void login(){
        this.loginInteractor.login(this.loginInputData);
    }

    /**
     * function calling the use case for registering a new user
     */
    public void register(){this.registerInteractor.register(this.registerInputData);
    }

}
