package Entities;
import Entities.Playlist;
import Entities.RegularUser;
import org.junit.Before;
import org.junit.Test;

import java.util.Objects;

public class PlaylistTests {
    @Before
    public void setUp(){
    }

    @Test
    public void testOwner(){
        RegularUser joe = new RegularUser("joe","mama");
        Playlist joesPlaylist = new Playlist(787,"Joe's Playlist",joe);
        boolean expected = true;
        boolean actual = Objects.equals(joesPlaylist.getOwner().getUsername(), "joe");
        assert expected == actual;
    }

    @Test public void testAddSong(){
        RegularUser joe = new RegularUser("joe","mama");
        Playlist joesPlaylist = new Playlist(787,"Joe's Playlist",joe);
        Song testsong = new Song(999,null,null,null,null,null,null);
        joesPlaylist.addSong(testsong);
        boolean expected = true;
        boolean actual = joesPlaylist.getSongList().contains(testsong);
        assert expected == actual;
    }

    @Test public void testRemoveSong(){
        RegularUser joe = new RegularUser("joe","mama");
        Playlist joesPlaylist = new Playlist(787,"Joe's Playlist",joe);
        Song testsong = new Song(999,null,null,null,null,null,null);
        joesPlaylist.addSong(testsong);
        joesPlaylist.removeSong(testsong);
        boolean expected = true;
        boolean actual = !joesPlaylist.getSongList().contains(testsong);
        assert expected == actual;
    }
    @Test public void getID(){
        RegularUser joe = new RegularUser("joe","mama");
        Playlist joesPlaylist = new Playlist(787,"Joe's Playlist",joe);;
        int expected = 787;
        int actual = joesPlaylist.getId();
        assert expected == actual;
    }
}
