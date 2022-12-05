package viewModel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import view.InMemoryArtistUser;

/**
 * testing for the artist view model
 */
public class ArtistViewModelTest {

    ArtistViewModel avm = new ArtistViewModel(new InMemoryArtistUser("Metrofolk", "metrofolk"));

    /**
     * Tests whether a Song is successfully added to UploadQueue when upload in ArtistViewModel is called.
     */
    @Test
    public void testUpload(){
        Assertions.assertTrue(avm.upload("./src/test/java/viewModel/test.mp3"));
    }

    /**
     * Tests that songs are successfully retrieved by getArtistSong
     */
    @Test
    public void testGetArtistSongs(){
        Assertions.assertNotEquals(avm.getArtistSongs(), new String[][]{});
    }

    /**
     * Tests that artist name is successfully returned by getArtistName()
     */
    @Test
    public void testGetArtistName(){
        Assertions.assertEquals(avm.getArtistName(), "Metrofolk");
    }
}
