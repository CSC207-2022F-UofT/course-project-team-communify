package Controller;

import InputBoundary.RegisterInputBoundary;
import InputData.RegisterInputData;


/**
 * Controller for register use cases.
 */
public class RegisterController {
    RegisterInputBoundary registerInteractor;

    public RegisterController(RegisterInputBoundary registerInteractor) {
        this.registerInteractor = registerInteractor;
    }
    /**
     * function calling the use case for registering a regular user
     */
    public void registerRegular(String username, String password){
        RegisterInputData registerInputData = new RegisterInputData(username, password);
        registerInteractor.register(registerInputData);
    }
}
