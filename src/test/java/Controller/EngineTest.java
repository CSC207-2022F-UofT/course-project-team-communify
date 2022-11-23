package Controller;

import Entities.MusicPlayer;
import Entities.Song;
import InputData.playlistInputData;
import InputData.songInputData;
import Presenter.songPresenter;
import Presenter.spacePresenter;
import View.InMemoryPlaylist;
import ViewModel.musicEngineControllerViewModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * Tests the music engine controller.
 */
public class EngineTest {
    /**
     * Tests the recommendation use case call.
     */
    @Test
    public void testRecommend(){
        MusicPlayer mp = MusicPlayer.getInstance();
        mp.close();
        musicEngineController controller = new musicEngineController(new spacePresenter(new musicEngineControllerViewModel(new InMemoryPlaylist())),
                new songPresenter(new musicEngineControllerViewModel(new InMemoryPlaylist())));
        playlistInputData p = new playlistInputData(0);

        ArrayList<String> genres = new ArrayList<>();

        for (Song s : p.getSongs()){
            genres.add(s.getGenre());
        }

        controller.playRecommendation(0);

        // Assertions.assertTrue(mp.isPlaying());
        // Assertions.assertTrue(genres.contains(mp.getCurrentSong().getGenre()));
    }

    /**
     * Tests the play song use case call.
     */
    @Test
    public void testPlay(){
        MusicPlayer mp = MusicPlayer.getInstance();
        mp.close();
        musicEngineController controller = new musicEngineController(new spacePresenter(new musicEngineControllerViewModel(new InMemoryPlaylist())),
                new songPresenter(new musicEngineControllerViewModel(new InMemoryPlaylist())));
        songInputData s = new songInputData(2);

        controller.playSong(2);

        // Assertions.assertTrue(mp.isPlaying());
        // Assertions.assertEquals(mp.getCurrentSong(), s.getSong());
    }

    /**
     * Tests the pause/resume use case call.
     */
    @Test
    public void testPause(){
        MusicPlayer mp = MusicPlayer.getInstance();
        mp.close();
        musicEngineController controller = new musicEngineController(new spacePresenter(new musicEngineControllerViewModel(new InMemoryPlaylist())),
                new songPresenter(new musicEngineControllerViewModel(new InMemoryPlaylist())));
        controller.playSong(2);

        controller.pauseSong();
        // Assertions.assertFalse(mp.isPlaying());

        controller.pauseSong();
        // Assertions.assertTrue(mp.isPlaying());
    }

    /**
     * Tests the play playlist use case call.
     */
    @Test
    public void testPlayPlaylist(){
        MusicPlayer mp = MusicPlayer.getInstance();
        mp.close();
        musicEngineController controller = new musicEngineController(new spacePresenter(new musicEngineControllerViewModel(new InMemoryPlaylist())),
                new songPresenter(new musicEngineControllerViewModel(new InMemoryPlaylist())));
        playlistInputData p = new playlistInputData(0);

        controller.playPlaylist(0);

        // Assertions.assertTrue(mp.isPlaying());
        // Assertions.assertEquals(mp.getCurrentSong(), p.getSongs().get(0));
    }

    /**
     * Tests the skip song use case call.
     */
    @Test
    public void testPlayNext(){
        MusicPlayer mp = MusicPlayer.getInstance();
        mp.close();
        musicEngineController controller = new musicEngineController(new spacePresenter(new musicEngineControllerViewModel(new InMemoryPlaylist())),
                new songPresenter(new musicEngineControllerViewModel(new InMemoryPlaylist())));
        playlistInputData p = new playlistInputData(0);

        controller.playPlaylist(0);
        controller.playNext();

        // Assertions.assertTrue(mp.isPlaying());
        // Assertions.assertEquals(mp.getCurrentSong().getName(), p.getSongs().get(1).getName());
    }
}
