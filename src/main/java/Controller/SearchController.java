package Controller;

import InputBoundary.SearchInputBoundary;
import InputData.SearchInputData;
import OutputBoundary.SearchOutputBoundary;
import UseCase.Search;
/**
 * Interface adapters layer controller for search use case.
 */
public class SearchController {
    private final SearchInputBoundary searchInteractor;

    /**
     * @param searchPresenter the presenter for search output data
     */
    public SearchController(SearchOutputBoundary searchPresenter){
        this.searchInteractor = new Search(searchPresenter);
    }

    /**
     * @param text the query to search for
     */
    public void search(String text){
        SearchInputData inputData = new SearchInputData(text);
        this.searchInteractor.search(inputData);
    }
}
