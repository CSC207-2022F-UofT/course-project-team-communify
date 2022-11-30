package Controller;

import Presenter.userPresenter;
import View.InMemoryUser;
import ViewModel.userViewModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginControllerTest {
    /**
     * Tests the login failure due to user existed as a regular user.
     */
    @Test
    public void testloginExistantRegular(){
        LoginController loginController = new LoginController(new userPresenter(new userViewModel(
                new InMemoryUser()), new InMemoryUser()));
        Assertions.assertFalse(loginController.login("User1","Password1",true));
    }
    /**
     * Tests the login failure due to user existed as a artist user.
     */
    @Test
    public void testloginExistantArtist(){
        LoginController loginController = new LoginController(new userPresenter(new userViewModel(
                new InMemoryUser()), new InMemoryUser()));
        Assertions.assertFalse(loginController.login("admin","admin",false));
    }
}
