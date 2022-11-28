package OutputBoundary;


/**
 * interface for wrapping the space presenter for the playing the space use case.
 */
public interface SpacePlayedOutputBoundary {

    /**
     * @param songName the name of the song added to the space
     */
    void addedToSpace(String songName);

    /**
     * @param songName the name of the song not added to the space
     */
    void notAddedToSpace(String songName);

}
