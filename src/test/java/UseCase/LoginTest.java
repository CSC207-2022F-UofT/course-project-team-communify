package UseCase;

import InputData.loginInputData;
import Presenter.userPresenter;
import View.InMemoryUser;
import ViewModel.userViewModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest {
    /**
     * Tests the login success.
     */
    @Test
    public void testRegularSuccess(){
        userViewModel view = new userViewModel(new InMemoryUser());
        Assertions.assertTrue(view.loginAction("User1","Password1", false));
    }
    @Test
    public void testArtistSuccess(){
        loginInputData artist = new loginInputData("admin","admin", true);
        Login login = new Login(new userPresenter(new userViewModel(
                new InMemoryUser()), new InMemoryUser()));
        Assertions.assertTrue(login.login(artist));
    }
    /**
     * Tests the login failure due to invalid password.
     */
    @Test
    public void testInvalidPassword(){
        loginInputData regularUser = new loginInputData("UserRegular","bla", false);
        Login login = new Login(new userPresenter(new userViewModel(
                new InMemoryUser()), new InMemoryUser()));
        Assertions.assertFalse(login.login(regularUser));
    }
    /**
     * Tests the login failure due to invalid credential.
     */
    @Test
    public void testInvalidCredentials(){
        loginInputData regularUser = new loginInputData("","bla", false);
        Login login = new Login(new userPresenter(new userViewModel(
                new InMemoryUser()), new InMemoryUser()));
        Assertions.assertFalse(login.login(regularUser));
    }
}
