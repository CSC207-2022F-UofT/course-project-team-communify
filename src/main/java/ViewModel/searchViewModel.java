package ViewModel;

import Controller.searchController;
import InputData.playlistInputData;
import InputData.searchInputData;
import OutputBoundary.searchOutputBoundary;
import Presenter.searchPresenter;

import java.util.ArrayList;

public class searchViewModel {

    private searchController searchController;
    private searchOutputBoundary searchPresenter;
    private String[][] outputSongs;

    public searchViewModel(){
        this.searchPresenter = new searchPresenter(this);
        this.searchController = new searchController(this.searchPresenter);

    }

    public String[][] search(String text){
        searchInputData inputData = new searchInputData(text);
        this.searchController.search(inputData);
        return this.outputSongs;
    }

    public void updateOutput(String[][] songs){
        this.outputSongs = songs;
    }
}
