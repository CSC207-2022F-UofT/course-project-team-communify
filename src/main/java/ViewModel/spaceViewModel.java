package ViewModel;

import Controller.spaceController;
import InputData.songInputData;
import OutputData.songOutputData;
import Presenter.spacePresenter;

public class spaceViewModel {

    private final spaceController spaceController;
    private String spaceButtonMesssage;
    private OutputData.songOutputData songOutputData;

    public spaceViewModel(){
        Presenter.spacePresenter spacePresenter = new spacePresenter(this);
        this.spaceController = new spaceController(spacePresenter);
    }

    /**
     * calling the controller that will call the use case
     */
    public void callPlaySpace(){
        this.spaceController.playSpace();
    }

    /**
     * calling controller that will call use case
     * @param songInputData song to add
     */
    public void addSongToSpace(songInputData songInputData){
        this.spaceController.spaceAddSong(songInputData);
    }

    /**
     * update viewmodel data with current message
     * @param message message for space button
     */
    public void updateSpaceButton(String message){
        this.spaceButtonMesssage = message;
    }

    /**
     * update viewmodel with song playing
     * @param songOutputData song playing
     */
    public void updatePlaybar(songOutputData songOutputData){
        this.songOutputData = songOutputData;
    }

    /**
     * getter for the view
     * @return string message for space button
     */
    public String getSpaceButtonMesssage(){
        return this.spaceButtonMesssage;
    }

    /**
     * getter for the view
     * @return current song playing
     */
    public songOutputData getSongPlaying(){
        return this.songOutputData;
    }


}
