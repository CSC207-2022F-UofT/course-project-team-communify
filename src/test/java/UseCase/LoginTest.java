package UseCase;

import InputData.LoginInputData;
import Presenter.UserPresenter;
import View.InMemoryUser;
import ViewModel.UserViewModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest {
    /**
     * Tests the login success.
     */
    @Test
    public void testRegularSuccess(){
        UserViewModel view = new UserViewModel(new InMemoryUser());
        Assertions.assertTrue(view.loginAction("User1","Password1", false));
    }
    @Test
    public void testArtistSuccess(){
        LoginInputData artist = new LoginInputData("admin","admin", true);
        Login login = new Login(new UserPresenter(new UserViewModel(
                new InMemoryUser()), new InMemoryUser()));
        Assertions.assertTrue(login.login(artist));
    }
    /**
     * Tests the login failure due to invalid password.
     */
    @Test
    public void testInvalidPassword(){
        LoginInputData regularUser = new LoginInputData("UserRegular","bla", false);
        Login login = new Login(new UserPresenter(new UserViewModel(
                new InMemoryUser()), new InMemoryUser()));
        Assertions.assertFalse(login.login(regularUser));
    }
    /**
     * Tests the login failure due to invalid credential.
     */
    @Test
    public void testInvalidCredentials(){
        LoginInputData regularUser = new LoginInputData("","bla", false);
        Login login = new Login(new UserPresenter(new UserViewModel(
                new InMemoryUser()), new InMemoryUser()));
        Assertions.assertFalse(login.login(regularUser));
    }
}
