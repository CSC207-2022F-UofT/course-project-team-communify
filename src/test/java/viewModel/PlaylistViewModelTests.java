package viewModel;


import database.SongLibrary;
import entities.Song;
import view.InMemoryPlaylist;
import view.InMemoryUser;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 * Tests for the playlist view model.
 */
public class PlaylistViewModelTests {

    /**
     * tests making a new empty playlist
     */
    @Test
    public void callNewPlaylistEmptyTest(){
        InMemoryUser user = new InMemoryUser();
        user.setUsername("User1");
        String testName = "test";
        PlaylistViewModel testViewModel = new PlaylistViewModel(new InMemoryUser());
        String actual = testViewModel.callNewEmptyPlaylistUseCase(user,testName);
        String expected = "Playlist created!";
        Assertions.assertEquals(actual,expected);
    }

    /**
     * tests making a new playlist with a song
     */
    @Test
    public void callNewPlaylistTest(){
        InMemoryUser user = new InMemoryUser();
        user.setUsername("User2");
        String testName = "tes2";
        int songID = 10;
        Song s = SongLibrary.getInstance().getSong(songID).getSong();
        PlaylistViewModel testViewModel = new PlaylistViewModel(new InMemoryUser());
        String actual = testViewModel.callNewPlaylistUseCase(user,testName,songID);
        String expected = "Playlist created with " + s.getName()+"!";
        Assertions.assertEquals(actual,expected);
    }


    /**
     * tests adding a song
     */
    @Test
    public void callAddSongTest(){
        InMemoryUser user = new InMemoryUser();
        user.setUsername("User2");
        int songID = 10;
        InMemoryPlaylist playlist = new InMemoryPlaylist();
        playlist.setId(0);
        Song s = SongLibrary.getInstance().getSong(songID).getSong();
        PlaylistViewModel testViewModel = new PlaylistViewModel(new InMemoryUser());
        String actual = testViewModel.callAddSong(user,playlist,songID);
        String expected = s.getName()+" added!";
        Assertions.assertEquals(actual,expected);
    }

    /**
     * tests removing a song
     */
    @Test
    public void callRemoveSongTest(){
        InMemoryUser user = new InMemoryUser();
        user.setUsername("User2");
        String testName = "tes2";
        int songID = 10;
        Song s2 = SongLibrary.getInstance().getSong(songID).getSong();
        PlaylistViewModel testViewModel = new PlaylistViewModel(new InMemoryUser());
        testViewModel.callNewPlaylistUseCase(user,testName,songID);
        int playlist_ID = testViewModel.getCurrPlaylist().getId();
        String actual = testViewModel.callRemoveSong(user,playlist_ID,songID);
        String expected = s2.getName()+" removed!";
        Assertions.assertEquals(actual,expected);
    }
}
