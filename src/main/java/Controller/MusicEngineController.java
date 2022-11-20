package Controller;

import InputBoundary.*;
import InputBoundary.PlaySongInputBoundary;
import InputBoundary.PlaySpaceInputBoundary;
import InputBoundary.RecommendationInputBoundary;
import InputData.PlaySpaceInputData;
import InputData.PlaylistInputData;
import InputData.SongInputData;
import OutputBoundary.SongOutputBoundary;
import OutputBoundary.SpacePlayedOutputBoundary;
import UseCase.*;

import java.util.ArrayList;

public class MusicEngineController {
    private final int SONG = 0;
    private final int PLAYLIST = 1;
    private final int SPACE = 2;
    private final int NONE = -1;
    private final PlaySpaceInputBoundary playSpaceInteractor;
    private final SpacePlayedOutputBoundary spacePresenter;
    private final ArrayList<SongInputData> spaceSongList;
    private final SongOutputBoundary songPresenter;
    private int playing;
    private final PlayPlaylistInputBoundary playPlaylist;
    private final NextSongInputBoundary nextSong;
    
    public MusicEngineController(SpacePlayedOutputBoundary spacePresenter, SongOutputBoundary songPresenter) {
        this.spacePresenter = spacePresenter;
        this.spaceSongList = new ArrayList<>();
        this.songPresenter = songPresenter;
        this.playing = NONE;
        this.playSpaceInteractor = new PlaySpaceInteractor(this.spacePresenter, this.songPresenter);
        this.playPlaylist = new PlayPlaylist(songPresenter);
        this.nextSong = new NextSong(songPresenter);
    }

    /**
     * Function calling the use case for playing song
     * @param id the integer id of the Song to be played
     */
    public void playSong(int id) {
        stop();
        SongInputData data = new SongInputData(id);
        PlaySongInputBoundary playSong = new PlaySongInteractor(this.songPresenter);
        playSong.playSong(data);
        playing = SONG;
    }

    /**
     * function calling the use case for playing the space
     */
    public void playSpace(){
        stop();
        PlaySpaceInputData playSpaceInputData = new PlaySpaceInputData(this.spaceSongList);
        this.playSpaceInteractor.playSpace(playSpaceInputData);
    }

    /**
     * function calling the use case for adding a song to the space
     * @param songInputData input data for adding a song to the space
     */
    public void spaceAddSong(SongInputData songInputData){
        int songToAddID = songInputData.getSong().getID();
        for (SongInputData currSongInputData : this.spaceSongList){
            int currSongID = currSongInputData.getSong().getID();
            if (currSongID == songToAddID){
                return;  // if the song is already in the playlist, do nothing
                // TODO: make this cooler (i.e. upvote algo) if time
            }
        }
        this.spaceSongList.add(songInputData);  // song is not in list, so append to the end
        if (playing == SPACE){
            this.playSpaceInteractor.updateSpace(new PlaySpaceInputData(this.spaceSongList));
        }
    }

    // TODO: write unit tests

    /**
     * Function calling the use case for pausing or resuming song
     */
    public void pauseSong() {
        PauseSongInputBoundary pauseSong = new PauseSong();
        if (playing != NONE)
            pauseSong.pause();
    }

    /**
     * Function calling the use case for playing song
     * @param id integer id of the playlist to be played
     */
    public void playPlaylist(int id) {
        stop();
        PlaylistInputData data = new PlaylistInputData(id);
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
        PlaylistInputData data = new PlaylistInputData(id);
        RecommendationInputBoundary recommend = new RecommendSong(songPresenter);
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
