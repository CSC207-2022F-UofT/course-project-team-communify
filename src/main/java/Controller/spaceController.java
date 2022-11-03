package Controller;

import InputBoundary.playSpaceInputBoundary;
import InputBoundary.spaceAddInputBoundary;
import InputData.spaceInputData;

public class spaceController {
    private final spaceAddInputBoundary spaceAddInteractor;
    private final playSpaceInputBoundary spacePlayInteractor;

    public spaceController(spaceAddInputBoundary spaceAddInteractor, playSpaceInputBoundary spacePlayInteractor){
        this.spaceAddInteractor = spaceAddInteractor;
        this.spacePlayInteractor = spacePlayInteractor;
    }

    public void playSpace(spaceInputData spaceInputData){
        this.spacePlayInteractor.playSpace(spaceInputData);
    }

    public void spaceAddSong(spaceInputData spaceInputData){
        this.spaceAddInteractor.spaceAddSong(spaceInputData);
    }

}
