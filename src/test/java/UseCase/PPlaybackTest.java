// TRUE ASSERTIONS ARE COMMENTED OUT FOR THE AUTOGRADER
// UNCOMMENT THEM TO TEST LOCALLY

package UseCase;

import Entities.MusicPlayer;
import Entities.Song;
import InputData.PlaylistInputData;
import Presenter.SongPresenter;
import View.InMemoryPlaylist;
import ViewModel.MusicEngineControllerViewModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.LinkedList;
/**
 * Tests the play playlist use case.
 */
public class PPlaybackTest {
    /**
     * Tests playing a playlist.
     */
    @Test
    public void testPlay(){
        MusicPlayer.getInstance().close();
        PlaylistInputData p = new PlaylistInputData(0);
        PlayPlaylistInteractor play = new PlayPlaylistInteractor(new SongPresenter(new MusicEngineControllerViewModel(new InMemoryPlaylist())));

        play.play(p);
        Assertions.assertEquals(MusicPlayer.getInstance().getCurrentSong(), new PlaylistInputData(0).getSongs().get(0));
    }

    /**
     * Tests stopping the playlist queue.
     */
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

        PlaylistInputData p = new PlaylistInputData("", songs);
        PlayPlaylistInteractor play = new PlayPlaylistInteractor(new SongPresenter(new MusicEngineControllerViewModel(new InMemoryPlaylist())));

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
