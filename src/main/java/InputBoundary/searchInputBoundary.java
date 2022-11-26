package InputBoundary;

import InputData.searchInputData;
/**
 * Use case layer input boundary that allows communication between outer layers and the search use case.
 */
public interface searchInputBoundary {

    /**
     * Searches through the song database for a given query.
     * @param searchInputData the search query
     */
    void search(searchInputData searchInputData);
}
