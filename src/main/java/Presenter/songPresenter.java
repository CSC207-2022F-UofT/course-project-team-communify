package Presenter;

import OutputBoundary.songOutputBoundary;
import OutputData.songOutputData;
import ViewModel.musicEngineControllerViewModel;

public class songPresenter implements songOutputBoundary {
    private final musicEngineControllerViewModel viewModel;

    public songPresenter(musicEngineControllerViewModel musicEngineControllerViewModel){
        this.viewModel = musicEngineControllerViewModel;
    }

    @Override
    public void songPlayed(songOutputData s) {
        viewModel.updatePlaying(s);
    }
}
