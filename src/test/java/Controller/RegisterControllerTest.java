package Controller;

import Database.userList;
import Presenter.userPresenter;
import View.InMemoryUser;
import ViewModel.userViewModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RegisterControllerTest {
    /**
     * Tests the register regular user use case call.
     */
    @Test
    public void testRegisterRegular(){
        RegisterController registerController = new RegisterController(new userPresenter(new userViewModel(
                new InMemoryUser()), new InMemoryUser()));
        if (userList.getInstance().exists("UserRegular"))
            Assertions.assertFalse(registerController.registerRegular("UserRegular","regular"));
        else
            Assertions.assertTrue(registerController.registerRegular("UserRegular","regular"));
    }
    /**
     * Tests the register artist user use case call.
     */
    @Test
    public void testRegisterArtist(){
        RegisterArtistController registerController = new RegisterArtistController(new userPresenter(new userViewModel(
                new InMemoryUser()), new InMemoryUser()));
        if (userList.getInstance().exists("UserArtist"))
            Assertions.assertFalse(registerController.registerArtist("UserArtist","artist","pw"));
        else
            Assertions.assertTrue(registerController.registerArtist("UserArtist","artist","pw"));
    }
}