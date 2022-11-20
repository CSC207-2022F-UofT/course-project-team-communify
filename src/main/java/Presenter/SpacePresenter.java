package Presenter;

import OutputBoundary.SpacePlayedOutputBoundary;
import ViewModel.MusicEngineControllerViewModel;

/**
 * presenter for the space use cases.
 */
public class SpacePresenter implements SpacePlayedOutputBoundary {

    private final MusicEngineControllerViewModel musicEngineControllerViewModel;

    /**
     * constructor.
     */
    public SpacePresenter(MusicEngineControllerViewModel musicEngineControllerViewModel){
        this.musicEngineControllerViewModel = musicEngineControllerViewModel;
    }

    /**
     * in case of starting to play a space, change the "play space!" button to reflect that change
     */
    @Override
    public void spacePlayed() {
        this.musicEngineControllerViewModel.updateSpaceButton("Currently playing space!");
    }

    /**
     * in case of starting to play a song/playlist when a space is currently playing, want to reset "play space!" button
     */
    @Override
    public void spaceNotPlayed(){
        this.musicEngineControllerViewModel.updateSpaceButton("Listen to space!");
    }

}
