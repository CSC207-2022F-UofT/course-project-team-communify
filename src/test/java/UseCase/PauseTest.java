package useCase;

import entities.MusicPlayer;
import entities.Song;
import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * Tests the pause song use case.
 */
public class PauseTest {
    /**
     * Tests a single pause.
     */
    @Test
    public void testPause(){
        File file = new File("./src/test/java/UseCase/test1.mp3");
        Song song = new Song(0, null, null, null, file, null, null);
        MusicPlayer mp = MusicPlayer.getInstance();
        mp.play(song);

        PauseSongInteractor pause = new PauseSongInteractor();
        pause.pause();
        // Assertions.assertFalse(MusicPlayer.getInstance().isPlaying());
    }

    /**
     * Tests a single resume.
     */
    @Test
    public void testResume(){
        File file = new File("./src/test/java/UseCase/test1.mp3");
        Song song = new Song(0, null, null, null, file, null, null);
        MusicPlayer mp = MusicPlayer.getInstance();
        mp.play(song);
        mp.pause();

        PauseSongInteractor pause = new PauseSongInteractor();
        pause.pause();
        // Assertions.assertTrue(MusicPlayer.getInstance().isPlaying());
    }

    /**
     * Tests a single pause when there is nothing playing.
     */
    @Test
    public void testPauseWhenNothingPlaying(){
        MusicPlayer.getInstance().close();
        PauseSongInteractor pause = new PauseSongInteractor();
        pause.pause();
        // Assertions.assertFalse(MusicPlayer.getInstance().isPlaying());
    }


}
