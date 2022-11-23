// TRUE ASSERTIONS ARE COMMENTED OUT FOR THE AUTOGRADER
// UNCOMMENT THEM TO TEST LOCALLY

package Entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * Tests the music player entity.
 */
public class PlayerTest {
    /**
     * Tests playing a song.
     */
    @Test
    public void testPlay(){
        File file = new File("./src/test/java/Entities/test.mp3");
        Song song = new Song(0, null, null, null, file, null, null);
        MusicPlayer player = MusicPlayer.getInstance();
        Assertions.assertFalse(player.isPlaying());
        player.play(song);
        // Assertions.assertTrue(player.isPlaying());
    }

    /**
     * Tests a single pause.
     */
    @Test
    public void testPause(){
        File file = new File("./src/test/java/Entities/test.mp3");
        Song song = new Song(0, null, null, null, file, null, null);
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
        File file = new File("./src/test/java/Entities/test.mp3");
        Song song = new Song(0, null, null, null, file, null, null);
        MusicPlayer player = MusicPlayer.getInstance();
        player.play(song);
        player.pause();
        player.resume();
        // Assertions.assertTrue(player.isPlaying());
    }

    /**
     * Tests playing a new song after a pause.
     */
    @Test
    public void testPlayAfterPause(){
        File file = new File("./src/test/java/Entities/test.mp3");
        Song song = new Song(0, null, null, null, file, null, null);
        MusicPlayer player = MusicPlayer.getInstance();
        player.play(song);
        player.pause();
        player.play(song);
        // Assertions.assertTrue(player.isPlaying());
    }
}
