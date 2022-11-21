package UseCase;

import View.InMemoryArtistUser;
import ViewModel.ArtistViewModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UploadSongTest {

    @Test
    public void testUploadSong(){

        InMemoryArtistUser artist = new InMemoryArtistUser("admin", "admin");
        ArtistViewModel view = new ArtistViewModel(artist);
        String filepath = "./src/test/java/UseCase/test_metadata.mp3";
        Assertions.assertTrue(view.upload(filepath));
    }

}
