package UseCase;

import Database.songDsData;
import Entities.MusicPlayer;
import InputBoundary.playSpaceInputBoundary;
import InputData.playSpaceInputData;
import InputData.songInputData;
import OutputBoundary.songOutputBoundary;
import OutputData.songOutputData;

import java.util.*;

/**
 * use case for playing a space
 */
public class playSpaceInteractor implements playSpaceInputBoundary {

    // instance of global playlistLibrary
    private final Database.songLibrary songLibrary;
    private final Object sync;
    private InputData.playSpaceInputData playSpaceInputData;
    // we decided on avoiding storing input data in interactor, but it is needed for queueing
    private final songOutputBoundary songOutputBoundary;
    private boolean keepPlaying;

    /**
     * constructor
     * @param songOutputBoundary the song output presenter
     * @param playSpaceInputData the space input data to play
     */
    public playSpaceInteractor(songOutputBoundary songOutputBoundary, playSpaceInputData playSpaceInputData){
        this.songLibrary = Database.songLibrary.getInstance();
        this.sync = MusicPlayer.getInstance().getSync();
        this.keepPlaying = true;
        this.songOutputBoundary = songOutputBoundary;
        this.playSpaceInputData = playSpaceInputData;
    }

    /**
     * calls playSong's actuallyPlaySong function
     */
    @Override
    public void playSpace(){
        songOutputData songToPlay = this.pickSongToPlay();

        // open queue
        final Thread thread = new Thread(this::playNextSong);
        thread.start();

        playSongInteractor playSongInteractor = new playSongInteractor(this.songOutputBoundary);

        playSongInteractor.playSong(new songInputData(songToPlay.getSong()));
        // play the song; this will also call presenter to update playbar
    }

    /**
     * @return a random song to play
     */
    private songOutputData pickSongToPlay(){
        songOutputData songToPlay;
        if (!this.playSpaceInputData.getSpaceSongList().isEmpty()){
            songToPlay = new songOutputData(this.playSpaceInputData.getSpaceSongList().remove(0).getSong());
            // remove song to be played
        }
        else{
            songToPlay = this.pickRandomSong();
        }
        return songToPlay;
    }

    /**
     * @return a random song from the songLibrary singleton.
     */
    @Override
    public songOutputData pickRandomSong(){
        ArrayList<songDsData> possibleSongs = new ArrayList<>(this.songLibrary.getLibrary());
        int randomIndex = new Random().nextInt(possibleSongs.size());
        songDsData randomSong = possibleSongs.get(randomIndex);
        return new songOutputData(randomSong.getSong());
    }


    /**
     * in order to stop infinite recursion, call stopSpace.
     */
    @Override
    public void stopSpace(){
        this.keepPlaying = false;
    }

    /**
     * in the case that the space is updated while it is playing, this method is called after adding to space
     * @param playSpaceInputData the new space list
     */
    @Override
    public void updateSpace(playSpaceInputData playSpaceInputData) {
        this.playSpaceInputData = playSpaceInputData;
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

}
