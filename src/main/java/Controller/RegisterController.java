package Controller;

import InputBoundary.RegisterInputBoundary;
import OutputBoundary.LoginOutputBoundary;
import InputData.RegisterInputData;
import UseCase.RegisterInteractor;


/**
 * Controller for register use cases.
 */
public class RegisterController {
    RegisterInputBoundary registerInteractor;
    LoginOutputBoundary registerPresenter;

    /**
     * @param registerPresenter the presenter for register output data
     */
    public RegisterController(LoginOutputBoundary registerPresenter) {
        this.registerPresenter = registerPresenter;
        this.registerInteractor = new RegisterInteractor(registerPresenter);
    }

    /**
     * function calling the use case for registering a regular user
     * @param username the username of the user
     * @param password the password of the user
     * @return true if and only if the register is successful
     */
    public boolean registerRegular(String username, String password){
        RegisterInputData registerInputData = new RegisterInputData(username, password);
        return registerInteractor.register(registerInputData);
    }
}
