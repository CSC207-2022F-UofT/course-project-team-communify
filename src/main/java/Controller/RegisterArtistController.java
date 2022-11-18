package Controller;

import InputBoundary.RegisterArtistInputBoundary;
import InputData.RegisterArtistInputData;
import InputData.RegisterInputData;
import OutputBoundary.loginOutputBoundary;

/**
 * Controller for login and register use cases.
 */
public class RegisterArtistController {
    RegisterArtistInputBoundary registerInteractor;

    public RegisterArtistController(RegisterArtistInputBoundary registerInteractor) {
        this.registerInteractor = registerInteractor;
    }
    /**
     * function calling the use case for registering a regular user
     */
    public void registerArtist(String username, String artistName, String password){
        RegisterArtistInputData registerInputData = new RegisterArtistInputData(artistName, username, password);
        registerInteractor.register(registerInputData);
    }
}
