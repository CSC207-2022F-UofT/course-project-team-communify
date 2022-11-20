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

    public RegisterController(LoginOutputBoundary registerPresenter) {
        this.registerPresenter = registerPresenter;
        this.registerInteractor = new RegisterInteractor(registerPresenter);
    }
    /**
     * function calling the use case for registering a regular user
     */
    public void registerRegular(String username, String password){
        RegisterInputData registerInputData = new RegisterInputData(username, password);
        registerInteractor.register(registerInputData);
    }
}
