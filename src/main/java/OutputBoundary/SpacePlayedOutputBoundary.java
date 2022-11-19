package OutputBoundary;


/**
 * interface for wrapping the space presenter for the playing the space use case.
 */
public interface SpacePlayedOutputBoundary {

    /**
     * in case of starting to play space, reflect that in the button
     */
    void spacePlayed();

    /**
     * in case of starting to play a song/playlist when a space is currently playing, want to reset "play space!" button
     */
    void spaceNotPlayed();

    void addedToSpace(String songName);

    void notAddedToSpace(String songName);

}