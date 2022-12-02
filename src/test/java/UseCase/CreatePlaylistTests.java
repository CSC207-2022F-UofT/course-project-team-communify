package UseCase;

import Database.PlaylistDsData;
import Database.SongLibrary;
import Entities.Song;
import Presenter.PlaylistPresenter;
import View.InMemoryUser;
import ViewModel.PlaylistViewModel;
import org.junit.Test;
import InputData.NewPlaylistInputData;
import org.junit.jupiter.api.Assertions;

import Database.PlaylistLibrary;

import java.util.Collection;

public class CreatePlaylistTests {

    @Test
    public void CreatePlaylistMessageAndEmptyPlaylist(){
        InMemoryUser user = new InMemoryUser();
        user.setUsername("User1");
        String testname = "test";
        NewPlaylistInputData inputData = new NewPlaylistInputData(testname,user.getUsername());
        PlaylistViewModel testViewModel = new PlaylistViewModel();
        PlaylistPresenter testPresenter = new PlaylistPresenter(testViewModel, new InMemoryUser());
        CreatePlaylistInteractor testInteractor = new CreatePlaylistInteractor(testPresenter);
        testInteractor.newPlaylist(inputData);
        String actual1 = testPresenter.getOutputMessage();
        String expected1 = "Playlist created!";
        boolean created = actual1.equals(expected1);

        PlaylistLibrary library  = PlaylistLibrary.getInstance();
        Collection<PlaylistDsData> PlaylistLibrary =  library.getPlaylists();
        boolean actual2 = false;
        boolean expected2 = true;
        for(PlaylistDsData playlist:PlaylistLibrary){
            if (playlist.getPlaylist().getName().equals(testname)){
                if(playlist.getPlaylist().getSongList().isEmpty()){
                    actual2 = true;
                    break;
                }
            }
        }
        boolean empty = actual2 == expected2;
        Assertions.assertEquals(created,empty);
    }

    @Test
    public void CreatePlaylistMessageAndNonEmptyPlaylist(){
        InMemoryUser user = new InMemoryUser();
        user.setUsername("User1");
        String testname = "test";
        int songID = 10;
        Song s = SongLibrary.getInstance().getSong(songID).getSong();
        NewPlaylistInputData inputData = new NewPlaylistInputData(testname,songID,user.getUsername());
        PlaylistViewModel testViewModel = new PlaylistViewModel();
        PlaylistPresenter testPresenter = new PlaylistPresenter(testViewModel, new InMemoryUser());
        CreatePlaylistInteractor testInteractor = new CreatePlaylistInteractor(testPresenter);
        testInteractor.newPlaylist(inputData);
        String actual1 = testPresenter.getOutputMessage();
        String expected1 = "Playlist created with "+s.getName()+"!";
        boolean created = actual1.equals(expected1);

        PlaylistLibrary library  = PlaylistLibrary.getInstance();
        Collection<PlaylistDsData> PlaylistLibrary =  library.getPlaylists();
        boolean actual2 = false;
        boolean expected2 = true;
        for(PlaylistDsData playlist:PlaylistLibrary){
            if (playlist.getPlaylist().getName().equals(testname)){
                if(!playlist.getPlaylist().getSongList().isEmpty()){
                    actual2 = true;
                    break;
                }
            }
        }
        boolean nonempty = actual2 == expected2;
        Assertions.assertEquals(created,nonempty);
    }
}
