package controller;

import inputBoundary.RegisterArtistInputBoundary;
import inputData.RegisterArtistInputData;
import outputBoundary.LoginOutputBoundary;
import useCase.RegisterArtistInteractor;

/**
 * Controller for login and register use cases.
 */
public class RegisterArtistController {
    final RegisterArtistInputBoundary registerInteractor;

    /**
     * @param registerPresenter the presenter for register output data
     */
    public RegisterArtistController(LoginOutputBoundary registerPresenter) {
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
