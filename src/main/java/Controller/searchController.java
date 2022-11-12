package Controller;

import InputBoundary.searchInputBoundary;
import InputData.searchInputData;

public class searchController {
    private final searchInputBoundary searchInteractor;
    private final searchInputData searchInputData;

    public searchController(searchInputBoundary searchInteractor, String text){
        this.searchInteractor = searchInteractor;
        this.searchInputData = new searchInputData(text);
    }

    public void search(){
        this.searchInteractor.search(this.searchInputData);
    }
}
