package Controller;

import InputBoundary.searchInputBoundary;
import InputData.searchInputData;
import OutputBoundary.searchOutputBoundary;
import UseCase.Search;
/**
 * Interface adapters layer controller for search use case.
 */
public class searchController {
    private final searchInputBoundary searchInteractor;

    /**
     * @param searchPresenter the presenter for search output data
     */
    public searchController(searchOutputBoundary searchPresenter){
        this.searchInteractor = new Search(searchPresenter);
    }

    /**
     * @param text the query to search for
     */
    public void search(String text){
        searchInputData inputData = new searchInputData(text);
        this.searchInteractor.search(inputData);
    }
}
