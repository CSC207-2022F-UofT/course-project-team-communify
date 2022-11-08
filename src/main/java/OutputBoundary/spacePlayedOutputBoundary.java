package OutputBoundary;

import OutputData.songOutputData;

/**
 * interface for wrapping the space presenter for the playing the space use case.
 */
public interface spacePlayedOutputBoundary {

    /**
     * @param songOutputData data returned by the use case
     */
    default void spacePlayed(songOutputData songOutputData){

    }

}
