package viewModel;

import controller.LoginController;
import controller.RegisterArtistController;
import controller.RegisterController;
import presenter.ArtistPresenter;
import presenter.UserPresenter;
/**
 * The interface adapters layer view model which acts as a gateway between the view and the user related
 * parts of the program.
 */
public class UserViewModel {
    private final LoginController controller;
    private RegisterController registerController;
    private RegisterArtistController registerArtistController;
    private UserDsView currentUser;
    private ArtistUserDsView currentArtistUser;

    /**
     * @param user the user logged in to the program
     */
    public UserViewModel(UserDsView user){
        this.controller = new LoginController(new UserPresenter(this, user));
        this.registerController = new RegisterController(new UserPresenter(this, user));
    }

    /**
     * @param user the artist logged in to the program
     */
    public UserViewModel(ArtistUserDsView user){
        this.controller = new LoginController(new ArtistPresenter(this, user));
        this.registerArtistController = new RegisterArtistController(new ArtistPresenter(this, user));
    }

    /**
     * @param u the newly logged-in user
     */
    public void updateCurrentUser(UserDsView u){
        this.currentUser = u;
    }

    /**
     * @param u the newly logged-in artist
     */
    public void updateCurrentUser(ArtistUserDsView u){
        this.currentArtistUser = u;
    }

    /**
     * @return the logged-in user
     */
    public UserDsView getCurrentUser() {
        return currentUser;
    }

    /**
     * @return the logged-in artist
     */
    public ArtistUserDsView getCurrentArtistUser() {
        return currentArtistUser;
    }

    /**
     * @param username the username of the user
     * @param password the password of the user
     * @param isArtist if the user is an artist
     * @return if the login was successful
     */
    public boolean loginAction(String username, String password, boolean isArtist){
        return this.controller.login(username, password, isArtist);
    }

    /**
     * @param username the username of the user
     * @param password the password of the user
     * @param isArtist if the user is an artist
     * @param artistName the name of the artist
     * @return if the register was successful
     */
    public boolean registerAction(String username, String password, boolean isArtist, String artistName){
        if (isArtist)
            return this.registerArtistController.registerArtist(username, artistName, password);
        else
            return this.registerController.registerRegular(username, password);
    }


}
