package ViewModel;

import Controller.searchController;
import OutputBoundary.searchOutputBoundary;
import Presenter.searchPresenter;

/**
 * The interface adapters layer view model which acts as a gateway between the view and the search related
 * parts of the program.
 */
public class searchViewModel {

    private final searchController searchController;
    private String[][] outputSongs;

    /**
     * Constructor.
     */
    public searchViewModel(){
        searchOutputBoundary searchPresenter = new searchPresenter(this);
        this.searchController = new searchController(searchPresenter);

    }

    /**
     * @param text the search query
     * @return a 2D array representing the search results
     */
    public String[][] search(String text){
        this.searchController.search(text);
        return this.outputSongs;
    }

    /**
     * @param songs the songs which are search results
     */
    public void updateOutput(String[][] songs){
        this.outputSongs = songs;
    }
}
