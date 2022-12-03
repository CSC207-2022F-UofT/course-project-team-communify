package ViewModel;


import Database.SongLibrary;
import Entities.Song;
import View.InMemoryPlaylist;
import View.InMemoryUser;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
public class PlaylistViewModelTests {

    @Test
    public void CallNewPlaylistEmptyTest(){
        InMemoryUser user = new InMemoryUser();
        user.setUsername("User1");
        String testname = "test";
        PlaylistViewModel testViewModel = new PlaylistViewModel();
        String actual = testViewModel.callNewEmptyPlaylistUseCase(user,testname);
        String expected = "Playlist created!";
        Assertions.assertEquals(actual,expected);
    }

    @Test
    public void CallNewPlaylistTest(){
        InMemoryUser user = new InMemoryUser();
        user.setUsername("User2");
        String testname = "tes2";
        int songID = 10;
        Song s = SongLibrary.getInstance().getSong(songID).getSong();
        PlaylistViewModel testViewModel = new PlaylistViewModel();
        String actual = testViewModel.callNewPlaylistUseCase(user,testname,songID);
        String expected = "Playlist created with " + s.getName()+"!";
        Assertions.assertEquals(actual,expected);
    }


    @Test
    public void callAddSongTest(){
        InMemoryUser user = new InMemoryUser();
        user.setUsername("User2");
        String testname = "tes2";
        int songID = 10;
        InMemoryPlaylist playlist = new InMemoryPlaylist();
        playlist.setId(0);
        Song s = SongLibrary.getInstance().getSong(songID).getSong();
        PlaylistViewModel testViewModel = new PlaylistViewModel();
        String actual = testViewModel.callAddSong(user,playlist,songID);
        String expected = s.getName()+" added!";
        Assertions.assertEquals(actual,expected);
    }

    @Test
    public void callRemoveSongTest(){
        InMemoryUser user = new InMemoryUser();
        user.setUsername("User2");
        String testname = "tes2";
        int songID = 10;
        Song s2 = SongLibrary.getInstance().getSong(songID).getSong();
        PlaylistViewModel testViewModel = new PlaylistViewModel();
        testViewModel.callNewPlaylistUseCase(user,testname,songID);
        int playlist_ID = testViewModel.getCurrPlaylist().getId();
        String actual = testViewModel.callRemoveSong(user,playlist_ID,songID);
        String expected = s2.getName()+" removed!";
        Assertions.assertEquals(actual,expected);
    }
}
