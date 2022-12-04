package useCase;

import view.InMemoryArtistUser;
import viewModel.ArtistViewModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
/**
 * Tests the upload song use case.
 */
public class UploadSongTest {

    /**
     * Tests uploading a single song.
     */
    @Test
    public void testUploadSong(){

        InMemoryArtistUser artist = new InMemoryArtistUser("admin", "admin");
        ArtistViewModel view = new ArtistViewModel(artist);
        String filepath = "./src/test/java/UseCase/test_metadata.mp3";
        Assertions.assertTrue(view.upload(filepath));
    }

}
