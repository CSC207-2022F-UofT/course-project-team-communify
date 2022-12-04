package useCase;

import entities.MusicPlayer;
import inputData.PlaylistInputData;
import presenter.SongPresenter;
import view.InMemoryPlaylist;
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

        PlayPlaylistInteractor play = new PlayPlaylistInteractor(new SongPresenter(new viewModel.MusicEngineViewModel(new InMemoryPlaylist())));
        play.play(p);
        Assertions.assertEquals(mp.getCurrentSong(), p.getSongs().get(0));

        NextSongInteractor skip = new NextSongInteractor(new SongPresenter(new viewModel.MusicEngineViewModel(new InMemoryPlaylist())), play);
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

        PlayPlaylistInteractor play = new PlayPlaylistInteractor(new SongPresenter(new viewModel.MusicEngineViewModel(new InMemoryPlaylist())));
        play.play(p);
        Assertions.assertEquals(mp.getCurrentSong(), p.getSongs().get(0));

        NextSongInteractor skip = new NextSongInteractor(new SongPresenter(new viewModel.MusicEngineViewModel(new InMemoryPlaylist())), play);
        skip.updatePlaylist(p);
        skip.skipSong();
        skip.skipSong();
        System.out.println(mp.getCurrentSong().getName());
        System.out.println(p.getSongs().get(2).getName());
        Assertions.assertEquals(mp.getCurrentSong(), p.getSongs().get(2));
    }
}
