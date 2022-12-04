package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserFactoryTest {
    /**
     * Tests the creating a regular user.
     */
    @Test
    public void testCreateRegularUser(){
        UserFactory userFactory = new UserFactory();
        Assertions.assertNotNull(userFactory.createRegularUser("User1", "password"));
    }
}
