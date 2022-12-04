package controller;

import inputBoundary.SearchInputBoundary;
import inputData.SearchInputData;
import outputBoundary.SearchOutputBoundary;
import useCase.SearchInteractor;
/**
 * Interface adapters layer controller for search use case.
 */
public class SearchController {
    private final SearchInputBoundary searchInteractor;

    /**
     * @param searchPresenter the presenter for search output data
     */
    public SearchController(SearchOutputBoundary searchPresenter){
        this.searchInteractor = new SearchInteractor(searchPresenter);
    }

    /**
     * @param text the query to search for
     */
    public void search(String text){
        SearchInputData inputData = new SearchInputData(text);
        this.searchInteractor.search(inputData);
    }
}
