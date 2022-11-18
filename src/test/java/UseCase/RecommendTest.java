package UseCase;

import Entities.MusicPlayer;
import Entities.Song;
import InputData.playlistInputData;
import Presenter.songPresenter;
import ViewModel.musicEngineControllerViewModel;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class RecommendTest {
    @Before
    public void setUp(){
    }

    @Test
    public void testRecommend(){
        MusicPlayer mp = MusicPlayer.getInstance();
        playlistInputData p = new playlistInputData(0);

        ArrayList<String> genres = new ArrayList<>();

        for (Song s : p.getSongs()){
            genres.add(s.getGenre());
        }

        recommendSong recommend = new recommendSong(p, new songPresenter(new musicEngineControllerViewModel()));
        recommend.recommendation();
        Assertions.assertTrue(genres.contains(mp.getCurrentSong().getGenre()));
    }
}
