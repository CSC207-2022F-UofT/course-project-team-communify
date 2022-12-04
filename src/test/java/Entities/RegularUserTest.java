package entities;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class RegularUserTest {
    final ArrayList<Integer> playlistList = new ArrayList<>();
    @Before
    public void init(){
        playlistList.add(0);
        playlistList.add(1);
    }
    @After
    public void reset(){
        playlistList.clear();
    }
    /**
     * Tests adding playlists.
     */
    @Test
    public void testAddPlaylist(){
        //creating user with playlist
        RegularUser regularUser = new RegularUser("UserR","Password2", playlistList);
        //create the other playlist and its owner
        ArrayList<Integer> user2list = new ArrayList<>();
        playlistList.add(2);
        RegularUser user2 = new RegularUser("UserC","Passwordidk",user2list);
        Playlist newPlaylist = new Playlist(10,"Playlist 3", user2);

        regularUser.addPlaylist(newPlaylist); //adding the playlist
        playlistList.add(10);//updating playlistList
        Assertions.assertSame(regularUser.getPlaylistList(), playlistList);
    }
    /**
     * Tests getting playlists.
     */
    @Test
    public void testGetPlaylistList(){
        RegularUser regularUser = new RegularUser("User1","Password1", playlistList);
        Assertions.assertSame(regularUser.getPlaylistList(), playlistList);
    }
}
