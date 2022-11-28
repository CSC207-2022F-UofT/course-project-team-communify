package UseCase;

import Database.playlistLibrary;
import Database.songLibrary;
import Entities.Playlist;
import Entities.Song;
import InputData.editPlaylistInputData;
import Presenter.playlistPresenter;
import View.InMemoryPlaylist;
import View.InMemoryUser;
import ViewModel.playlistViewModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
/**
 * Tests the edit playlist use cases.
 */
public class EditPlaylistTests {

    /**
     * Tests removing a song and the message it returns.
     */
    @Test
    public void RemoveSongAndMessage(){
        InMemoryUser user = new InMemoryUser();
        user.setUsername("User1");
        int song = 10;
        InMemoryPlaylist playlist = new InMemoryPlaylist();
        playlist.setId(0);
        Playlist p = playlistLibrary.getInstance().findPlaylist(playlist.getId()).getPlaylist();
        Song s = songLibrary.getInstance().getSong(song).getSong();
        int numOccurrence = 0;
        for (Song songs: p.getSongList()){
            if (songs.equals(s))
                numOccurrence++;
        }

        editPlaylistInputData inputData = new editPlaylistInputData(user.getUsername(), playlist.getId(), song);
        playlistViewModel testViewModel= new playlistViewModel();
        playlistPresenter testPresenter= new playlistPresenter(testViewModel, new InMemoryUser());
        EditPlaylistInteractor testInteractor = new EditPlaylistInteractor(testPresenter);
        testInteractor.removeSong(inputData);
        String actual = testPresenter.getOutputMessage();
        String expected = songLibrary.getInstance().getSong(song).getSong().getName() + " removed!";
        Assertions.assertEquals(expected, actual);

        int newNumOccurrence = 0;
        for (Song songs: p.getSongList()){
            if (songs.equals(s))
                newNumOccurrence++;
        }
        Assertions.assertEquals(newNumOccurrence, Math.max(0, numOccurrence - 1));
    }

    /**
     * Tests adding a song and the message it returns.
     */
    @Test
    public void addSongAndMessage(){
        InMemoryUser user = new InMemoryUser();
        user.setUsername("User1");
        int song = 10;
        InMemoryPlaylist playlist = new InMemoryPlaylist();
        playlist.setId(0);
        editPlaylistInputData inputData = new editPlaylistInputData(user.getUsername(), playlist.getId(), song);
        playlistViewModel testViewModel = new playlistViewModel();
        playlistPresenter testPresenter = new playlistPresenter(testViewModel, new InMemoryUser());
        EditPlaylistInteractor testInteractor = new EditPlaylistInteractor(testPresenter);
        testInteractor.addSong(inputData);
        String actual = testPresenter.getOutputMessage();
        String expected = songLibrary.getInstance().getSong(song).getSong().getName() + " added!";
        Assertions.assertEquals(expected, actual);

        Playlist p = playlistLibrary.getInstance().findPlaylist(playlist.getId()).getPlaylist();
        Song s = songLibrary.getInstance().getSong(song).getSong();
        Assertions.assertTrue(p.getSongList().contains(s));
    }
}
