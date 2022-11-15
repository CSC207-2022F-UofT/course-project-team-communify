package OutputBoundary;

import OutputData.songOutputData;

/**
 * interface for wrapping the space presenter for the playing the space use case.
 */
public interface spacePlayedOutputBoundary {

    /**
     * in case of starting to play space, reflect that in the button
     */
    default void spacePlayed(){
    }

    /**
     * in case of starting to play a song/playlist when a space is currently playing, want to reset "play space!" button
     */
    default void spaceNotPlayed(){}

    void songPlayed(songOutputData songToPlay);
}
