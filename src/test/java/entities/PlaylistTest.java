package entities;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Objects;

/**
 * tests for the playlist entity
 */
public class PlaylistTest {
    /**
     * tests the owner field of the playlist
     */
    @Test
    public void testOwner(){
        RegularUser joe = new RegularUser("joe","mama");
        Playlist joesPlaylist = new Playlist(787,"Joe's Playlist",joe);
        boolean expected = true;
        boolean actual = Objects.equals(joesPlaylist.getOwner().getUsername(), "joe");
        Assertions.assertEquals(expected, actual);
    }

    /**
     * tests adding a song
     */
    @Test
    public void testAddSong(){
        RegularUser joe = new RegularUser("joe","mama");
        Playlist joesPlaylist = new Playlist(787,"Joe's Playlist",joe);
        Song testSong = new Song(999,null,null,null,null,null,null);
        joesPlaylist.addSong(testSong);
        boolean expected = true;
        boolean actual = joesPlaylist.getSongList().contains(testSong);
        Assertions.assertEquals(expected, actual);
    }

    /**
     * tests removing a song
     */
    @Test
    public void testRemoveSong(){
        RegularUser joe = new RegularUser("joe","mama");
        Playlist joesPlaylist = new Playlist(787,"Joe's Playlist",joe);
        Song testSong = new Song(999,null,null,null,null,null,null);
        joesPlaylist.addSong(testSong);
        joesPlaylist.removeSong(testSong);
        boolean expected = true;
        boolean actual = !joesPlaylist.getSongList().contains(testSong);
        Assertions.assertEquals(expected, actual);
    }

    /**
     * tests getting the ID of a song
     */
    @Test
    public void testGetID(){
        RegularUser joe = new RegularUser("joe","mama");
        Playlist joesPlaylist = new Playlist(787,"Joe's Playlist",joe);
        int expected = 787;
        int actual = joesPlaylist.getId();
        Assertions.assertEquals(expected, actual);
    }
}
