package ViewModel;

import Controller.searchController;
import OutputBoundary.searchOutputBoundary;
import Presenter.searchPresenter;

import java.util.ArrayList;

public class searchViewModel {

    private searchController searchController;
    private searchOutputBoundary searchPresenter;

    public searchViewModel(){
        this.searchPresenter = new searchPresenter(this);
        this.searchController = new searchController(this.searchPresenter, "");

        // constructor presenter with copy of itself, pass into controller
        // construct a controller - pass in the presenter
    }

    // have a function that returns something to the view
    public ArrayList search(){
        this.searchController.search();
        return new ArrayList<>(); // TODO: change
    }
}
