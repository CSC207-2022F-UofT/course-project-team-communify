package Presenter;

import OutputBoundary.SpacePlayedOutputBoundary;
import ViewModel.musicEngineControllerViewModel;

/**
 * presenter for the space use cases.
 */
public class spacePresenter implements SpacePlayedOutputBoundary {

    private final ViewModel.musicEngineControllerViewModel musicEngineControllerViewModel;

    /**
     * constructor.
     * @param musicEngineControllerViewModel the view model for outputting music related output
     */
    public spacePresenter(musicEngineControllerViewModel musicEngineControllerViewModel){
        this.musicEngineControllerViewModel = musicEngineControllerViewModel;
    }

    @Override
    public void addedToSpace(String songName){
        this.musicEngineControllerViewModel.UpdateSpacePopupText(songName + " has been added to space!");
    }

    @Override
    public void notAddedToSpace(String songName) {
        this.musicEngineControllerViewModel.UpdateSpacePopupText(songName + " is already in the space!");
    }

}
