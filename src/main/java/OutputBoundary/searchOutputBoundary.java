package OutputBoundary;

import OutputData.searchOutputData;

/**
 * Use case layer input boundary that allows communication between presenters and the search use case.
 */
public interface searchOutputBoundary {
    /**
     * @param searchOutputData the output of the search results
     */
    void foundSongs(searchOutputData searchOutputData);
}
