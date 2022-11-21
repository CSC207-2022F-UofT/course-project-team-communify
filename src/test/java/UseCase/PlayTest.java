package UseCase;

import Entities.MusicPlayer;
import Entities.Song;
import InputData.songInputData;
import Presenter.songPresenter;
import View.InMemoryPlaylist;
import ViewModel.musicEngineControllerViewModel;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

public class PlayTest {
    @Before
    public void setUp(){
    }

    @Test
    public void testPlay(){
        MusicPlayer mp = MusicPlayer.getInstance();
        File file = new File("./src/test/java/UseCase/test1.mp3");
        Song song = new Song(0, null, null, null, file, null, null);

        playSongInteractor player = new playSongInteractor(new songPresenter(new musicEngineControllerViewModel(new InMemoryPlaylist())));
        player.playSong(new songInputData(song));
        Assertions.assertTrue(mp.isPlaying());
        Assertions.assertEquals(mp.getCurrentSong(), song);
    }
}
