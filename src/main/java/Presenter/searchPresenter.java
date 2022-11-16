package Presenter;

import OutputBoundary.searchOutputBoundary;
import OutputData.searchOutputData;
import ViewModel.searchViewModel;

public class searchPresenter implements searchOutputBoundary{

    // TOOD: instance of view model
    private searchViewModel searchViewModel;

    public searchPresenter(searchViewModel searchViewModel){
        this.searchViewModel = searchViewModel;
    }

    /**
     *
     * @param searchOutputData contains the List of songs that were found by the user's search
     */
    @Override
    public void foundSongs(searchOutputData searchOutputData) {
        //TODO: pass the searchOutputData to the viewModel

    }
}
