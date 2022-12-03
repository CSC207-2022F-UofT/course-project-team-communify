package ViewModel;

import Controller.MusicEngineController;
import OutputData.SongOutputData;
import Presenter.SongPresenter;
import Presenter.SpacePresenter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * The interface adapters layer view model which acts as a gateway between the view and the music playing related
 * parts of the program.
 */
public class MusicEngineControllerViewModel {
    private final MusicEngineController musicEngineController;
    private SongOutputData playing;
    private String SpaceAddedPopupText;
    private final Object sync;
    private final PlaylistDsView songMaker;

    /**
     * @param p an empty playlist to create empty songs
     */
    public MusicEngineControllerViewModel(PlaylistDsView p){
        this.musicEngineController = new MusicEngineController(new SpacePresenter(this),
                new SongPresenter(this));
        this.sync = new Object();
        this.songMaker = p;
    }

    /**
     * @param s the now playing song
     */
    public void updatePlaying(SongOutputData s){
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

        if (playing != null){
            out.setName(playing.getName());
            out.setId(playing.getId());
            out.setCover(playing.getCover());
            out.setGenre(playing.getGenre());
            out.setArtists(playing.getArtistList());
        }
        else {
            try {
                BufferedImage tempCover = ImageIO.read(new File(Paths.get("").toAbsolutePath() +
                        "/src/songLib/cover/no_genre.png"));
                out.setCover(tempCover);
            } catch (IOException e) {
                e.printStackTrace();
            }
            out.setName("Nothing playing");
            out.setId(0);
            out.setArtists(new String[]{""});
            out.setGenre("");
        }

        return out;
    }

    /**
     * @param msg the message to show after updating a space
     */
    public void UpdateSpacePopupText(String msg){
        this.SpaceAddedPopupText = msg;
    }

    /**
     * calls play space use case
     */
    public void callPlaySpace() {
        this.musicEngineController.playSpace();
    }

    /**
     * @return the Object which the play bar is synced on
     */
    public Object getSync() {
        return sync;
    }

    /**
     * @return the integer representation of type of media playing
     */
    public int getMediaType(){
        return this.musicEngineController.getPlaying();
    }
}
