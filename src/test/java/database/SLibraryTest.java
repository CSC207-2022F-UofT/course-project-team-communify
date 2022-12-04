package database;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
        GetSongAccessInterface lib = SongLibrary.getInstance();
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
        SaveSongAccessInterface lib = SongLibrary.getInstance();
        String filepath = "./src/test/java/database/test.mp3";

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
        GetSongAccessInterface lib = SongLibrary.getInstance();
        SongDsData song = lib.getSong(2);
        Assertions.assertEquals(song.getID(), 2);
    }

    /**
     * tests the output of toString
     */
    @Test
    public void testGetString(){
        Assertions.assertNotEquals(SongLibrary.getInstance().getString(), null);
    }

    /**
     * tests getting the string ID of an artist
     */
    @Test
    public void testGetStringID(){
        Assertions.assertNotEquals(null, SongLibrary.getInstance().getString("metrofolk"));
    }

    /**
     * tests getting a username
     */
    @Test
    public void testGetStringUsername(){
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(2);
        Assertions.assertNotEquals(null, SongLibrary.getInstance().getString(ids));
    }

    /**
     * tests getting a song ID
     */
    @Test
    public void testGetSongID(){
        Assertions.assertNotEquals(null, SongLibrary.getInstance().getSong(2));
    }

    /**
     * tests the exists by string
     */
    @Test
    public void testExistsString(){
        Assertions.assertFalse(SongLibrary.getInstance().exists("Not a Real Song", new String[]{"Not by This Person"}));
    }

    /**
     * tests the exists by SongDsData
     */
    @Test
    public void testExistsSongDsData(){
        SongDsData song = SongLibrary.getInstance().getSong(2);
        Assertions.assertTrue(SongLibrary.getInstance().exists(song));
    }

    /**
     * tests the exists by ID
     */
    @Test
    public void testExistsID(){
        Assertions.assertTrue(SongLibrary.getInstance().exists(2));
    }
}
