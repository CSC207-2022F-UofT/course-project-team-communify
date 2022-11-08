package Presenter;

import OutputBoundary.songOutputBoundary;
import OutputBoundary.spacePlayedOutputBoundary;
import OutputData.songOutputData;

import java.util.ArrayList;

public class spacePresenter implements songOutputBoundary, spacePlayedOutputBoundary {

    private final ArrayList<songOutputData> currentSpace;

    public spacePresenter(ArrayList<songOutputData> currentSpace){
        this.currentSpace = currentSpace;
    }

    public ArrayList<songOutputData> getCurrentSpace(){
        return this.currentSpace;
    }

    @Override
    public void spacePlayed(songOutputData songOutputData) {
        // TODO: implement
    }
}
