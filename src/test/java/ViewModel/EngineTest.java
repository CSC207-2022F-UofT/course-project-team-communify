package ViewModel;

import Entities.MusicPlayer;
import View.InMemoryPlaylist;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EngineTest {

    /**
     * testing if call play space works
     */
    @Test
    public void testCallPlaySpace(){
        MusicPlayer mp = MusicPlayer.getInstance();
        musicEngineControllerViewModel mv = new musicEngineControllerViewModel(new InMemoryPlaylist());
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
        musicEngineControllerViewModel mv = new musicEngineControllerViewModel(new InMemoryPlaylist());
        String popupText = mv.callAddToSpace(10);
        Assertions.assertNotEquals(popupText, null);
    }

    /**
     * testing if add to space works if there's already a song in there
     */
    @Test
    public void testAddToSpace2(){
        musicEngineControllerViewModel mv = new musicEngineControllerViewModel(new InMemoryPlaylist());
        mv.callAddToSpace(10);
        String popupText = mv.callAddToSpace(2);
        Assertions.assertNotEquals(popupText, null);
    }

    /**
     * testing if add to space works if you're adding a song that's already in there
     */
    @Test
    public void testAddToSpace3(){
        musicEngineControllerViewModel mv = new musicEngineControllerViewModel(new InMemoryPlaylist());
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
        musicEngineControllerViewModel mv = new musicEngineControllerViewModel(new InMemoryPlaylist());
        mv.callPlaySpace();
        mv.callAddToSpace(10);
        String popupText = mv.callAddToSpace(2);
        Assertions.assertNotEquals(popupText, null);
    }
}
