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

    public void search(searchInputData inputData){
        this.searchInteractor.search(inputData);
    }
}
