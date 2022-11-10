package Controller;

import InputBoundary.playSpaceInputBoundary;
import InputBoundary.spaceAddInputBoundary;
import InputData.spaceInputData;


/**
 * Controller for use cases related to the Space.
 */
public class spaceController {
    private final spaceAddInputBoundary spaceAddInteractor;
    private final playSpaceInputBoundary spacePlayInteractor;

    /**
     * Constructor.
     * @param spaceAddInteractor use case interactor for adding a song to the space
     * @param spacePlayInteractor use case interactor for playing the space
     */
    public spaceController(spaceAddInputBoundary spaceAddInteractor, playSpaceInputBoundary spacePlayInteractor){
        this.spaceAddInteractor = spaceAddInteractor;
        this.spacePlayInteractor = spacePlayInteractor;
    }

    /**
     * function calling the use case for playing the space
     * @param spaceInputData input data for playing the space
     */
    public void playSpace(spaceInputData spaceInputData){
        this.spacePlayInteractor.playSpace(spaceInputData);
    }

    /**
     * function calling the use case for adding a song to the space
     * @param spaceInputData input data for adding a song to the space
     */
    public void spaceAddSong(spaceInputData spaceInputData){
        this.spaceAddInteractor.spaceAddSong(spaceInputData);
    }

}
