package viewModel;

import view.InMemoryArtistUser;
import view.InMemoryUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Tests for the user view model.
 */
public class UserVMTests {
    /**
     * testing if call play space works
     */
    @Test
    public void testRegisterAction(){
        String username = "user" + ThreadLocalRandom.current().nextInt(0, 99999);
        String password = "password" + ThreadLocalRandom.current().nextInt(0, 99999);
        UserViewModel vm = new UserViewModel(new InMemoryUser());
        Assertions.assertTrue(vm.registerAction(username,password, false,""));
    }
    /**
     * testing if call play space works
     */
    @Test
    public void testRegisterArtistAction(){
        String username = "user" + ThreadLocalRandom.current().nextInt(0, 99999);
        String artistName = "artist" + ThreadLocalRandom.current().nextInt(0, 99999);
        String password = "password" + ThreadLocalRandom.current().nextInt(0, 99999);
        UserViewModel vm = new UserViewModel(new InMemoryArtistUser("", ""));
        Assertions.assertTrue(vm.registerAction(username,password, true, artistName));
    }
}
