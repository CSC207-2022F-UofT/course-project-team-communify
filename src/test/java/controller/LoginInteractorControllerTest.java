package controller;

import presenter.UserPresenter;
import view.InMemoryUser;
import viewModel.UserViewModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * tests the login controller
 */
public class LoginInteractorControllerTest {
    /**
     * Tests the login failure due to user existed as a regular user.
     */
    @Test
    public void testLoginExistentRegular(){
        LoginController loginController = new LoginController(new UserPresenter(new UserViewModel(
                new InMemoryUser()), new InMemoryUser()));
        Assertions.assertFalse(loginController.login("User1","Password1",true));
    }
    /**
     * Tests the login failure due to user existed as an artist user.
     */
    @Test
    public void testLoginExistentArtist(){
        LoginController loginController = new LoginController(new UserPresenter(new UserViewModel(
                new InMemoryUser()), new InMemoryUser()));
        Assertions.assertFalse(loginController.login("admin","admin",false));
    }
}
