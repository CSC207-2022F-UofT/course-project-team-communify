package controller;

import database.UserList;
import presenter.UserPresenter;
import view.InMemoryUser;
import viewModel.UserViewModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * tests the register controller
 */
public class RegisterControllerTest {
    /**
     * Tests the register regular user use case call.
     */
    @Test
    public void testRegisterRegular(){
        RegisterController registerController = new RegisterController(new UserPresenter(new UserViewModel(
                new InMemoryUser()), new InMemoryUser()));
        if (UserList.getInstance().exists("UserRegular"))
            Assertions.assertFalse(registerController.registerRegular("UserRegular","regular"));
        else
            Assertions.assertTrue(registerController.registerRegular("UserRegular","regular"));
    }
    /**
     * Tests the register artist user use case call.
     */
    @Test
    public void testRegisterArtist(){
        RegisterArtistController registerController = new RegisterArtistController(new UserPresenter(new UserViewModel(
                new InMemoryUser()), new InMemoryUser()));
        if (UserList.getInstance().exists("UserArtist"))
            Assertions.assertFalse(registerController.registerArtist("UserArtist","artist","pw"));
        else
            Assertions.assertTrue(registerController.registerArtist("UserArtist","artist","pw"));
    }
}
