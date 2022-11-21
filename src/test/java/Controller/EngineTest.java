package Controller;

import Entities.MusicPlayer;
import Entities.Song;
import InputData.playlistInputData;
import InputData.songInputData;
import Presenter.songPresenter;
import Presenter.spacePresenter;
import View.InMemoryPlaylist;
import ViewModel.musicEngineControllerViewModel;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class EngineTest {
    @Before
    public void setUp(){
    }

    @Test
    public void testRecommend(){
        MusicPlayer mp = MusicPlayer.getInstance();
        musicEngineController controller = new musicEngineController(new spacePresenter(new musicEngineControllerViewModel(new InMemoryPlaylist())),
                new songPresenter(new musicEngineControllerViewModel(new InMemoryPlaylist())));
        playlistInputData p = new playlistInputData(0);

        ArrayList<String> genres = new ArrayList<>();

        for (Song s : p.getSongs()){
            genres.add(s.getGenre());
        }

        controller.playRecommendation(0);

        Assertions.assertTrue(mp.isPlaying());
        Assertions.assertTrue(genres.contains(mp.getCurrentSong().getGenre()));
    }

    @Test
    public void testPlay(){
        MusicPlayer mp = MusicPlayer.getInstance();
        musicEngineController controller = new musicEngineController(new spacePresenter(new musicEngineControllerViewModel(new InMemoryPlaylist())),
                new songPresenter(new musicEngineControllerViewModel(new InMemoryPlaylist())));
        songInputData s = new songInputData(2);

        controller.playSong(2);

        Assertions.assertTrue(mp.isPlaying());
        Assertions.assertEquals(mp.getCurrentSong(), s.getSong());
    }

    @Test
    public void testPause(){
        MusicPlayer mp = MusicPlayer.getInstance();
        musicEngineController controller = new musicEngineController(new spacePresenter(new musicEngineControllerViewModel(new InMemoryPlaylist())),
                new songPresenter(new musicEngineControllerViewModel(new InMemoryPlaylist())));
        controller.playSong(2);

        controller.pauseSong();
        Assertions.assertFalse(mp.isPlaying());

        controller.pauseSong();
        Assertions.assertTrue(mp.isPlaying());
    }

    @Test
    public void testPlayPlaylist(){
        MusicPlayer mp = MusicPlayer.getInstance();
        musicEngineController controller = new musicEngineController(new spacePresenter(new musicEngineControllerViewModel(new InMemoryPlaylist())),
                new songPresenter(new musicEngineControllerViewModel(new InMemoryPlaylist())));
        playlistInputData p = new playlistInputData(0);

        controller.playPlaylist(0);

        Assertions.assertTrue(mp.isPlaying());
        Assertions.assertEquals(mp.getCurrentSong(), p.getSongs().get(0));
    }

    @Test
    public void testPlayNext(){
        MusicPlayer mp = MusicPlayer.getInstance();
        musicEngineController controller = new musicEngineController(new spacePresenter(new musicEngineControllerViewModel(new InMemoryPlaylist())),
                new songPresenter(new musicEngineControllerViewModel(new InMemoryPlaylist())));
        playlistInputData p = new playlistInputData(0);

        controller.playPlaylist(0);
        controller.playNext();

        Assertions.assertTrue(mp.isPlaying());
        Assertions.assertEquals(mp.getCurrentSong(), p.getSongs().get(1));
    }
}
