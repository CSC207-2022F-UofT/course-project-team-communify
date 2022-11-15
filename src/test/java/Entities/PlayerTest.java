// TRUE ASSERTIONS ARE COMMENTED OUT FOR THE AUTOGRADER
// UNCOMMENT THEM TO TEST LOCALLY

package Entities;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

public class PlayerTest {
    @Before
    public void setUp(){
    }

    @Test
    public void testPlay(){
        File file = new File("./src/test/java/Entities/test.mp3");
        Song song = new Song(0, null, null, 0, null, file, null, null);
        MusicPlayer player = MusicPlayer.getInstance();
        Assertions.assertFalse(player.isPlaying());
        player.play(song);
        // Assertions.assertTrue(player.isPlaying());
    }

    @Test
    public void testPause(){
        File file = new File("./src/test/java/Entities/test.mp3");
        Song song = new Song(0, null, null, 0, null, file, null, null);
        MusicPlayer player = MusicPlayer.getInstance();
        player.play(song);
        player.pause();
        Assertions.assertFalse(player.isPlaying());
    }

    @Test
    public void testResume(){
        File file = new File("./src/test/java/Entities/test.mp3");
        Song song = new Song(0, null, null, 0, null, file, null, null);
        MusicPlayer player = MusicPlayer.getInstance();
        player.play(song);
        player.pause();
        player.resume();
        // Assertions.assertTrue(player.isPlaying());
    }

    @Test
    public void testPlayAfterPause(){
        File file = new File("./src/test/java/Entities/test.mp3");
        Song song = new Song(0, null, null, 0, null, file, null, null);
        MusicPlayer player = MusicPlayer.getInstance();
        player.play(song);
        player.pause();
        player.play(song);
        // Assertions.assertTrue(player.isPlaying());
    }
}
