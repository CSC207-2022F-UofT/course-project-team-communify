package UseCase;

import Entities.MusicPlayer;
import Entities.Song;
import InputData.PlaylistInputData;
import Presenter.SongPresenter;
import View.InMemoryPlaylist;
import ViewModel.MusicEngineControllerViewModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * Tests recommend song use case.
 */
public class RecommendTest {
    /**
     * Tests recommending a song.
     */
    @Test
    public void testRecommend(){
        MusicPlayer mp = MusicPlayer.getInstance();
        PlaylistInputData p = new PlaylistInputData(0);

        ArrayList<String> genres = new ArrayList<>();

        for (Song s : p.getSongs()){
            genres.add(s.getGenre());
        }

        RecommendSong recommend = new RecommendSong(new SongPresenter(new MusicEngineControllerViewModel(new InMemoryPlaylist())));
        recommend.recommendation(p);
        Assertions.assertTrue(genres.contains(mp.getCurrentSong().getGenre()));
    }
}
