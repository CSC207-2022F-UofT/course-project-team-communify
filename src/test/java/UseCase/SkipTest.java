package UseCase;

import Entities.MusicPlayer;
import InputData.playlistInputData;
import Presenter.songPresenter;
import View.InMemoryPlaylist;
import ViewModel.musicEngineControllerViewModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests the skip song use case.
 */
public class SkipTest {
    /**
     * Tests a single skip.
     */
    @Test
    public void testSkip(){
        MusicPlayer mp = MusicPlayer.getInstance();
        mp.close();
        playlistInputData p = new playlistInputData(0);

        playPlaylist play = new playPlaylist(new songPresenter(new musicEngineControllerViewModel(new InMemoryPlaylist())));
        play.play(p);
        Assertions.assertEquals(mp.getCurrentSong(), p.getSongs().get(0));

        NextSong skip = new NextSong(new songPresenter(new musicEngineControllerViewModel(new InMemoryPlaylist())), play);
        skip.updatePlaylist(p);
        skip.skipSong();
        Assertions.assertEquals(mp.getCurrentSong(), p.getSongs().get(1));
    }

    /**
     * Tests two skips.
     */
    @Test
    public void testSkipTwice(){
        MusicPlayer mp = MusicPlayer.getInstance();
        mp.close();
        playlistInputData p = new playlistInputData(0);

        playPlaylist play = new playPlaylist(new songPresenter(new musicEngineControllerViewModel(new InMemoryPlaylist())));
        play.play(p);
        Assertions.assertEquals(mp.getCurrentSong(), p.getSongs().get(0));

        NextSong skip = new NextSong(new songPresenter(new musicEngineControllerViewModel(new InMemoryPlaylist())), play);
        skip.updatePlaylist(p);
        skip.skipSong();
        skip.skipSong();
        System.out.println(mp.getCurrentSong().getName());
        System.out.println(p.getSongs().get(2).getName());
        Assertions.assertEquals(mp.getCurrentSong(), p.getSongs().get(2));
    }
}
