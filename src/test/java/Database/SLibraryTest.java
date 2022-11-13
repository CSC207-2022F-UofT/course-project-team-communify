package Database;
import Entities.Song;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SLibraryTest {

    songAccessInterface lib;

    @Before
    public void setUp(){
        lib = Database.songLibrary.getInstance();
    }

    @Test
    public void testExists(){
        // A song with id 2 exists.
        Assertions.assertTrue(lib.exists(2));
        // A song with id -2 does not exist.
        Assertions.assertFalse(lib.exists(-2));
    }

    @Test
    public void testSaveSong(){

        songDsData song = new songDsData(-1, null, null, null, null, null, null);

        // Song is new. Song is added.
        Assertions.assertTrue(lib.saveSong(song));

        // Correct song is added.
        Assertions.assertSame(lib.getSong(-1), song);

        // Song with ID already exists. Song is not added.
        Assertions.assertFalse(lib.saveSong(song));
    }

    @Test
    public void testGetSong(){
        Song song = lib.getSong(2).getSong();
        Assertions.assertEquals(song.getID(), 2);
    }

}
