package UseCase;

import Entities.MusicPlayer;
import InputData.SongInputData;
import Presenter.SongPresenter;
import View.InMemoryPlaylist;
import ViewModel.MusicEngineControllerViewModel;
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
        PlaySongInteractor player = new PlaySongInteractor(new SongPresenter(new MusicEngineControllerViewModel(new InMemoryPlaylist())));
        player.playSong(new SongInputData(2));
        Assertions.assertEquals(mp.getCurrentSong(), new SongInputData(2).getSong());
    }
}
