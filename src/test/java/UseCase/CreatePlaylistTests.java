package UseCase;

import Database.songLibrary;
import Entities.Song;
import Presenter.playlistPresenter;
import View.InMemoryUser;
import ViewModel.playlistViewModel;
import org.junit.Test;
import InputData.newPlaylistInputData;
import org.junit.jupiter.api.Assertions;

public class CreatePlaylistTests {

    @Test
    public void CreateSongMessageAndEmptyPlaylist(){
        InMemoryUser user = new InMemoryUser();
        user.setUsername("User1");
        String testname = "test";


        newPlaylistInputData inputData = new newPlaylistInputData(testname,user.getUsername());
        playlistViewModel testViewModel = new playlistViewModel();
        playlistPresenter testPresenter = new playlistPresenter(testViewModel, new InMemoryUser());
        CreatePlaylistInteractor testInteractor = new CreatePlaylistInteractor(testPresenter);
        testInteractor.newPlaylist(inputData);
        String actual = testPresenter.getOutputMessage();
        String expected = "Playlist created!";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void CreateSongMessageAndNonEmptyPlaylist(){
        InMemoryUser user = new InMemoryUser();
        user.setUsername("User1");
        String testname = "test";
        int songID = 10;
        Song s = songLibrary.getInstance().getSong(songID).getSong();
        newPlaylistInputData inputData = new newPlaylistInputData(testname,songID,user.getUsername());
        playlistViewModel testViewModel = new playlistViewModel();
        playlistPresenter testPresenter = new playlistPresenter(testViewModel, new InMemoryUser());
        CreatePlaylistInteractor testInteractor = new CreatePlaylistInteractor(testPresenter);
        testInteractor.newPlaylist(inputData);
        String actual = testPresenter.getOutputMessage();
        String expected = "Playlist created with "+s.getName()+"!";
        Assertions.assertEquals(expected, actual);
    }
}
