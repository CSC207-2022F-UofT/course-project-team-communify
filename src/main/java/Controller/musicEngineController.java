package Controller;

import InputData.playSpaceInputData;
import InputData.playlistInputData;
import InputData.songInputData;
import OutputBoundary.songOutputBoundary;
import OutputBoundary.spacePlayedOutputBoundary;
import UseCase.pauseSong;
import UseCase.playPlaylist;
import UseCase.playSongInteractor;
import UseCase.playSpaceInteractor;

import java.util.ArrayList;

public class musicEngineController {
    private final int SONG = 0;
    private final int PLAYLIST = 1;
    private final int SPACE = 2;
    private final int NONE = -1;
    private final UseCase.playSpaceInteractor playSpaceInteractor;
    private final spacePlayedOutputBoundary spacePresenter;
    private final ArrayList<songInputData> spaceSongList;
    private final songOutputBoundary songPresenter;
    private int playing;
    private playPlaylist playPlaylist;
    private playSongInteractor playSong;
    private final pauseSong pauseSong;

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
     * @param data songInputData containing Song to be played
     */
    public void playSong(songInputData data) {
        stop();
        playSong = new playSongInteractor(data, this.songPresenter);
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
    }

    // TODO: write unit tests

    /**
     * Function calling the use case for pausing or resuming song
     */
    public void pauseSong() {
        pauseSong.pause();
    }

    /**
     * Function calling the use case for playing song
     * @param data playlistInputData containing Playlist to be played
     */
    public void playPlaylist(playlistInputData data) {
        stop();
        playPlaylist = new playPlaylist(data, this.songPresenter);
        playPlaylist.play();
        playing = PLAYLIST;
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
                playPlaylist.stopQueue();
            case SPACE:
                this.playSpaceInteractor.stopSpace();
                this.spacePresenter.spaceNotPlayed();
        }
    }
}
