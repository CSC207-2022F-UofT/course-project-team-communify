package controller;

import entities.MusicPlayer;
import entities.Song;
import inputData.PlaylistInputData;
import inputData.SongInputData;
import presenter.SongPresenter;
import presenter.SpacePresenter;
import view.InMemoryPlaylist;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * Tests the music engine controller.
 */
public class MusicEngineControllerTest {
    /**
     * Tests the recommendation use case call.
     */
    @Test
    public void testRecommend(){
        MusicPlayer mp = MusicPlayer.getInstance();
        mp.close();
        MusicEngineController controller = new MusicEngineController(new SpacePresenter(new viewModel.MusicEngineViewModel(new InMemoryPlaylist())),
                new SongPresenter(new viewModel.MusicEngineViewModel(new InMemoryPlaylist())));
        PlaylistInputData p = new PlaylistInputData(0);

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
        MusicEngineController controller = new MusicEngineController(new SpacePresenter(new viewModel.MusicEngineViewModel(new InMemoryPlaylist())),
                new SongPresenter(new viewModel.MusicEngineViewModel(new InMemoryPlaylist())));
        SongInputData s = new SongInputData(2);

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
        MusicEngineController controller = new MusicEngineController(new SpacePresenter(new viewModel.MusicEngineViewModel(new InMemoryPlaylist())),
                new SongPresenter(new viewModel.MusicEngineViewModel(new InMemoryPlaylist())));
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
        MusicEngineController controller = new MusicEngineController(new SpacePresenter(new viewModel.MusicEngineViewModel(new InMemoryPlaylist())),
                new SongPresenter(new viewModel.MusicEngineViewModel(new InMemoryPlaylist())));
        PlaylistInputData p = new PlaylistInputData(0);

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
        MusicEngineController controller = new MusicEngineController(new SpacePresenter(new viewModel.MusicEngineViewModel(new InMemoryPlaylist())),
                new SongPresenter(new viewModel.MusicEngineViewModel(new InMemoryPlaylist())));
        PlaylistInputData p = new PlaylistInputData(0);

        controller.playPlaylist(0);
        controller.playNext();

        // Assertions.assertTrue(mp.isPlaying());
        // Assertions.assertEquals(mp.getCurrentSong().getName(), p.getSongs().get(1).getName());
    }

    @Test
    public void testPlaySpace(){
        MusicPlayer mp = MusicPlayer.getInstance();
        MusicEngineController controller = new MusicEngineController(new SpacePresenter(new viewModel.MusicEngineViewModel(new InMemoryPlaylist())),
                new SongPresenter(new viewModel.MusicEngineViewModel(new InMemoryPlaylist())));
        controller.playSpace();
        // Assertions.assertTrue(mp.isPlaying());
    }

}
