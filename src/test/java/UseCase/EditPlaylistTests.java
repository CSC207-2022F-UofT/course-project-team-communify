package UseCase;

import Entities.Playlist;
import Entities.RegularUser;
import Entities.Song;
import InputData.EditPlaylistInputData;
import Presenter.PlaylistPresenter;
import ViewModel.PlaylistViewModel;
import org.junit.Before;
import org.junit.Test;

public class EditPlaylistTests {

    @Before
    public void setUp(){
    }

    @Test
    public void addSong(){
        RegularUser BetterKanye = new RegularUser("BetterKanye","2007Kanye");
        Song testsong = new Song(999,null,null,null,null,null,null);
        Playlist KanyeNotBad = new Playlist(787,"When Kanye was good",BetterKanye);
        EditPlaylistInputData inputData = new EditPlaylistInputData(BetterKanye,KanyeNotBad,testsong);
        PlaylistViewModel testViewModel= new PlaylistViewModel();
        PlaylistPresenter testPresenter= new PlaylistPresenter(testViewModel);
        EditPlaylistInteractor testInteractor = new EditPlaylistInteractor(testPresenter);
        testInteractor.addSong(inputData);

        boolean actual = KanyeNotBad.getSongList().contains(testsong);
        boolean expected = true;
        assert actual == expected;
    }

    @Test
    public void RemoveSong(){
        RegularUser BetterKanye = new RegularUser("BetterKanye","2007Kanye");
        Song testsong = new Song(999,null,null,null,null,null,null);
        Playlist KanyeNotBad = new Playlist(787,"When Kanye was good",BetterKanye);
        EditPlaylistInputData inputData = new EditPlaylistInputData(BetterKanye,KanyeNotBad,testsong);
        PlaylistViewModel testViewModel= new PlaylistViewModel();
        PlaylistPresenter testPresenter= new PlaylistPresenter(testViewModel);
        EditPlaylistInteractor testInteractor = new EditPlaylistInteractor(testPresenter);
        testInteractor.addSong(inputData);
        testInteractor.removeSong(inputData);
        boolean actual = !KanyeNotBad.getSongList().contains(testsong);
        boolean expected = true;
        assert actual == expected;
    }
    @Test
    public void addSongConfirmationMessage(){
        RegularUser Acrid = new RegularUser("Acrid","PoisonDoggo");
        Song testsong = new Song(999,"Bingus",null,null,null,null,null);
        Playlist PoisonDogTypeBeat = new Playlist(787,"PoisonDogTypeBeat",Acrid);
        EditPlaylistInputData inputData = new EditPlaylistInputData(Acrid,PoisonDogTypeBeat,testsong);
        PlaylistViewModel testViewModel= new PlaylistViewModel();
        PlaylistPresenter testPresenter= new PlaylistPresenter(testViewModel);
        EditPlaylistInteractor testInteractor = new EditPlaylistInteractor(testPresenter);
        testInteractor.addSong(inputData);

        String actual = testPresenter.getOutputMessage();
        String expected = "Bingus added!";
        assert actual.equals(expected);
    }

    @Test
    public void RemoveSongConfirmationMessage(){
        RegularUser Acrid = new RegularUser("Acrid","PoisonDoggo");
        Song testsong = new Song(999,"Bingus",null,null,null,null,null);
        Playlist PoisonDogTypeBeat = new Playlist(787,"When PoisonDogTypeBeat was good",Acrid);
        EditPlaylistInputData inputData = new EditPlaylistInputData(Acrid,PoisonDogTypeBeat,testsong);
        PlaylistViewModel testViewModel= new PlaylistViewModel();
        PlaylistPresenter testPresenter= new PlaylistPresenter(testViewModel);
        EditPlaylistInteractor testInteractor = new EditPlaylistInteractor(testPresenter);
        testInteractor.addSong(inputData);
        testInteractor.removeSong(inputData);
        String actual = testPresenter.getOutputMessage();
        String expected = "Bingus removed!";
        assert actual.equals(expected);
    }
}
