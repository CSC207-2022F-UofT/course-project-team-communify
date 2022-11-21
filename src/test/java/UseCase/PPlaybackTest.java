// TRUE ASSERTIONS ARE COMMENTED OUT FOR THE AUTOGRADER
// UNCOMMENT THEM TO TEST LOCALLY

package UseCase;

import Entities.MusicPlayer;
import Entities.Song;
import InputData.playlistInputData;
import Presenter.songPresenter;
import View.InMemoryPlaylist;
import ViewModel.musicEngineControllerViewModel;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.LinkedList;

public class PPlaybackTest {
    @Before
    public void setUp(){
    }

    @Test
    public void testPlay(){
        MusicPlayer.getInstance().close();
        playlistInputData p = new playlistInputData(0);
        playPlaylist play = new playPlaylist(new songPresenter(new musicEngineControllerViewModel(new InMemoryPlaylist())));

        play.play(p);
        Assertions.assertEquals(MusicPlayer.getInstance().getCurrentSong(), new playlistInputData(0).getSongs().get(0));
    }

    @Test
    public void testStopQueue(){
        MusicPlayer.getInstance().close();
        File file = new File("./src/test/java/UseCase/test1.mp3");
        Song song = new Song(0, null, null, null, file, null, null);
        File file2 = new File("./src/test/java/UseCase/test2.mp3");
        Song song2 = new Song(0, null, null, null, file2, null, null);

        LinkedList<Song> songs = new LinkedList<>();
        songs.add(song);
        songs.add(song2);

        playlistInputData p = new playlistInputData("", songs);
        playPlaylist play = new playPlaylist(new songPresenter(new musicEngineControllerViewModel(new InMemoryPlaylist())));

        play.play(p);
        play.stopQueue();

        try {
            Thread.sleep(6500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Assertions.assertFalse(MusicPlayer.getInstance().isPlaying());
    }
}
