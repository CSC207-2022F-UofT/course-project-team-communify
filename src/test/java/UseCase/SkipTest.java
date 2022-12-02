package UseCase;

import Entities.MusicPlayer;
import InputData.PlaylistInputData;
import Presenter.SongPresenter;
import View.InMemoryPlaylist;
import ViewModel.MusicEngineControllerViewModel;
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
        PlaylistInputData p = new PlaylistInputData(0);

        PlayPlaylist play = new PlayPlaylist(new SongPresenter(new MusicEngineControllerViewModel(new InMemoryPlaylist())));
        play.play(p);
        Assertions.assertEquals(mp.getCurrentSong(), p.getSongs().get(0));

        NextSong skip = new NextSong(new SongPresenter(new MusicEngineControllerViewModel(new InMemoryPlaylist())), play);
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
        PlaylistInputData p = new PlaylistInputData(0);

        PlayPlaylist play = new PlayPlaylist(new SongPresenter(new MusicEngineControllerViewModel(new InMemoryPlaylist())));
        play.play(p);
        Assertions.assertEquals(mp.getCurrentSong(), p.getSongs().get(0));

        NextSong skip = new NextSong(new SongPresenter(new MusicEngineControllerViewModel(new InMemoryPlaylist())), play);
        skip.updatePlaylist(p);
        skip.skipSong();
        skip.skipSong();
        System.out.println(mp.getCurrentSong().getName());
        System.out.println(p.getSongs().get(2).getName());
        Assertions.assertEquals(mp.getCurrentSong(), p.getSongs().get(2));
    }
}
