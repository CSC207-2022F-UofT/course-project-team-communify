package Presenter;

import OutputBoundary.songOutputBoundary;
import OutputData.songOutputData;
import ViewModel.musicEngineControllerViewModel;

/**
 * Interface adapters layer presenter for displaying play song use case output.
 */
public class songPresenter implements songOutputBoundary {
    private final musicEngineControllerViewModel viewModel;

    /**
     * @param musicEngineControllerViewModel the view model of the music engine
     */
    public songPresenter(musicEngineControllerViewModel musicEngineControllerViewModel){
        this.viewModel = musicEngineControllerViewModel;
    }

    /**
     * Return info about the song that is now being played.
     * @param s the song that is being played
     */
    @Override
    public void songPlayed(songOutputData s) {
        viewModel.updatePlaying(s);
    }
}
