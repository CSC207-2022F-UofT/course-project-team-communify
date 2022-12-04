package useCase;

import database.PlaylistLibrary;
import database.SongLibrary;
import entities.Playlist;
import entities.Song;
import inputData.EditPlaylistInputData;
import presenter.PlaylistPresenter;
import view.InMemoryPlaylist;
import view.InMemoryUser;
import viewModel.PlaylistViewModel;
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
        Playlist p = PlaylistLibrary.getInstance().findPlaylist(playlist.getId()).getPlaylist();
        Song s = SongLibrary.getInstance().getSong(song).getSong();
        int numOccurrence = 0;
        for (Song songs: p.getSongList()){
            if (songs.equals(s))
                numOccurrence++;
        }

        EditPlaylistInputData inputData = new EditPlaylistInputData(user.getUsername(), playlist.getId(), song);
        PlaylistViewModel testViewModel= new PlaylistViewModel();
        PlaylistPresenter testPresenter= new PlaylistPresenter(testViewModel, new InMemoryUser());
        EditPlaylistInteractor testInteractor = new EditPlaylistInteractor(testPresenter);
        testInteractor.removeSong(inputData);
        String actual = testPresenter.getOutputMessage();
        String expected = SongLibrary.getInstance().getSong(song).getSong().getName() + " removed!";
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
    public void AddSongAndMessage(){
        InMemoryUser user = new InMemoryUser();
        user.setUsername("User1");
        int song = 10;
        InMemoryPlaylist playlist = new InMemoryPlaylist();
        playlist.setId(0);
        EditPlaylistInputData inputData = new EditPlaylistInputData(user.getUsername(), playlist.getId(), song);
        PlaylistViewModel testViewModel = new PlaylistViewModel();
        PlaylistPresenter testPresenter = new PlaylistPresenter(testViewModel, new InMemoryUser());
        EditPlaylistInteractor testInteractor = new EditPlaylistInteractor(testPresenter);
        testInteractor.addSong(inputData);
        String actual = testPresenter.getOutputMessage();
        String expected = SongLibrary.getInstance().getSong(song).getSong().getName() + " added!";
        Assertions.assertEquals(expected, actual);

        Playlist p = PlaylistLibrary.getInstance().findPlaylist(playlist.getId()).getPlaylist();
        Song s = SongLibrary.getInstance().getSong(song).getSong();
        Assertions.assertTrue(p.getSongList().contains(s));
    }
}
