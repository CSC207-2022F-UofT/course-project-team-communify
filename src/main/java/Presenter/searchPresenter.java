package Presenter;

import OutputBoundary.searchOutputBoundary;
import OutputData.searchOutputData;

public class searchPresenter implements searchOutputBoundary{

    /**
     *
     * @param searchOutputData contains the List of songs that were found by the user's search
     */
    @Override
    public void foundSongs(searchOutputData searchOutputData) {
        //TODO: pass the searchOutputData to the viewModel
    }
}
