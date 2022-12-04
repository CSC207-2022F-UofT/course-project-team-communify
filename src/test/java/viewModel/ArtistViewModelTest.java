package viewModel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import view.InMemoryArtistUser;

public class ArtistViewModelTest {

    ArtistViewModel avm = new ArtistViewModel(new InMemoryArtistUser("Metrofolk", "metrofolk"));

    @Test
    public void testUpload(){
        // Song is successfully added to UploadQueue.
        Assertions.assertTrue(avm.upload("./src/test/java/viewModel/test.mp3"));
    }

    @Test
    public void testGetArtistSongs(){
        // Song is successfully added to UploadQueue
        Assertions.assertNotEquals(avm.getArtistSongs(), new String[][]{});
    }

    @Test
    public void testGetArtistName(){
        Assertions.assertEquals(avm.getArtistName(), "Metrofolk");
    }
}
