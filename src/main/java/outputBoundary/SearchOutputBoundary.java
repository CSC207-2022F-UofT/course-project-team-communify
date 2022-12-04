package outputBoundary;

import outputData.SearchOutputData;

/**
 * Use case layer output boundary that allows communication between presenters and the search use case.
 */
public interface SearchOutputBoundary {
    /**
     * @param searchOutputData the output of the search results
     */
    void foundSongs(SearchOutputData searchOutputData);
}
