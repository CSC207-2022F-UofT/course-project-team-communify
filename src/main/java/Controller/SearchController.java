package Controller;

import InputBoundary.SearchInputBoundary;
import InputData.SearchInputData;

public class SearchController {
    private final SearchInputBoundary searchInteractor;
    private final SearchInputData searchInputData;

    public SearchController(SearchInputBoundary searchInteractor, String text){
        this.searchInteractor = searchInteractor;
        this.searchInputData = new SearchInputData(text);
    }

    public void search(){
        this.searchInteractor.search(this.searchInputData);
    }
}
