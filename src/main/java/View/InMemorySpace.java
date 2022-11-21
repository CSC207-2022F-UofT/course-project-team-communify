package View;

import ViewModel.musicEngineControllerViewModel;

import java.util.ArrayList;
import java.util.List;

public class InMemorySpace {

    private final List<InMemorySong> spaceSongList;
    private final musicEngineControllerViewModel musicEngineControllerViewModel;

    public InMemorySpace(musicEngineControllerViewModel musicEngineControllerViewModel){
        this.spaceSongList = new ArrayList<>();
        this.musicEngineControllerViewModel = musicEngineControllerViewModel;
    }

    public List<InMemorySong> getSpaceSongList(){
        return this.spaceSongList;
    }

    public musicEngineControllerViewModel getMusicEngineControllerViewModel(){
        return this.musicEngineControllerViewModel;
    }
}
