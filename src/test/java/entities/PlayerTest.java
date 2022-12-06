
package entities;

import inputData.SongInputData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests the music player entity.
 */
public class PlayerTest {
    /**
     * Tests playing a song.
     */
    @Test
    public void testPlay(){
        Song song = new SongInputData(10).getSong();
        MusicPlayer player = MusicPlayer.getInstance();
        player.play(song);
        Assertions.assertTrue(player.isPlaying());
    }

    /**
     * Tests a single pause.
     */
    @Test
    public void testPause(){
        Song song = new SongInputData(10).getSong();
        MusicPlayer player = MusicPlayer.getInstance();
        player.play(song);
        player.pause();
        Assertions.assertFalse(player.isPlaying());
    }

    /**
     * Tests a single resume.
     */
    @Test
    public void testResume(){
        Song song = new SongInputData(10).getSong();
        MusicPlayer player = MusicPlayer.getInstance();
        player.play(song);
        player.pause();
        player.resume();
        Assertions.assertTrue(player.isPlaying());
    }

    /**
     * Tests playing a new song after a pause.
     */
    @Test
    public void testPlayAfterPause(){
        Song song = new SongInputData(10).getSong();
        MusicPlayer player = MusicPlayer.getInstance();
        player.play(song);
        player.pause();
        player.play(song);
        Assertions.assertTrue(player.isPlaying());
    }
}
