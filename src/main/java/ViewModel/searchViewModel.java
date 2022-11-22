package ViewModel;

import Controller.searchController;
import OutputBoundary.searchOutputBoundary;
import Presenter.searchPresenter;


public class searchViewModel {

    private searchController searchController;
    private searchOutputBoundary searchPresenter;
    private String[][] outputSongs;

    public searchViewModel(){
        this.searchPresenter = new searchPresenter(this);
        this.searchController = new searchController(this.searchPresenter);

    }

    public String[][] search(String text){
        this.searchController.search(text);
        return this.outputSongs;
    }

    public void updateOutput(String[][] songs){
        this.outputSongs = songs;
    }
}
