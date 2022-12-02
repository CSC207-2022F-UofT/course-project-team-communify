package Controller;

import InputBoundary.*;
import InputData.PlaySpaceInputData;
import InputData.PlaylistInputData;
import InputData.SongInputData;
import OutputBoundary.SongOutputBoundary;
import OutputBoundary.SpacePlayedOutputBoundary;
import UseCase.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Interface adapters layer controller for playing music use cases.
 */
public class MusicEngineController {
    private final int SONG = 0;
    private final int PLAYLIST = 1;
    private final int SPACE = 2;
    private final int NONE = -1;
    private final PlaySpaceInputBoundary playSpaceInteractor;
    private final SpacePlayedOutputBoundary spacePresenter;
    private final List<SongInputData> spaceSongList;
    private final SongOutputBoundary songPresenter;
    private int playing;
    private PlayPlaylistInputBoundary playPlaylist;
    private final NextSongInputBoundary nextSong;

    /**
     * @param spacePresenter the presenter for space output
     * @param songPresenter the presenter for song output
     */
    public MusicEngineController(SpacePlayedOutputBoundary spacePresenter, SongOutputBoundary songPresenter) {
        this.spacePresenter = spacePresenter;
        this.spaceSongList = new ArrayList<>();
        this.songPresenter = songPresenter;
        this.playing = NONE;
        PlaySpaceInputData playSpaceInputData = new PlaySpaceInputData(this.spaceSongList);
        this.playSpaceInteractor = new PlaySpaceInteractor(this.songPresenter, playSpaceInputData);
        this.playPlaylist = new PlayPlaylist(songPresenter);
        this.nextSong = new NextSong(songPresenter, this.playPlaylist);

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
        this.playing = SONG;
    }

    /**
     * function calling the use case for playing the space
     */
    public void playSpace(){
        stop();
        this.playSpaceInteractor.playSpace();
        this.playing = this.SPACE;
    }

    /**
     * function calling the use case for adding a song to the space
     * @param songToAddID id of song to add to space
     */
    public void spaceAddSong(int songToAddID){
        for (SongInputData currSongInputData : this.spaceSongList){
            int currSongID = currSongInputData.getSong().getID();
            if (currSongID == songToAddID){
                this.spacePresenter.notAddedToSpace(currSongInputData.getName());
                return;  // if the song is already in the playlist, do nothing
                // TODO: make this cooler (i.e. upvote algo) if time
            }
        }
        SongInputData songToAdd = new SongInputData(songToAddID);  // song is not in list, so append to the end
        this.spaceSongList.add(songToAdd);
        if (this.playing == SPACE) {
            this.playSpaceInteractor.updateSpace(new PlaySpaceInputData(this.spaceSongList));
        }
        this.spacePresenter.addedToSpace(songToAdd.getName());
    }

    /**
     * Function calling the use case for pausing or resuming song
     */
    public void pauseSong() {
        stop();
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
        playing = PLAYLIST;
        this.playPlaylist = new PlayPlaylist(this.songPresenter);
        PlaylistInputData data = new PlaylistInputData(id);
        this.nextSong.updatePlaylist(data);
        if (!this.playPlaylist.play(data))
            this.playing = NONE;
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
        this.playing = SONG;
    }

    /**
     * Skips the current song, if a playlist is playing. The playlist is the only possible
     * entity which can require skipping, since spaces are radios and single songs have
     * nothing to skip to.
     */
    public void playNext(){
        if (playing == PLAYLIST){
            stop();
            this.playPlaylist = nextSong.skipSong();
            if (this.playPlaylist == null){
                this.playing = NONE;
            }
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
        }
    }

    /**
     * @return the type of media currently playing
     */
    public int getPlaying() {
        return playing;
    }
}
