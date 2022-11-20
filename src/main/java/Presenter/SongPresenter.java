package Presenter;

import OutputBoundary.SongOutputBoundary;
import OutputData.SongOutputData;
import ViewModel.MusicEngineControllerViewModel;

public class SongPresenter implements SongOutputBoundary {
    private final MusicEngineControllerViewModel viewModel;

    public SongPresenter(MusicEngineControllerViewModel musicEngineControllerViewModel){
        this.viewModel = musicEngineControllerViewModel;
    }

    @Override
    public void songPlayed(SongOutputData s) {
        viewModel.updatePlaying(s);
    }
}
