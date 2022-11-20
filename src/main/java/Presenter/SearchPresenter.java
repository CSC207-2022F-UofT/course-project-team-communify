package Presenter;

import OutputBoundary.SearchOutputBoundary;
import OutputData.SearchOutputData;

public class SearchPresenter implements SearchOutputBoundary {

    /**
     *
     * @param searchOutputData contains the List of songs that were found by the user's search
     */
    @Override
    public void foundSongs(SearchOutputData searchOutputData) {
        //TODO: pass the searchOutputData to the viewModel
    }
}
