package ViewModel;

import Controller.spaceController;
import InputBoundary.playSpaceInputBoundary;
import InputData.songInputData;
import Presenter.spacePresenter;
import UseCase.playSpaceInteractor;

public class spaceViewModel {

    private final spaceController spaceController;
    private final Presenter.spacePresenter spacePresenter;

    public spaceViewModel(){
        this.spacePresenter = new spacePresenter();
        playSpaceInputBoundary playSpaceInputBoundary = new playSpaceInteractor();
        this.spaceController = new spaceController(playSpaceInputBoundary, this.spacePresenter);
    }

    /**
     * calling the controller that will call the use case
     */
    public void callPlaySpace(){
        this.spaceController.playSpace();
    }

    public void addSongToSpace(songInputData songInputData){
        this.spaceController.spaceAddSong(songInputData);
    }

    public String updateSpaceButton(){
        return this.spacePresenter.spacePlayed();
    }

}
