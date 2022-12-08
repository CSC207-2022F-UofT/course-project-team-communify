package controller;

import entities.MusicPlayer;
import entities.Song;
import inputData.PlaylistInputData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import presenter.SongPresenter;
import presenter.SpacePresenter;
import view.InMemoryPlaylist;

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

        Assertions.assertTrue(genres.contains(mp.getCurrentSong().getGenre()));
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

        controller.playSong(5376);

        Assertions.assertNotNull(mp.getCurrentSong());
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
        Assertions.assertFalse(mp.isPlaying());
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

        controller.playPlaylist(0);

        Assertions.assertNotNull(mp.getCurrentSong());

        controller.pauseSong();
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
        PlaylistInputData p = new PlaylistInputData(1);

        controller.playPlaylist(0);
        controller.playNext();

        Assertions.assertNotEquals(mp.getCurrentSong().getName(), p.getSongs().get(0).getName());
    }

    /**
     * tests playing a space
     */
    @Test
    public void testPlaySpace(){
        MusicPlayer mp = MusicPlayer.getInstance();
        MusicEngineController controller = new MusicEngineController(new SpacePresenter(new viewModel.MusicEngineViewModel(new InMemoryPlaylist())),
                new SongPresenter(new viewModel.MusicEngineViewModel(new InMemoryPlaylist())));
        controller.playSpace();
        Assertions.assertNotNull(mp.getCurrentSong());
    }

}
