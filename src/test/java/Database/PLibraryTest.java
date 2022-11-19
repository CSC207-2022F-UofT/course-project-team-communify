package Database;

import Entities.Playlist;
import Entities.RegularUser;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class PLibraryTest {
    @Before
    public void setUp(){
    }

    @Test
    public void testExists(){
        SavePlaylistAccessInterface library = Database.playlistLibrary.getInstance();

        // there is a 0 id playlist
        Assertions.assertTrue(library.exists(0));

        // there is no 999999 id playlist
        Assertions.assertFalse(library.exists(999999));
    }

    @Test
    public void testSavePlaylist(){
        SavePlaylistAccessInterface library = Database.playlistLibrary.getInstance();
        RegularUser u = new RegularUser("user", "pass");
        Random random = new Random();
        int id = random.nextInt();

        while(library.exists(id))
            id = random.nextInt();

        Playlist p = new Playlist(id, "Playlist A", u);
        u.addPlaylist(p);
        Database.userList.getInstance().save(new userDsData(u));

        library.savePlaylist(new playlistDsData(p));
        Assertions.assertEquals(p.getId(), playlistLibrary.getInstance().findPlaylist(id).getId());
    }

    @Test
    public void testGetPlaylist(){
        GetPlaylistAccessInterface library = Database.playlistLibrary.getInstance();
        Assertions.assertEquals(library.findPlaylist(0).getId(), 0);
        Assertions.assertEquals(library.findPlaylist(0).getPlaylist().getName(), "Playlist 1");
    }
}