package viewModel;

import entities.MusicPlayer;
import view.InMemoryPlaylist;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MusicEngineViewModelTest {

    /**
     * testing if call play space works
     */
    @Test
    public void testCallPlaySpace(){
        MusicPlayer mp = MusicPlayer.getInstance();
        MusicEngineViewModel mv = new MusicEngineViewModel(new InMemoryPlaylist());
        mv.callPlaySpace();
        Assertions.assertNotEquals(mp.isPlaying(), null);
        Assertions.assertEquals(mv.getMediaType(), 2);
        Assertions.assertNotEquals(mv.getPlaying(), null);
    }

    /**
     * testing if add to space works
     */
    @Test
    public void testAddToSpace(){
        MusicEngineViewModel mv = new MusicEngineViewModel(new InMemoryPlaylist());
        String popupText = mv.callAddToSpace(10);
        Assertions.assertNotEquals(popupText, null);
    }

    /**
     * testing if add to space works if there's already a song in there
     */
    @Test
    public void testAddToSpace2(){
        MusicEngineViewModel mv = new MusicEngineViewModel(new InMemoryPlaylist());
        mv.callAddToSpace(10);
        String popupText = mv.callAddToSpace(2);
        Assertions.assertNotEquals(popupText, null);
    }

    /**
     * testing if add to space works if you're adding a song that's already in there
     */
    @Test
    public void testAddToSpace3(){
        MusicEngineViewModel mv = new MusicEngineViewModel(new InMemoryPlaylist());
        mv.callAddToSpace(10);
        mv.callAddToSpace(2);
        String popupText = mv.callAddToSpace(2);
        Assertions.assertNotEquals(popupText, null);
    }

    /**
     * testing if add to space works if you're playing the space at the same time
     */
    @Test
    public void testAddToSpace4(){
        MusicEngineViewModel mv = new MusicEngineViewModel(new InMemoryPlaylist());
        mv.callPlaySpace();
        mv.callAddToSpace(10);
        String popupText = mv.callAddToSpace(2);
        Assertions.assertNotEquals(popupText, null);
    }

    /**
     * testing if the else clause of getPlaying works.
     */
    @Test
    public void testGetPlaying(){
        MusicEngineViewModel mv = new MusicEngineViewModel(new InMemoryPlaylist());
        Assertions.assertNotEquals(mv.getPlaying(), null);
    }
}
