package useCase;

import entities.MusicPlayer;
import entities.Song;
import inputData.SongInputData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests the pause song use case.
 */
public class PauseTest {
    /**
     * Tests a single pause.
     */
    @Test
    public void testPause(){
        Song song = new SongInputData(10).getSong();
        MusicPlayer mp = MusicPlayer.getInstance();
        mp.close();
        mp.play(song);

        PauseSongInteractor pause = new PauseSongInteractor();
        pause.pause();
        Assertions.assertFalse(MusicPlayer.getInstance().isPlaying());
    }

    /**
     * Tests a single resume.
     */
    @Test
    public void testResume(){
        Song song = new SongInputData(10).getSong();
        MusicPlayer mp = MusicPlayer.getInstance();
        mp.close();
        mp.play(song);
        mp.pause();

        PauseSongInteractor pause = new PauseSongInteractor();
        pause.pause();
        Assertions.assertTrue(MusicPlayer.getInstance().isPlaying());
    }

    /**
     * Tests a single pause when there is nothing playing.
     */
    @Test
    public void testPauseWhenNothingPlaying(){
        MusicPlayer.getInstance().close();
        PauseSongInteractor pause = new PauseSongInteractor();
        pause.pause();
        Assertions.assertFalse(MusicPlayer.getInstance().isPlaying());
    }


}
