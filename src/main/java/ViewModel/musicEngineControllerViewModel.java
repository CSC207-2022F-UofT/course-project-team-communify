package ViewModel;

import Controller.musicEngineController;
import OutputData.songOutputData;
import Presenter.songPresenter;
import Presenter.spacePresenter;

import java.util.List;
/**
 * The interface adapters layer view model which acts as a gateway between the view and the music playing related
 * parts of the program.
 */
public class musicEngineControllerViewModel {
    private final musicEngineController musicEngineController;
    private String spaceButtonText;
    private songOutputData playing;
    private String SpaceAddedPopupText;
    private final Object sync;
    private final PlaylistDsView songMaker;

    /**
     * @param p an empty playlist to create empty songs
     */
    public musicEngineControllerViewModel(PlaylistDsView p){
        this.musicEngineController = new musicEngineController(new spacePresenter(this),
                new songPresenter(this));
        this.sync = new Object();
        this.songMaker = p;
    }

    /**
     * @param s the now playing song
     */
    public void updatePlaying(songOutputData s){
        this.playing = s;
        final Thread t = new Thread(this::notifyPlayBar);
        t.start();
    }

    /**
     * notify the playBar to update
     */
    private void notifyPlayBar(){
        synchronized (sync){
            sync.notifyAll();
        }
    }

    /**
     * @param id the ID of the playlist to play
     */
    public void playPlaylistAction(int id){
        this.musicEngineController.playPlaylist(id);
    }

    /**
     * @param id the ID of the playlist to recommend a song on
     */
    public void getRecommendationAction(int id){
        this.musicEngineController.playRecommendation(id);
    }

    /**
     * the pause song button action
     */
    public void pauseSongAction(){
        this.musicEngineController.pauseSong();
    }

    /**
     * the skip song button action
     */
    public void skipSongAction(){
        this.musicEngineController.playNext();
    }

    /**
     * @param id the ID of the song to play
     */
    public void playSongAction(int id){
        this.musicEngineController.playSong(id);
    }

    /**
     * @param id the ID of the song to add
     * @return the text to display after
     */
    public String callAddToSpace(int id) {
        this.musicEngineController.spaceAddSong(id);
        return this.SpaceAddedPopupText;
    }

    /**
     * @return the currently playing song
     */
    public SongDsView getPlaying() {
        SongDsView out = songMaker.getNewSong();

        out.setName(playing.getName());
        out.setId(playing.getId());
        out.setCover(playing.getCover());
        out.setGenre(playing.getGenre());
        out.setArtists(playing.getArtistList());

        return out;
    }

    /**
     * @param msg the message to show after updating a space
     */
    public void UpdateSpacePopupText(String msg){
        this.SpaceAddedPopupText = msg;
    }

    /**
     * @return the message to display after playing the space
     */
    public String callPlaySpace() {
        this.musicEngineController.playSpace();
        return this.spaceButtonText;
    }

    /**
     * @param spaceButtonText the message to display after playing the space
     */
    public void updateSpaceButton(String spaceButtonText) {
        this.spaceButtonText  = spaceButtonText;
    }

    /**
     * @return the Object which the play bar is synced on
     */
    public Object getSync() {
        return sync;
    }

    /**
     * @param spaceIDs the song IDs to add to the space
     */
    public void updateSpace(List<Integer> spaceIDs) {
        for (int id : spaceIDs)
            this.musicEngineController.spaceAddSong(id);
    }

    /**
     * @return the song IDs in the space
     */
    public List<Integer> returnSpace(){
        return this.musicEngineController.returnSpace();
    }
}
