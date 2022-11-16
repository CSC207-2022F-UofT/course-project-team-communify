package ViewModel;

import Controller.musicEngineController;
import InputData.playlistInputData;
import OutputData.songOutputData;
import Presenter.songPresenter;
import Presenter.spacePresenter;

public class musicEngineControllerViewModel {
    private final musicEngineController musicEngineController;
    private String spaceButtonText;
    private songOutputData playing;

    public musicEngineControllerViewModel(){
        this.musicEngineController = new musicEngineController(new spacePresenter(this),
                new songPresenter(this));
    }

    public void updatePlaying(songOutputData s){
        this.playing = s;
    }

    public String playPlaylistAction(int id){
        playlistInputData data = new playlistInputData(id);
        this.musicEngineController.playPlaylist(data);
        return playing.getSong().getName();
    }

    public String callPlaySpace() {
        this.musicEngineController.playSpace();
        return this.spaceButtonText;
    }

    public void updateSpaceButton(String spaceButtonText) {
        this.spaceButtonText  = spaceButtonText;
    }

    public String getSpaceButtonText(){
        return this.spaceButtonText;
    }
}
