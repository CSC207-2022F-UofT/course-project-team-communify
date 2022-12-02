package UseCase;

import Database.userList;
import InputData.RegisterArtistInputData;
import Presenter.userPresenter;
import View.InMemoryUser;
import ViewModel.userViewModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

public class RegisterArtistInteractorTest {
    /**
     * Tests the register success.
     */
    @Test
    public void testRegularSuccess(){
        String username = "user" + ThreadLocalRandom.current().nextInt(0, 99999);
        String password = "password" + ThreadLocalRandom.current().nextInt(0, 99999);
        String artistName = "artist" + ThreadLocalRandom.current().nextInt(0, 99999);
        RegisterArtistInputData artist = new RegisterArtistInputData(username,password, artistName);
        RegisterArtistInteractor registerInteractor = new RegisterArtistInteractor(new userPresenter(new userViewModel(
                new InMemoryUser()), new InMemoryUser()));
        if (userList.getInstance().exists(username))
            Assertions.assertFalse(registerInteractor.register(artist));
        else
            Assertions.assertTrue(registerInteractor.register(artist));
    }
    /**
     * Tests the register failure due to invalid credential.
     */
    @Test
    public void testRegularFailure(){
        RegisterArtistInputData regularUser = new RegisterArtistInputData("","bla","artist");
        RegisterArtistInteractor registerInteractor = new RegisterArtistInteractor(new userPresenter(new userViewModel(
                new InMemoryUser()), new InMemoryUser()));
        Assertions.assertFalse(registerInteractor.register(regularUser));
    }
    /**
     * Tests the register failure due to user existed.
     */
    @Test
    public void testUserExist(){
        RegisterArtistInputData artist = new RegisterArtistInputData("admin","bla","admin");
        RegisterArtistInteractor registerInteractor = new RegisterArtistInteractor(new userPresenter(new userViewModel(
                new InMemoryUser()), new InMemoryUser()));
        Assertions.assertFalse(registerInteractor.register(artist));
    }
}
