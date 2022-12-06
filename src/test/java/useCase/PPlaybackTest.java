// TRUE ASSERTIONS ARE COMMENTED OUT FOR THE AUTOGRADER
// UNCOMMENT THEM TO TEST LOCALLY

package useCase;

import entities.MusicPlayer;
import inputData.PlaylistInputData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import presenter.SongPresenter;
import view.InMemoryPlaylist;
/**
 * Tests the play playlist use case.
 */
public class PPlaybackTest {
    /**
     * Tests playing a playlist.
     */
    @Test
    public void testPlay(){
        MusicPlayer.getInstance().close();
        PlaylistInputData p = new PlaylistInputData(0);
        PlayPlaylistInteractor play = new PlayPlaylistInteractor(new SongPresenter(new viewModel.MusicEngineViewModel(new InMemoryPlaylist())));

        play.play(p);
        Assertions.assertNotNull(MusicPlayer.getInstance().getCurrentSong());
    }

    /**
     * Tests stopping the playlist queue.
     */
    @Test
    public void testStopQueue(){
        MusicPlayer.getInstance().close();
        PlaylistInputData p = new PlaylistInputData(0);
        PlayPlaylistInteractor play = new PlayPlaylistInteractor(new SongPresenter(new viewModel.MusicEngineViewModel(new InMemoryPlaylist())));

        play.play(p);
        play.stopQueue();
        Assertions.assertTrue(play.play(p));
    }
}
