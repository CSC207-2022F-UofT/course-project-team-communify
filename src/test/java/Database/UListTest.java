package Database;

import Entities.RegularUser;
import Entities.User;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class UListTest {
    @Before
    public void setUp(){
    }

    @Test
    public void testExists(){
        userAccessInterface list = userList.getInstance();

        // there is a User1
        Assertions.assertTrue(list.exists("User1"));

        // there is no Muhammed
        Assertions.assertFalse(list.exists("Muhammed"));
    }

    @Test
    public void testSaveUser(){
        userAccessInterface list = userList.getInstance();
        Random random = new Random();
        int id = random.nextInt();
        String username = "user" + id;

        while(list.exists(username)){
            id = random.nextInt();
            username = "user" + id;
        }

        RegularUser u = new RegularUser(username, "pass" + id);
        list.save(new userDsData(u));
        Assertions.assertEquals(u.getUsername(), list.getUser(username).getUsername());
        Assertions.assertEquals(u.getPassword(), list.getUser(username).getPassword());
    }

    @Test
    public void testGetPlaylist(){
        userAccessInterface list = userList.getInstance();
        User u = list.getUser("User1").getUser();
        Assertions.assertEquals(u.getUsername(), "User1");
        Assertions.assertEquals(u.getPassword(), "Password1");
    }
}
