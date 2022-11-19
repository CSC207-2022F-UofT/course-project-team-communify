package UseCase;

import Entities.MusicPlayer;
import InputData.playlistInputData;
import Presenter.songPresenter;
import ViewModel.musicEngineControllerViewModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SkipTest {
    @Test
    public void testSkip(){
        MusicPlayer mp = MusicPlayer.getInstance();
        playlistInputData p = new playlistInputData(0);

        playPlaylist play = new playPlaylist(new songPresenter(new musicEngineControllerViewModel()));
        play.play(p);
        Assertions.assertEquals(mp.getCurrentSong(), p.getSongs().get(0));

        NextSong skip = new NextSong(new songPresenter(new musicEngineControllerViewModel()));
        skip.updatePlaylist(p);
        skip.skipSong();
        Assertions.assertEquals(mp.getCurrentSong(), p.getSongs().get(1));
    }

    @Test
    public void testSkipTwice(){
        MusicPlayer mp = MusicPlayer.getInstance();
        playlistInputData p = new playlistInputData(0);

        playPlaylist play = new playPlaylist(new songPresenter(new musicEngineControllerViewModel()));
        play.play(p);
        Assertions.assertEquals(mp.getCurrentSong(), p.getSongs().get(0));

        NextSong skip = new NextSong(new songPresenter(new musicEngineControllerViewModel()));
        skip.updatePlaylist(p);
        skip.skipSong();
        skip.skipSong();
        Assertions.assertEquals(mp.getCurrentSong(), p.getSongs().get(2));
    }
}
