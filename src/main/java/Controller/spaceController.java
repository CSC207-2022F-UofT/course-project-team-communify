package Controller;

import Entities.MusicPlayer;
import InputBoundary.playSpaceInputBoundary;
import InputData.songInputData;
import OutputData.songOutputData;
import Presenter.spacePresenter;

import java.util.ArrayList;


/**
 * Controller for use cases related to the Space.
 */
public class spaceController {
    private final playSpaceInputBoundary playSpaceInteractor;
    private final ArrayList<songInputData> spaceSongList;
    private final Presenter.spacePresenter spacePresenter; // not OutputBoundary because in the same layer as Controller
    private final Object sync;
    private boolean keepPlaying;

    /**
     * Constructor.
     * @param spacePlayInteractor use case interactor for playing the space
     */
    public spaceController(playSpaceInputBoundary spacePlayInteractor, spacePresenter spacePresenter){
        this.playSpaceInteractor = spacePlayInteractor;
        this.spaceSongList = new ArrayList<>();
        this.sync = MusicPlayer.getInstance().getSync();
        this.keepPlaying = true;
        this.spacePresenter = spacePresenter;
    }

    /**
     * function calling the use case for playing the space
     */
    public void playSpace(){
        // pick which song to be played
        songOutputData songToPlay;
        if (!this.spaceSongList.isEmpty()){
            songToPlay = new songOutputData(this.spaceSongList.remove(0).getSong());  // remove song to be played
        }
        else{
            songToPlay = this.playSpaceInteractor.pickRandomSong();
        }

        // open queue
        final Thread thread = new Thread(this::playNextSong);
        thread.start();

        // call presenter
        this.spacePresenter.spacePlayed();  // update button
        this.spacePresenter.songPlayed(songToPlay);  // update playbar

        // play the song
        this.playSpaceInteractor.playSpace(new songInputData(songToPlay.getSong()));
    }

    /**
     * helper function for playSpace()
     */
    private void playNextSong(){
        synchronized (sync){
            try{
                sync.wait();
            } catch (InterruptedException e) {
                System.out.println("thread interrupted");
            }
            if (keepPlaying){  // start all over again
                this.playSpace();
            }
        }
    }

    /**
     * in order to stop infinite recursion, call stopSpace.
     */
    private void stopSpace(){
        this.keepPlaying = false;
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

}
