package ViewModel;

import Controller.musicEngineController;
import InputData.playlistInputData;
import OutputData.songOutputData;
import Presenter.songPresenter;

public class musicEngineControllerViewModel {
    private final musicEngineController controller;
    private songOutputData playing;

    public musicEngineControllerViewModel(){
        this.controller = new musicEngineController(new songPresenter(this));
    }

    public void updatePlaying(songOutputData s){
        this.playing = s;
    }

    public String playPlaylistAction(int id){
        playlistInputData data = new playlistInputData(id);
        controller.playPlaylist(data);
        return playing.getSong().getName();
    }

}
