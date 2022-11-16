package Controller;

import InputBoundary.loginInputBoundary;
import InputBoundary.RegisterArtistInputBoundary;
import InputBoundary.RegisterInputBoundary;
import InputData.RegisterInputData;
import InputData.RegisterArtistInputData;
import InputData.loginInputData;


/**
 * Controller for login and register use cases.
 */
public class RegisterController {
    private final RegisterInputBoundary registerInteractor;
    private final RegisterArtistInputBoundary artistInteractor;
    private final RegisterInputData registerInputData;
    private final RegisterArtistInputData artistInputData;
    /**
     * Constructor.
     * @param registerInteractor use case interactor for creating regular users
     */
    public RegisterController(RegisterInputBoundary registerInteractor, RegisterArtistInputBoundary artistInteractor,
                              String username, String password, String artistName) {
        this.registerInteractor = registerInteractor;
        this.registerInputData = new RegisterInputData(username, password);
        this.artistInteractor = artistInteractor;
        this.artistInputData = new RegisterArtistInputData(username, password, artistName);
    }
    /**
     * function calling the use case for registering a regular user
     */
    public void registerRegular(){this.registerInteractor.register(this.registerInputData);
    }
    /**
     * function calling the use case for registering an artist user
     */
    public void registerArtist(){this.artistInteractor.register(this.artistInputData);
    }

}
