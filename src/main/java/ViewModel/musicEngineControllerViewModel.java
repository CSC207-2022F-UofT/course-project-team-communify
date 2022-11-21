package ViewModel;

import Controller.musicEngineController;
import OutputData.songOutputData;
import Presenter.songPresenter;
import Presenter.spacePresenter;

import java.util.List;

public class musicEngineControllerViewModel {
    private final musicEngineController musicEngineController;
    private String spaceButtonText;
    private songOutputData playing;
    private String SpaceAddedPopupText;
    private final Object sync;
    private final PlaylistDsView songMaker;

    public musicEngineControllerViewModel(PlaylistDsView p){
        this.musicEngineController = new musicEngineController(new spacePresenter(this),
                new songPresenter(this));
        this.sync = new Object();
        this.songMaker = p;
    }

    public void updatePlaying(songOutputData s){
        this.playing = s;
        final Thread t = new Thread(this::notifyPlayBar);
        t.start();
    }

    private void notifyPlayBar(){
        synchronized (sync){
            sync.notifyAll();
        }
    }

    public void playPlaylistAction(int id){
        this.musicEngineController.playPlaylist(id);
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

    public void playSongAction(int id){
        this.musicEngineController.playSong(id);
    }

    public String callAddToSpace(int id) {
        this.musicEngineController.spaceAddSong(id);
        return this.SpaceAddedPopupText;
    }

    public SongDsView getPlaying() {
        SongDsView out = songMaker.getNewSong();

        out.setName(playing.getName());
        out.setId(playing.getId());
        out.setCover(playing.getCover());
        out.setGenre(playing.getGenre());
        out.setArtists(playing.getArtistList());

        return out;
    }

    public void UpdateSpacePopupText(String msg){
        this.SpaceAddedPopupText = msg;
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

    public Object getSync() {
        return sync;
    }

    public void updateSpace(List<Integer> spaceIDs) {
        for (int id : spaceIDs)
            this.musicEngineController.spaceAddSong(id);
    }

    public List<Integer> returnSpace(){
        return this.musicEngineController.returnSpace();
    }
}
