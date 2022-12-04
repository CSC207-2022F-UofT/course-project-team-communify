package useCase;

import entities.MusicPlayer;
import inputData.SongInputData;
import presenter.SongPresenter;
import view.InMemoryPlaylist;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests for the play song use case.
 */
public class PlayTest {
    /**
     * Tests playing a song.
     */
    @Test
    public void testPlay(){
        MusicPlayer mp = MusicPlayer.getInstance();
        mp.close();
        PlaySongInteractor player = new PlaySongInteractor(new SongPresenter(new viewModel.MusicEngineViewModel(new InMemoryPlaylist())));
        player.playSong(new SongInputData(2));
        Assertions.assertEquals(mp.getCurrentSong(), new SongInputData(2).getSong());
    }
}
