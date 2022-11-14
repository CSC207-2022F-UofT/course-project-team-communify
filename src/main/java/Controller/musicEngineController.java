package Controller;

import InputData.audioInputData;
import InputData.playlistInputData;
import InputData.songInputData;
import OutputBoundary.songOutputBoundary;
import UseCase.pauseSong;
import UseCase.playAudioInteractor;
import UseCase.playPlaylist;
import UseCase.playSong;

public class musicEngineController {
    private final int SONG = 0;
    private final int PLAYLIST = 1;
    private final int SPACE = 2;
    private final int NONE = -1;
    private int playing;
    private playPlaylist playPlaylist;
    private playSong playSong;
    private final pauseSong pauseSong;
    private final playAudioInteractor playAudio;
    songOutputBoundary presenter;

    public musicEngineController(songOutputBoundary p) {
        this.playAudio = new playAudioInteractor();
        this.pauseSong = new pauseSong();
        this.presenter = p;
        this.playing = NONE;
    }

    /**
     * Function calling the use case for playing audio
     * @param audioInput is the audioInputData object of the Song
     */
    public void playAudio(audioInputData audioInput) {
        stop();
        playAudio.playAudio(audioInput);
        playing = SONG;
    }

    /**
     * Function calling the use case for playing song
     * @param data songInputData containing Song to be played
     */
    public void playSong(songInputData data) {
        stop();
        playSong = new playSong(data, presenter);
        playSong.play();
        playing = SONG;
    }

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
        playPlaylist = new playPlaylist(data, presenter);
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
                // TODO: implement
        }
    }
}
