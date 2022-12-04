package useCase;

import entities.MusicPlayer;
import entities.Song;
import inputData.PlaylistInputData;
import presenter.SongPresenter;
import view.InMemoryPlaylist;
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

        RecommendSongInteractor recommend = new RecommendSongInteractor(new SongPresenter(new viewModel.MusicEngineViewModel(new InMemoryPlaylist())));
        recommend.recommendation(p);
        Assertions.assertTrue(genres.contains(mp.getCurrentSong().getGenre()));
    }
}
