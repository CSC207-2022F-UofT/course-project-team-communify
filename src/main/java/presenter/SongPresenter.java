package presenter;

import outputBoundary.SongOutputBoundary;
import outputData.SongOutputData;

/**
 * Interface adapters layer presenter for displaying play song use case output.
 */
public class SongPresenter implements SongOutputBoundary {
    private final viewModel.MusicEngineViewModel viewModel;

    /**
     * @param musicEngineViewModel the view model of the music engine
     */
    public SongPresenter(viewModel.MusicEngineViewModel musicEngineViewModel){
        this.viewModel = musicEngineViewModel;
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
