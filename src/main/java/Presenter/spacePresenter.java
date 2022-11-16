package Presenter;

import OutputBoundary.songOutputBoundary;
import OutputBoundary.spacePlayedOutputBoundary;
import OutputData.songOutputData;
import ViewModel.musicEngineControllerViewModel;

/**
 * presenter for the space use cases.
 */
public class spacePresenter implements spacePlayedOutputBoundary {

    private final ViewModel.musicEngineControllerViewModel musicEngineControllerViewModel;

    /**
     * constructor.
     */
    public spacePresenter(musicEngineControllerViewModel musicEngineControllerViewModel){
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
