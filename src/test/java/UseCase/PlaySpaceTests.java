package UseCase;

import InputData.PlaySpaceInputData;
import InputData.SongInputData;
import OutputBoundary.SongOutputBoundary;
import Presenter.SongPresenter;
import View.InMemoryPlaylist;
import ViewModel.MusicEngineControllerViewModel;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * test PlaySpaceInteractor
 */

public class PlaySpaceTests {

    @Test
    public void testPlaySpaceOnSongExist(){
        SongInputData songInputData = new SongInputData(10);
        MusicEngineControllerViewModel mecv = new MusicEngineControllerViewModel(new InMemoryPlaylist());
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
        MusicEngineControllerViewModel mecv = new MusicEngineControllerViewModel(new InMemoryPlaylist());
        SongOutputBoundary spacePresenter = new SongPresenter(mecv);
        List<SongInputData> lst = new ArrayList<>();
        PlaySpaceInputData playSpaceInputData = new PlaySpaceInputData(lst);
        PlaySpaceInteractor playSpaceInteractor = new PlaySpaceInteractor(spacePresenter, playSpaceInputData);
        playSpaceInteractor.playSpace();
        // Assertions.assertTrue(MusicPlayer.getInstance().isPlaying());
    }
}
