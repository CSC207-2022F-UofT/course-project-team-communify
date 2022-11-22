package UseCase;

import Entities.MusicPlayer;
import Entities.Song;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

public class PauseTest {
    @Before
    public void setUp(){
    }

    @Test
    public void testPause(){
        File file = new File("./src/test/java/UseCase/test1.mp3");
        Song song = new Song(0, null, null, null, file, null, null);
        MusicPlayer mp = MusicPlayer.getInstance();
        mp.play(song);

        pauseSong pause = new pauseSong();
        pause.pause();
        // Assertions.assertFalse(MusicPlayer.getInstance().isPlaying());
    }

    @Test
    public void testResume(){
        File file = new File("./src/test/java/UseCase/test1.mp3");
        Song song = new Song(0, null, null, null, file, null, null);
        MusicPlayer mp = MusicPlayer.getInstance();
        mp.play(song);
        mp.pause();

        pauseSong pause = new pauseSong();
        pause.pause();
        // Assertions.assertTrue(MusicPlayer.getInstance().isPlaying());
    }

    @Test
    public void testPauseWhenNothingPlaying(){
        MusicPlayer.getInstance().close();
        pauseSong pause = new pauseSong();
        pause.pause();
        // Assertions.assertFalse(MusicPlayer.getInstance().isPlaying());
    }


}
