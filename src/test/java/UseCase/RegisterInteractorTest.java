package UseCase;

import Database.userList;
import InputData.RegisterInputData;
import Presenter.userPresenter;
import View.InMemoryUser;
import ViewModel.userViewModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

public class RegisterInteractorTest {
    /**
     * Tests the register success.
     */
    @Test
    public void testRegularSuccess(){
        String username = "user" + ThreadLocalRandom.current().nextInt(0, 99999);
        String password = "password" + ThreadLocalRandom.current().nextInt(0, 99999);
        RegisterInputData regularUser = new RegisterInputData(username,password);
        RegisterInteractor registerInteractor = new RegisterInteractor(new userPresenter(new userViewModel(
                new InMemoryUser()), new InMemoryUser()));
        if (userList.getInstance().exists(username))
            Assertions.assertFalse(registerInteractor.register(regularUser));
        else
            Assertions.assertTrue(registerInteractor.register(regularUser));
    }
    /**
     * Tests the register failure due to invalid credential.
     */
    @Test
    public void testRegularFailure(){
        RegisterInputData regularUser = new RegisterInputData("","bla");
        RegisterInteractor registerInteractor = new RegisterInteractor(new userPresenter(new userViewModel(
                new InMemoryUser()), new InMemoryUser()));
        Assertions.assertFalse(registerInteractor.register(regularUser));
    }
    /**
     * Tests the register failure due to user existed.
     */
    @Test
    public void testUserExist(){
        RegisterInputData regularUser = new RegisterInputData("UserRegular","bla");
        RegisterInteractor registerInteractor = new RegisterInteractor(new userPresenter(new userViewModel(
                new InMemoryUser()), new InMemoryUser()));
        Assertions.assertFalse(registerInteractor.register(regularUser));
    }
}
