package Controller;

import InputBoundary.searchInputBoundary;
import InputData.searchInputData;
import OutputBoundary.searchOutputBoundary;
import UseCase.Search;

public class searchController {
    private final searchInputBoundary searchInteractor;

    public searchController(searchOutputBoundary searchPresenter){
        this.searchInteractor = new Search(searchPresenter);
    }

    public void search(String text){
        searchInputData inputData = new searchInputData(text);
        this.searchInteractor.search(inputData);
    }
}
