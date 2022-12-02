package Presenter;

import OutputBoundary.SongOutputBoundary;
import OutputData.SongOutputData;
import ViewModel.MusicEngineControllerViewModel;

/**
 * Interface adapters layer presenter for displaying play song use case output.
 */
public class SongPresenter implements SongOutputBoundary {
    private final MusicEngineControllerViewModel viewModel;

    /**
     * @param musicEngineControllerViewModel the view model of the music engine
     */
    public SongPresenter(MusicEngineControllerViewModel musicEngineControllerViewModel){
        this.viewModel = musicEngineControllerViewModel;
    }

    /**
     * Return info about the song that is now being played.
     * @param s the song that is being played
     */
    @Override
    public void songPlayed(SongOutputData s) {
        viewModel.updatePlaying(s);
    }
}
