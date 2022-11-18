package ViewModel;

import Controller.musicEngineController;
import OutputData.songOutputData;
import Presenter.songPresenter;
import Presenter.spacePresenter;

/**
 * The interface adapters layer view model which acts as a gateway between the view and the music engine related
 * parts of the program.
 */
public class musicEngineControllerViewModel {
    private final musicEngineController musicEngineController;
    private String spaceButtonText;
    private songOutputData playing;

    public musicEngineControllerViewModel(){
        this.musicEngineController = new musicEngineController(new spacePresenter(this),
                new songPresenter(this));
    }

    /**
     * Updates the currently playing song in the view.
     * @param s the song that is now playing
     */
    public void updatePlaying(songOutputData s){
        this.playing = s;
    }

    /**
     * Button action for playing a playlist.
     * @param id the id of the playlist to play
     * @return info about the new currently playing song
     */
    public String playPlaylistAction(int id){
        this.musicEngineController.playPlaylist(id);
        return playing.getSong().getName();
    }

    /**
     * Button action for recommending a song for a playlist.
     * @param id the id of the playlist to recommend a song for
     */
    public void getRecommendationAction(int id){
        this.musicEngineController.playRecommendation(id);
    }

    /**
     * Button action for pausing and resuming the currently playing song.
     */
    public void pauseSongAction(){
        this.musicEngineController.pauseSong();
    }

    /**
     * Button action for skipping a song in the playing playlist.
     */
    public void skipSongAction(){
        this.musicEngineController.playNext();
    }

    /**
     * Button action for playing a song.
     * @param id the ID of the song to play
     * @return info about the newly playing song
     */
    public String playSongAction(int id){
        this.musicEngineController.playSong(id);
        return playing.getSong().getName();
    }


    /**
     * Button action for playing the space.
     * @return info about the newly playing song
     */
    public String callPlaySpace() {
        this.musicEngineController.playSpace();
        return this.spaceButtonText;
    }

    /**
     * Updates the view when a space is played.
     * @param spaceButtonText the new text for the space button
     */
    public void updateSpaceButton(String spaceButtonText) {
        this.spaceButtonText  = spaceButtonText;
    }

    /**
     * @return the text to go on the space button
     */
    public String getSpaceButtonText(){
        return this.spaceButtonText;
    }
}
