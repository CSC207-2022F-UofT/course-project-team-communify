package Controller;

import InputBoundary.RegisterArtistInputBoundary;
import InputData.RegisterArtistInputData;
import OutputBoundary.loginOutputBoundary;
import UseCase.RegisterArtistInteractor;

/**
 * Controller for login and register use cases.
 */
public class RegisterArtistController {
    RegisterArtistInputBoundary registerInteractor;
    loginOutputBoundary registerPresenter;

    public RegisterArtistController(loginOutputBoundary registerPresenter) {
        this.registerPresenter = registerPresenter;
        this.registerInteractor = new RegisterArtistInteractor(registerPresenter);
    }
    /**
     * function calling the use case for registering a regular user
     */
    public boolean registerArtist(String username, String artistName, String password){
        RegisterArtistInputData registerInputData = new RegisterArtistInputData(artistName, username, password);
        return registerInteractor.register(registerInputData);
    }
}
