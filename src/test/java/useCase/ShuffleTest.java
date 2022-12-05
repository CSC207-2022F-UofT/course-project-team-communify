package useCase;

import entities.MusicPlayer;
import inputData.PlaylistInputData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import presenter.SongPresenter;
import view.InMemoryPlaylist;

/**
 * Tests for the play song use case.
 */
public class ShuffleTest {
    /**
     * Tests playing a song.
     */
    @Test
    public void testShuffle(){
        MusicPlayer mp = MusicPlayer.getInstance();
        mp.close();
        ShufflePlaylistInteractor player = new ShufflePlaylistInteractor(new SongPresenter(new viewModel.MusicEngineViewModel(new InMemoryPlaylist())));
        player.shuffle(new PlaylistInputData(0));
        Assertions.assertTrue(mp.isPlaying());
    }
}
