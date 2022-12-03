package InputBoundary;

import InputData.SearchInputData;
/**
 * Use case layer input boundary that allows communication between outer layers and the search use case.
 */
public interface SearchInputBoundary {

    /**
     * Searches through the song database for a given query.
     * @param searchInputData the search query
     */
    void search(SearchInputData searchInputData);
}
