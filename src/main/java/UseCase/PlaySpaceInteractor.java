package useCase;

import database.SongDsData;
import database.SongLibrary;
import entities.MusicPlayer;
import inputBoundary.PlaySpaceInputBoundary;
import inputData.PlaySpaceInputData;
import inputData.SongInputData;
import outputBoundary.SongOutputBoundary;
import outputData.SongOutputData;

import java.util.*;

/**
 * use case for playing a space
 */
public class PlaySpaceInteractor implements PlaySpaceInputBoundary {

    // instance of global playlistLibrary
    private final SongLibrary songLibrary;
    private final Object sync;
    private PlaySpaceInputData playSpaceInputData;
    // we decided on avoiding storing input data in interactor, but it is needed for queueing
    private final SongOutputBoundary songOutputBoundary;
    private boolean keepPlaying;

    /**
     * constructor
     * @param songOutputBoundary the song output presenter
     * @param playSpaceInputData the space input data to play
     */
    public PlaySpaceInteractor(SongOutputBoundary songOutputBoundary, PlaySpaceInputData playSpaceInputData){
        this.songLibrary = SongLibrary.getInstance();
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
        SongOutputData songToPlay = this.pickSongToPlay();

        // open queue
        final Thread thread = new Thread(this::playNextSong);
        thread.start();

        PlaySongInteractor playSongInteractor = new PlaySongInteractor(this.songOutputBoundary);

        playSongInteractor.playSong(new SongInputData(songToPlay.getSong()));
        // play the song; this will also call presenter to update play bar
    }

    /**
     * @return a random song to play
     */
    private SongOutputData pickSongToPlay(){
        SongOutputData songToPlay;
        if (!this.playSpaceInputData.getSpaceSongList().isEmpty()){
            songToPlay = new SongOutputData(this.playSpaceInputData.getSpaceSongList().remove(0).getSong());
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
    public SongOutputData pickRandomSong(){
        ArrayList<SongDsData> possibleSongs = new ArrayList<>(this.songLibrary.getLibrary());
        int randomIndex = new Random().nextInt(possibleSongs.size());
        SongDsData randomSong = possibleSongs.get(randomIndex);
        return new SongOutputData(randomSong.getSong());
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
    public void updateSpace(PlaySpaceInputData playSpaceInputData) {
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
