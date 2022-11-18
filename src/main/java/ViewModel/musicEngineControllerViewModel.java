package ViewModel;

import Controller.musicEngineController;
import InputData.playlistInputData;
import InputData.songInputData;
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
        this.musicEngineController.playPlaylist(id);
        return playing.getSong().getName();
    }

    public void getRecommendationAction(int id){
        this.musicEngineController.playRecommendation(id);
    }

    public void pauseSongAction(){
        this.musicEngineController.pauseSong();
    }

    public void skipSongAction(){
        this.musicEngineController.playNext();
    }

    public String playSongAction(int id){
        this.musicEngineController.playSong(id);
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
