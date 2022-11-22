package Database;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests for the song database.
 */
public class SLibraryTest {

    /**
     * Tests checking if a song exists.
     */
    @Test
    public void testExists(){
        GetSongAccessInterface lib = songLibrary.getInstance();
        // A song with id 2 exists.
        Assertions.assertTrue(lib.exists(2));
        // A song with id -2 does not exist.
        Assertions.assertFalse(lib.exists(-2));
    }

    /**
     * Tests saving a song.
     */
    @Test
    public void testSaveSong(){
        SaveSongAccessInterface lib = songLibrary.getInstance();
        String filepath = "./src/test/java/Database/test.mp3";

        // Song is new. Song is added.
        Assertions.assertTrue(lib.saveSong("testSaveSong", filepath));

        // Song already exists. Song is not added.
        Assertions.assertFalse(lib.saveSong("testSaveSong", filepath));
    }

    /**
     * Tests getting a song.
     */
    @Test
    public void testGetSong(){
        GetSongAccessInterface lib = songLibrary.getInstance();
        songDsData song = lib.getSong(2);
        Assertions.assertEquals(song.getID(), 2);
    }
}
