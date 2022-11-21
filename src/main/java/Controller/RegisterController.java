package Controller;

import InputBoundary.RegisterInputBoundary;
import OutputBoundary.loginOutputBoundary;
import InputData.RegisterInputData;
import UseCase.RegisterInteractor;


/**
 * Controller for register use cases.
 */
public class RegisterController {
    RegisterInputBoundary registerInteractor;
    loginOutputBoundary registerPresenter;

    public RegisterController(loginOutputBoundary registerPresenter) {
        this.registerPresenter = registerPresenter;
        this.registerInteractor = new RegisterInteractor(registerPresenter);
    }
    /**
     * function calling the use case for registering a regular user
     */
    public boolean registerRegular(String username, String password){
        RegisterInputData registerInputData = new RegisterInputData(username, password);
        return registerInteractor.register(registerInputData);
    }
}
