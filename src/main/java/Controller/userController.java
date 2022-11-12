package Controller;

import InputBoundary.loginInputBoundary;
import InputData.loginInputData;


/**
 * Controller for login and register use cases.
 */
public class userController {
    final loginInputBoundary loginInteractor, registerInteractor;
    /**
     * Constructor.
     * @param loginInteractor use case interactor for adding a song to the space
     * @param registerInteractor use case interactor for playing the space
     */
    public userController(loginInputBoundary loginInteractor, loginInputBoundary registerInteractor) {
        this.loginInteractor = loginInteractor;
        this.registerInteractor = registerInteractor;
    }

    /**
     * function calling the use case for playing the space
     * @param loginID input data for playing the space
     */
    public void login(loginInputData loginID){
        this.loginInteractor.login(loginID);
    }

    /**
     * function calling the use case for adding a song to the space
     * @param registerID input data for adding a song to the space
     */
    public void register(loginInputData registerID){this.registerInteractor.register(registerID);
    }
   
}
