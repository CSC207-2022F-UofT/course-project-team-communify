package ViewModel;

import View.InMemoryArtistUser;
import View.InMemoryUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

public class UserVMTests {
    /**
     * testing if call play space works
     */
    @Test
    public void testregisterAction(){
        String username = "user" + ThreadLocalRandom.current().nextInt(0, 99999);
        String password = "password" + ThreadLocalRandom.current().nextInt(0, 99999);
        UserViewModel vm = new UserViewModel(new InMemoryUser());
        Assertions.assertTrue(vm.registerAction(username,password, false,""));
    }
    /**
     * testing if call play space works
     */
    @Test
    public void testregisterArtistAction(){
        String username = "user" + ThreadLocalRandom.current().nextInt(0, 99999);
        String artistname = "artist" + ThreadLocalRandom.current().nextInt(0, 99999);
        String password = "password" + ThreadLocalRandom.current().nextInt(0, 99999);
        UserViewModel vm = new UserViewModel(new InMemoryArtistUser("", ""));
        Assertions.assertTrue(vm.registerAction(username,password, true, artistname));
    }
}
