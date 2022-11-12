package Presenter;

import OutputBoundary.songOutputBoundary;
import OutputBoundary.spacePlayedOutputBoundary;
import OutputData.songOutputData;

/**
 * presenter for the space use cases.
 */
public class spacePresenter implements songOutputBoundary, spacePlayedOutputBoundary {

    /**
     * constructor.
     */
    public spacePresenter(){}

    /**
     * in case of starting to play a space, change the "play space!" button to reflect that change
     */
    @Override
    public String spacePlayed() {
        return "Currently playing space!";
    }

    /**
     * update the playbar when a song starts to play
     * @param songOutputData the song that is being played
     */
    @Override
    public void songPlayed(songOutputData songOutputData) {
        // TODO: implement
    }

    /**
     * in case of starting to play a song/playlist when a space is currently playing, want to reset "play space!" button
     */
    @Override
    public void spaceNotPlayed(){
        // TODO: implement
    }
}
