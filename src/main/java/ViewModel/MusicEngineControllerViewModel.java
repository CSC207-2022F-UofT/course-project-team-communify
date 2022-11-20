package ViewModel;

import Controller.MusicEngineController;
import OutputData.SongOutputData;
import Presenter.SongPresenter;
import Presenter.SpacePresenter;

public class MusicEngineControllerViewModel {
   MusicEngineController musicEngineController;
    private String spaceButtonText;
    private SongOutputData playing;

    public MusicEngineControllerViewModel(){
        musicEngineController = new MusicEngineController(new SpacePresenter(this),
                new SongPresenter(this));
    }

    public void updatePlaying(SongOutputData s){
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
