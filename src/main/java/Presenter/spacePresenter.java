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

    @Override
    public void spacePlayed(songOutputData songOutputData) {
        // TODO: implement
    }
}
