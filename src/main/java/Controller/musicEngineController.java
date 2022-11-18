package Controller;

import InputBoundary.*;
import InputBoundary.playSongInputBoundary;
import InputBoundary.playSpaceInputBoundary;
import InputBoundary.recommendationInputBoundary;
import InputData.playSpaceInputData;
import InputData.playlistInputData;
import InputData.songInputData;
import OutputBoundary.songOutputBoundary;
import OutputBoundary.spacePlayedOutputBoundary;
import UseCase.*;

import java.util.ArrayList;

/**
 * Interface adapters layer controller for use cases involving audio output.
 */

public class musicEngineController {
    private final int SONG = 0;
    private final int PLAYLIST = 1;
    private final int SPACE = 2;
    private final int NONE = -1;
    private final playSpaceInputBoundary playSpaceInteractor;
    private final spacePlayedOutputBoundary spacePresenter;
    private final ArrayList<songInputData> spaceSongList;
    private final songOutputBoundary songPresenter;
    private int playing;
    private playPlaylistInputBoundary playPlaylist;
    private NextSongInputBoundary nextSong;
    private final pauseSongInputBoundary pauseSong;

    /**
     * @param spacePresenter presenter object to return space data to the view
     * @param songPresenter presenter object to return song data to the view
     */
    public musicEngineController(spacePlayedOutputBoundary spacePresenter, songOutputBoundary songPresenter) {
        this.spacePresenter = spacePresenter;
        this.spaceSongList = new ArrayList<>();
        this.pauseSong = new pauseSong();
        this.songPresenter = songPresenter;
        this.playing = NONE;
        this.playSpaceInteractor = new playSpaceInteractor(this.spacePresenter,
                new playSpaceInputData(this.spaceSongList),
                this.songPresenter);
    }

    /**
     * Function calling the use case for playing song
     * @param id the integer id of the Song to be played
     */
    public void playSong(int id) {
        stop();
        songInputData data = new songInputData(id);
        playSongInputBoundary playSong = new playSongInteractor(data, this.songPresenter);
        playSong.playSong();
        playing = SONG;
    }

    /**
     * function calling the use case for playing the space
     */
    public void playSpace(){
        stop();
        playSpaceInputData playSpaceInputData = new playSpaceInputData(this.spaceSongList);
        this.playSpaceInteractor.playSpace(playSpaceInputData);
    }

    /**
     * function calling the use case for adding a song to the space
     * @param songInputData input data for adding a song to the space
     */
    public void spaceAddSong(songInputData songInputData){
        Integer songToAddID = songInputData.getSong().getID();
        for (songInputData currSongInputData : this.spaceSongList){
            Integer currSongID = currSongInputData.getSong().getID();
            if (currSongID.equals(songToAddID)){
                return;  // if the song is already in the playlist, do nothing
                // TODO: make this cooler (i.e. upvote algo) if time
            }
        }
        this.spaceSongList.add(songInputData);  // song is not in list, so append to the end
        if (playing == SPACE){
            this.playSpaceInteractor.updateSpace(new playSpaceInputData(this.spaceSongList));
        }
    }

    // TODO: write unit tests

    /**
     * Function calling the use case for pausing or resuming song
     */
    public void pauseSong() {
        if (playing != NONE)
            pauseSong.pause();
    }

    /**
     * Function calling the use case for playing song
     * @param id integer id of the playlist to be played
     */
    public void playPlaylist(int id) {
        stop();
        playlistInputData data = new playlistInputData(id);
        playPlaylist = new playPlaylist(data, this.songPresenter);
        nextSong = new NextSong(data, this.songPresenter);
        playPlaylist.play();
        playing = PLAYLIST;
    }

    /**
     * runs recommend use case on a given playlist, playing the recommendation when done
     * @param id the integer id of the playlist to recommend from
     */
    public void playRecommendation(int id){
        stop();
        playlistInputData data = new playlistInputData(id);
        recommendationInputBoundary recommend = new recommendSong(data, songPresenter);
        recommend.recommendation();
        playing = SONG;
    }

    /**
     * Skips the current song, if a playlist is playing. The playlist is the only possible
     * entity which can require skipping, since spaces are radios and single songs have
     * nothing to skip to.
     */
    public void playNext(){
        if (playing == PLAYLIST){
            stop();
            nextSong.skipSong();
        }
    }

    /**


     * Private helper method to stop the currently playing queue, if it exists.
     */
    private void stop(){
        switch (playing){
            case NONE:
            case SONG:
                break;
            case PLAYLIST:
                this.playPlaylist.stopQueue();
            case SPACE:
                this.playSpaceInteractor.stopSpace();
                this.spacePresenter.spaceNotPlayed();
        }
    }
}
