package Controller;

import InputBoundary.*;
import InputBoundary.playSongInputBoundary;
import InputBoundary.playSpaceInputBoundary;
import InputBoundary.recommendationInputBoundary;
import InputData.playSpaceInputData;
import InputData.playlistInputData;
import InputData.songInputData;
import OutputBoundary.songOutputBoundary;
import OutputBoundary.SpacePlayedOutputBoundary;
import UseCase.*;
import java.util.ArrayList;

public class musicEngineController {
    private final int SONG = 0;
    private final int PLAYLIST = 1;
    private final int SPACE = 2;
    private final int NONE = -1;
    private final playSpaceInputBoundary playSpaceInteractor;
    private final SpacePlayedOutputBoundary spacePresenter;
    private final ArrayList<songInputData> spaceSongList;
    private final songOutputBoundary songPresenter;
    private int playing;
    private final playPlaylistInputBoundary playPlaylist;
    private final NextSongInputBoundary nextSong;

    public musicEngineController(SpacePlayedOutputBoundary spacePresenter, songOutputBoundary songPresenter) {
        this.spacePresenter = spacePresenter;
        this.spaceSongList = new ArrayList<>();
        this.songPresenter = songPresenter;
        this.playing = NONE;
        this.playSpaceInteractor = new playSpaceInteractor(this.spacePresenter, this.songPresenter);
        this.playPlaylist = new playPlaylist(songPresenter);
        this.nextSong = new NextSong(songPresenter);
    }

    /**
     * Function calling the use case for playing song
     * @param id the integer id of the Song to be played
     */
    public void playSong(int id) {
        stop();
        songInputData data = new songInputData(id);
        playSongInputBoundary playSong = new playSongInteractor(this.songPresenter);
        playSong.playSong(data);
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
     * @param songToAddID id of song to add to space
     */
    public void spaceAddSong(int songToAddID){
        for (songInputData currSongInputData : this.spaceSongList){
            int currSongID = currSongInputData.getSong().getID();
            if (currSongID == songToAddID){
                this.spacePresenter.notAddedToSpace(currSongInputData.getName());
                return;  // if the song is already in the playlist, do nothing
                // TODO: make this cooler (i.e. upvote algo) if time
            }
        }
        songInputData songToAdd = new songInputData(songToAddID);  // song is not in list, so append to the end
        this.spaceSongList.add(songToAdd);
        if (playing == SPACE) {
            this.playSpaceInteractor.updateSpace(new playSpaceInputData(this.spaceSongList));
        }
        this.spacePresenter.addedToSpace(songToAdd.getName());
    }

    // TODO: write unit tests

    /**
     * Function calling the use case for pausing or resuming song
     */
    public void pauseSong() {
        pauseSongInputBoundary pauseSong = new pauseSong();
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
        this.nextSong.updatePlaylist(data);
        playPlaylist.play(data);
        playing = PLAYLIST;
    }

    /**
     * runs recommend use case on a given playlist, playing the recommendation when done
     * @param id the integer id of the playlist to recommend from
     */
    public void playRecommendation(int id){
        stop();
        playlistInputData data = new playlistInputData(id);
        recommendationInputBoundary recommend = new recommendSong(songPresenter);
        recommend.recommendation(data);
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
