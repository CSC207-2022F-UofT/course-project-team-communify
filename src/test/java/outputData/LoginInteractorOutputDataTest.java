package outputData;

import entities.ArtistUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * tests for the login output data
 */
public class LoginInteractorOutputDataTest {
    final ArtistUser artistUser = new ArtistUser("Artsit", "artsit","pass");
    final LoginOutputData artist = new LoginOutputData(artistUser,true);
    /**
     * Tests the getting artist name.
     */
    @Test
    public void testGetArtistName(){
        Assertions.assertEquals(artist.getArtistName(),"Artsit");
    }
    /**
     * Tests whether user is artist.
     */
    @Test
    public void testIsArtist(){
        Assertions.assertTrue(artist.isArtist());
    }
}
