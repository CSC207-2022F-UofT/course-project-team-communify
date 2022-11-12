package Presenter;

import OutputBoundary.songOutputBoundary;
import OutputBoundary.spacePlayedOutputBoundary;
import OutputData.songOutputData;

import java.util.ArrayList;

/**
 * presenter for the space use cases.
 */
public class spacePresenter implements songOutputBoundary, spacePlayedOutputBoundary {

    private final ArrayList<songOutputData> currentSpace;

    /**
     * constructor.
     * @param currentSpace collection of songOutputData that composes the space
     */
    public spacePresenter(ArrayList<songOutputData> currentSpace){
        this.currentSpace = currentSpace;
    }

    /**
     * @return getter for the instance variable currentSpace
     */
    public ArrayList<songOutputData> getCurrentSpace(){
        return this.currentSpace;
    }

    /**
     * in case of starting to play a space, change the "play space!" button to reflect that change
     * @param songOutputData data returned by the use case
     */
    @Override
    public void spacePlayed(songOutputData songOutputData) {
        // TODO: implement
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
