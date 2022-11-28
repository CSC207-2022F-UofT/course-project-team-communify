package UseCase;

import Database.playlistDsData;
import Database.songLibrary;
import Entities.Song;
import Presenter.playlistPresenter;
import View.InMemoryUser;
import ViewModel.playlistViewModel;
import org.junit.Assert;
import org.junit.Test;
import InputData.newPlaylistInputData;
import org.junit.jupiter.api.Assertions;

import Database.playlistLibrary;

import java.util.Collection;

public class CreatePlaylistTests {

    @Test
    public void CreatePlaylistMessageAndEmptyPlaylist(){
        InMemoryUser user = new InMemoryUser();
        user.setUsername("User1");
        String testname = "test";
        newPlaylistInputData inputData = new newPlaylistInputData(testname,user.getUsername());
        playlistViewModel testViewModel = new playlistViewModel();
        playlistPresenter testPresenter = new playlistPresenter(testViewModel, new InMemoryUser());
        CreatePlaylistInteractor testInteractor = new CreatePlaylistInteractor(testPresenter);
        testInteractor.newPlaylist(inputData);
        String actual1 = testPresenter.getOutputMessage();
        String expected1 = "Playlist created!";
        boolean created = actual1.equals(expected1);

        playlistLibrary library  = playlistLibrary.getInstance();
        Collection<playlistDsData> PlaylistLibrary =  library.getPlaylists();
        boolean actual2 = false;
        boolean expected2 = true;
        for(playlistDsData playlist:PlaylistLibrary){
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
        int song = 10;
        Song s = songLibrary.getInstance().getSong(song).getSong();
        newPlaylistInputData inputData = new newPlaylistInputData(testname,s,user.getUsername());
        playlistViewModel testViewModel = new playlistViewModel();
        playlistPresenter testPresenter = new playlistPresenter(testViewModel, new InMemoryUser());
        CreatePlaylistInteractor testInteractor = new CreatePlaylistInteractor(testPresenter);
        testInteractor.newPlaylist(inputData);
        String actual1 = testPresenter.getOutputMessage();
        String expected1 = "Playlist created with "+s.getName()+"!";
        boolean created = actual1.equals(expected1);

        playlistLibrary library  = playlistLibrary.getInstance();
        Collection<playlistDsData> PlaylistLibrary =  library.getPlaylists();
        boolean actual2 = false;
        boolean expected2 = true;
        for(playlistDsData playlist:PlaylistLibrary){
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
