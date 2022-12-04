package entities;


import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class ArtistUserTest {
    final ArrayList<Song> songs = new ArrayList<>();
    final Song song = new Song(10,"admin",null, "pop", null, null, "uploader");
    @Before
    public void init(){
        songs.add(song);
    }
    /**
     * Tests songs getter.
     */
    @Test
    public void testGetSongs(){
        ArtistUser artistUser = new ArtistUser("artistName","username", "password", songs);
        Assertions.assertEquals(artistUser.getSongs(), songs);
    }
    /**
     * Tests adding songs.
     */
    @Test
    public void testAddSong(){
        ArtistUser artistUser = new ArtistUser("artistName","username", "password", songs);
        Song song2 = new Song(12,"admin",null, "pop", null, null, "uploader");
        artistUser.addSong(song2);
        songs.add(song2);
        Assertions.assertEquals(artistUser.getSongs(), songs);
    }
}
