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

    /**
     * @param registerPresenter the presenter for register output data
     */
    public RegisterArtistController(loginOutputBoundary registerPresenter) {
        this.registerPresenter = registerPresenter;
        this.registerInteractor = new RegisterArtistInteractor(registerPresenter);
    }
    /**
     * function calling the use case for registering a regular user
     * @param username the username of the artist
     * @param artistName the name of the artist
     * @param password the password of the artist
     * @return if the register was successful
     */
    public boolean registerArtist(String username, String artistName, String password){
        RegisterArtistInputData registerInputData = new RegisterArtistInputData(username, password, artistName);
        return registerInteractor.register(registerInputData);
    }
}
