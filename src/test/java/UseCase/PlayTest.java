package UseCase;

import Entities.MusicPlayer;
import InputData.songInputData;
import Presenter.songPresenter;
import View.InMemoryPlaylist;
import ViewModel.musicEngineControllerViewModel;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayTest {
    @Before
    public void setUp(){
    }

    @Test
    public void testPlay(){
        MusicPlayer mp = MusicPlayer.getInstance();
        mp.close();
        playSongInteractor player = new playSongInteractor(new songPresenter(new musicEngineControllerViewModel(new InMemoryPlaylist())));
        player.playSong(new songInputData(2));
        Assertions.assertTrue(mp.isPlaying());
        Assertions.assertEquals(mp.getCurrentSong(), new songInputData(2).getSong());
    }
}
