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
        songAccessInterface lib = songLibrary.getInstance();
        songDsData song = new songDsData(-1, null, null, null, null, null, null);

        // Song is new. Song is added.
        Assertions.assertTrue(lib.saveSong(song));

        // Correct song is added.
        Assertions.assertSame(lib.getSong(-1), song);

        // Song with ID already exists. Song is not added.
        Assertions.assertFalse(lib.saveSong(song));
    }

//    @Test
//    public void testGetSong(){
//        songAccessInterface lib = songLibrary.getInstance();
//        songDsData song = lib.getSong(2);
//        Assertions.assertEquals(song.getID(), 2);
//    }
}
