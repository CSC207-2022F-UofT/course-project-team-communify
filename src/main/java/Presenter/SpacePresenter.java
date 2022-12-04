package presenter;

import outputBoundary.SpacePlayedOutputBoundary;

/**
 * presenter for the space use cases.
 */
public class SpacePresenter implements SpacePlayedOutputBoundary {

    private final viewModel.MusicEngineViewModel musicEngineViewModel;

    /**
     * constructor.
     * @param musicEngineViewModel the view model for outputting music related output
     */
    public SpacePresenter(viewModel.MusicEngineViewModel musicEngineViewModel){
        this.musicEngineViewModel = musicEngineViewModel;
    }

    @Override
    public void addedToSpace(String songName){
        this.musicEngineViewModel.UpdateSpacePopupText(songName + " has been added to space!");
    }

    @Override
    public void notAddedToSpace(String songName) {
        this.musicEngineViewModel.UpdateSpacePopupText(songName + " is already in the space!");
    }

}
