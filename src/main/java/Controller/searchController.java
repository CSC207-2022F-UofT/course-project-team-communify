package Controller;

import InputBoundary.searchInputBoundary;
import InputData.searchInputData;
import OutputBoundary.searchOutputBoundary;
import UseCase.Search;

public class searchController {
    private final searchInputBoundary searchInteractor;
    private final searchInputData searchInputData;

    public searchController(searchOutputBoundary searchPresenter, String text){
        // TODO: create new interactor not passed in
        // interactor needs copy of presenter, passed in
        this.searchInteractor = new Search(searchPresenter);
        this.searchInputData = new searchInputData(text);
    }

    public void search(){
        this.searchInteractor.search(this.searchInputData);
    }
}
