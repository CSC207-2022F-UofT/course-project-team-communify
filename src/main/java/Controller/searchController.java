package Controller;

import InputBoundary.searchInputBoundary;
import InputData.searchInputData;

/**
 * Interface adapters layer controller for search use case.
 */
public class searchController {
    private final searchInputBoundary searchInteractor;
    private final searchInputData searchInputData;

    public searchController(searchInputBoundary searchInteractor, String text){
        this.searchInteractor = searchInteractor;
        this.searchInputData = new searchInputData(text);
    }

    /**
     * Searches for the given query by calling the use case.
     */
    public void search(){
        this.searchInteractor.search(this.searchInputData);
    }
}
