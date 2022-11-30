package UseCase;

import Entities.MusicPlayer;
import InputData.playSpaceInputData;
import InputData.songInputData;
import OutputBoundary.songOutputBoundary;
import Presenter.songPresenter;
import View.InMemoryPlaylist;
import ViewModel.musicEngineControllerViewModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * test PlaySpaceInteractor
 */

public class PlaySpaceTests {

    @Test
    public void testPlaySpaceOnSongExist(){
        songInputData songInputData = new songInputData(10);
        musicEngineControllerViewModel mecv = new musicEngineControllerViewModel(new InMemoryPlaylist());
        songOutputBoundary spacePresenter = new songPresenter(mecv);
        List<songInputData> lst = new ArrayList<>();
        lst.add(songInputData);
        playSpaceInputData playSpaceInputData = new playSpaceInputData(lst);
        playSpaceInteractor playSpaceInteractor = new playSpaceInteractor(spacePresenter, playSpaceInputData);
        playSpaceInteractor.playSpace();
        // Assertions.assertTrue(MusicPlayer.getInstance().isPlaying());
    }

    @Test
    public void testPickRandomSong(){
        musicEngineControllerViewModel mecv = new musicEngineControllerViewModel(new InMemoryPlaylist());
        songOutputBoundary spacePresenter = new songPresenter(mecv);
        List<songInputData> lst = new ArrayList<>();
        playSpaceInputData playSpaceInputData = new playSpaceInputData(lst);
        playSpaceInteractor playSpaceInteractor = new playSpaceInteractor(spacePresenter, playSpaceInputData);
        playSpaceInteractor.playSpace();
        // Assertions.assertTrue(MusicPlayer.getInstance().isPlaying());
    }
}
