package Database;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;

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

    @Test
    public void testGetString(){
        Assertions.assertNotEquals(songLibrary.getInstance().getString(), null);
    }

    @Test
    public void testGetStringID(){
        Assertions.assertNotEquals(null, songLibrary.getInstance().getString("metrofolk"));
    }

    @Test
    public void testGetStringUsername(){
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(2);
        Assertions.assertNotEquals(null, songLibrary.getInstance().getString(ids));
    }

    @Test
    public void testGetSongID(){
        Assertions.assertNotEquals(null, songLibrary.getInstance().getSong(2));
    }

    @Test
    public void testExistsString(){
        Assertions.assertFalse(songLibrary.getInstance().exists("Not a Real Song", new String[]{"Not by This Person"}));
    }

    @Test
    public void testExistsSongDsData(){
        songDsData song = songLibrary.getInstance().getSong(2);
        Assertions.assertTrue(songLibrary.getInstance().exists(song));
    }

    @Test
    public void testExistsID(){
        Assertions.assertTrue(songLibrary.getInstance().exists(2));
    }
}
