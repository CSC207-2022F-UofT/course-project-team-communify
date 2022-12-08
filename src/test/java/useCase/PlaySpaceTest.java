package useCase;

import entities.MusicPlayer;
import inputData.PlaySpaceInputData;
import inputData.SongInputData;
import org.junit.jupiter.api.Assertions;
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

    /**
     * tests playing a space when a song is in the queue
     */
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
        Assertions.assertEquals(MusicPlayer.getInstance().getCurrentSong(), songInputData.getSong());
    }

    /**
     * tests picking a random song
     */
    @Test
    public void testPickRandomSong(){
        viewModel.MusicEngineViewModel mecv = new viewModel.MusicEngineViewModel(new InMemoryPlaylist());
        SongOutputBoundary spacePresenter = new SongPresenter(mecv);
        List<SongInputData> lst = new ArrayList<>();
        PlaySpaceInputData playSpaceInputData = new PlaySpaceInputData(lst);
        PlaySpaceInteractor playSpaceInteractor = new PlaySpaceInteractor(spacePresenter, playSpaceInputData);
        playSpaceInteractor.playSpace();
        Assertions.assertNotNull(MusicPlayer.getInstance().getCurrentSong());
    }
}
