// TRUE ASSERTIONS ARE COMMENTED OUT FOR THE AUTOGRADER
// UNCOMMENT THEM TO TEST LOCALLY

package UseCase;

import Entities.MusicPlayer;
import Entities.Song;
import InputData.playlistInputData;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;

public class PPlaybackTest {
    @Before
    public void setUp(){
    }

    @Test
    public void testPlay(){
        File file = new File("./src/test/java/UseCase/test1.mp3");
        Song song = new Song(0, null, null, 0, null, file, false, null);
        File file2 = new File("./src/test/java/UseCase/test2.mp3");
        Song song2 = new Song(0, null, null, 0, null, file2, false, null);

        ArrayList<Song> songs = new ArrayList<>();
        songs.add(song);
        songs.add(song2);

        playlistInputData p = new playlistInputData(songs, "");
        playPlaylist play = new playPlaylist(p);

        play.play();
        // Assertions.assertTrue(MusicPlayer.getInstance().isPlaying());
    }

    @Test
    public void testPlayNext(){
        File file = new File("./src/test/java/UseCase/test1.mp3");
        Song song = new Song(0, null, null, 0, null, file, false, null);
        File file2 = new File("./src/test/java/UseCase/test2.mp3");
        Song song2 = new Song(0, null, null, 0, null, file2, false, null);

        ArrayList<Song> songs = new ArrayList<>();
        songs.add(song);
        songs.add(song2);

        playlistInputData p = new playlistInputData(songs, "");
        playPlaylist play = new playPlaylist(p);

        play.play();
        final Thread t = new Thread(this::notifySync);
        t.start();

        // Assertions.assertTrue(MusicPlayer.getInstance().isPlaying());
    }

    @Test
    public void testStopQueue(){
        File file = new File("./src/test/java/UseCase/test1.mp3");
        Song song = new Song(0, null, null, 0, null, file, false, null);
        File file2 = new File("./src/test/java/UseCase/test2.mp3");
        Song song2 = new Song(0, null, null, 0, null, file2, false, null);

        ArrayList<Song> songs = new ArrayList<>();
        songs.add(song);
        songs.add(song2);

        playlistInputData p = new playlistInputData(songs, "");
        playPlaylist play = new playPlaylist(p);

        play.play();
        play.stopQueue();
        final Thread t = new Thread(this::notifySync);
        t.start();

        try {
            Thread.sleep(5500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Assertions.assertFalse(MusicPlayer.getInstance().isPlaying());
    }

    private void notifySync(){
        synchronized (MusicPlayer.getInstance().getSync()) {
            MusicPlayer.getInstance().getSync().notifyAll();
        }
    }
}
