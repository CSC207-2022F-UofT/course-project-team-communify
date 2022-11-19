package UseCase;

import Database.SaveSongAccessInterface;
import Database.songLibrary;
import org.junit.jupiter.api.Test;

public class UploadSongTest {

    @Test
    public void testUploadSong(){
        SaveSongAccessInterface lib = songLibrary.getInstance();
        String filepath = ".\\src\\test\\java\\UseCase\\test1.mp3";
        // TODO
    }

}
