package OuputData;

import Entities.ArtistUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import OutputData.loginOutputData;

public class LoginOutputDataTest {
    ArtistUser artistUser = new ArtistUser("Artsit", "artsit","pass");
    loginOutputData artist = new loginOutputData(artistUser,true);
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
