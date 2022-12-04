package useCase;

import inputData.PlaySpaceInputData;
import inputData.SongInputData;
import outputBoundary.SongOutputBoundary;
import presenter.SongPresenter;
import view.InMemoryPlaylist;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * test PlaySpaceInteractor
 */

public class PlaySpaceTest {

    @Test
    public void testPlaySpaceOnSongExist(){
        SongInputData songInputData = new SongInputData(10);
        viewModel.MusicEngineViewModel mecv = new viewModel.MusicEngineViewModel(new InMemoryPlaylist());
        SongOutputBoundary spacePresenter = new SongPresenter(mecv);
        List<SongInputData> lst = new ArrayList<>();
        lst.add(songInputData);
        PlaySpaceInputData playSpaceInputData = new PlaySpaceInputData(lst);
        PlaySpaceInteractor playSpaceInteractor = new PlaySpaceInteractor(spacePresenter, playSpaceInputData);
        playSpaceInteractor.playSpace();
        // Assertions.assertTrue(MusicPlayer.getInstance().isPlaying());
    }

    @Test
    public void testPickRandomSong(){
        viewModel.MusicEngineViewModel mecv = new viewModel.MusicEngineViewModel(new InMemoryPlaylist());
        SongOutputBoundary spacePresenter = new SongPresenter(mecv);
        List<SongInputData> lst = new ArrayList<>();
        PlaySpaceInputData playSpaceInputData = new PlaySpaceInputData(lst);
        PlaySpaceInteractor playSpaceInteractor = new PlaySpaceInteractor(spacePresenter, playSpaceInputData);
        playSpaceInteractor.playSpace();
        // Assertions.assertTrue(MusicPlayer.getInstance().isPlaying());
    }
}
