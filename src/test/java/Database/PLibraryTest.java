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
        SavePlaylistAccessInterface library = PlaylistLibrary.getInstance();

        // there is a 0 id playlist
        Assertions.assertTrue(library.exists(0));

        // there is no 999999 id playlist
        Assertions.assertFalse(library.exists(999999));
    }

    @Test
    public void testSavePlaylist(){
        SavePlaylistAccessInterface library = PlaylistLibrary.getInstance();
        RegularUser u = new RegularUser("user", "pass");
        Random random = new Random();
        int id = random.nextInt();

        while(library.exists(id))
            id = random.nextInt();

        Playlist p = new Playlist(id, "Playlist A", u);
        u.addPlaylist(p);
        UserList.getInstance().save(new UserDsData(u));

        library.savePlaylist(new PlaylistDsData(p));
        Assertions.assertEquals(p.getId(), PlaylistLibrary.getInstance().findPlaylist(id).getId());
    }

    @Test
    public void testGetPlaylist(){
        GetPlaylistAccessInterface library = PlaylistLibrary.getInstance();
        Assertions.assertEquals(library.findPlaylist(0).getId(), 0);
        Assertions.assertEquals(library.findPlaylist(0).getPlaylist().getName(), "Playlist 1");
    }
}