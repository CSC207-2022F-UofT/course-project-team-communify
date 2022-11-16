package Database;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SLibraryTest {

//    @Test
//    public void testExists(){
//        songAccessInterface lib = songLibrary.getInstance();
//        // A song with id 2 exists.
//        Assertions.assertTrue(lib.exists(2));
//        // A song with id -2 does not exist.
//        Assertions.assertFalse(lib.exists(-2));
//    }

    @Test
    public void testSaveSong(){
        SaveSongAccessInterface lib = songLibrary.getInstance();
        String filepath = ".\\src\\test\\java\\UseCase\\10.mp3";

        // Song is new. Song is added.
        Assertions.assertTrue(lib.saveSong("testSaveSong", filepath));

//        // TODO: Song already exists. Song is not added.
//        Assertions.assertTrue(lib.saveSong("testSaveSong", filepath));
    }

//    @Test
//    public void testGetSong(){
//        songAccessInterface lib = songLibrary.getInstance();
//        songDsData song = lib.getSong(2);
//        Assertions.assertEquals(song.getID(), 2);
//    }
}
