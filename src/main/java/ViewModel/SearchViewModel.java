package ViewModel;

import Controller.SearchController;
import OutputBoundary.SearchOutputBoundary;
import Presenter.SearchPresenter;

/**
 * The interface adapters layer view model which acts as a gateway between the view and the search related
 * parts of the program.
 */
public class SearchViewModel {

    private final SearchController searchController;
    private String[][] outputSongs;

    /**
     * Constructor.
     */
    public SearchViewModel(){
        SearchOutputBoundary searchPresenter = new SearchPresenter(this);
        this.searchController = new SearchController(searchPresenter);

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

    public String[][] getOutputSongs() {
        return outputSongs;
    }
}
