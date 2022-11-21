package UseCase;

import ViewModel.ArtistViewModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UploadSongTest {

    @Test
    public void testUploadSong(){
        ArtistViewModel view = new ArtistViewModel();
        String filepath = "./src/test/java/UseCase/test_metadata.mp3";
        Assertions.assertTrue(view.upload(filepath, "admin"));
    }

}
