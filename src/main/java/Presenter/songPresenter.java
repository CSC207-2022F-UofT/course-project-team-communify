package Presenter;

import OutputBoundary.recommendationOutputBoundary;
import OutputBoundary.songOutputBoundary;
import OutputData.songOutputData;
import ViewModel.musicEngineControllerViewModel;

public class songPresenter implements songOutputBoundary, recommendationOutputBoundary {
    private final musicEngineControllerViewModel viewModel;

    public songPresenter(musicEngineControllerViewModel vm){
        this.viewModel = vm;
    }

    @Override
    public void recommendSong(songOutputData s) {

    }

    @Override
    public void songPlayed(songOutputData s) {
        viewModel.updatePlaying(s);
    }
}
