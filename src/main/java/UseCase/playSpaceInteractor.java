package UseCase;

import Database.songDsData;
import Entities.MusicPlayer;
import InputBoundary.playSpaceInputBoundary;
import InputData.playSpaceInputData;
import InputData.songInputData;
import OutputData.songOutputData;

import java.util.*;

/**
 * use case for playing a space
 */
public class playSpaceInteractor implements playSpaceInputBoundary {

    // instance of global playlistLibrary
    private final Database.songLibrary songLibrary;
    private final OutputBoundary.spacePlayedOutputBoundary spacePlayedOutputBoundary;
    private final Object sync;
    private final InputData.playSpaceInputData playSpaceInputData;
    private boolean keepPlaying;

    /**
     * constructor
     */
    public playSpaceInteractor(OutputBoundary.spacePlayedOutputBoundary spacePlayedOutputBoundary,
                               playSpaceInputData playSpaceInputData){
        this.spacePlayedOutputBoundary = spacePlayedOutputBoundary;
        this.songLibrary = Database.songLibrary.getInstance();
        this.sync = MusicPlayer.getInstance().getSync();
        this.keepPlaying = true;
        this.playSpaceInputData = playSpaceInputData;
    }

    /**
     * calls playSong's actuallyPlaySong function
     */
    @Override
    public void playSpace(playSpaceInputData playSpaceInputData){
        ArrayList<songInputData> spaceSongList = playSpaceInputData.getSpaceSongList();
        songOutputData songToPlay = pickSongToPlay(spaceSongList);

        // open queue
        final Thread thread = new Thread(this::playNextSong);
        thread.start();

        // call presenter
        this.spacePlayedOutputBoundary.spacePlayed();  // update button
        this.spacePlayedOutputBoundary.songPlayed(songToPlay);  // update playbar

        playSongInteractor.playAudio(songToPlay.getFile());  // play the song
    }

    private songOutputData pickSongToPlay(ArrayList<songInputData> spaceSongList){
        songOutputData songToPlay;
        if (!spaceSongList.isEmpty()){
            songToPlay = new songOutputData(spaceSongList.remove(0).getSong());  // remove song to be played
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
    private void stopSpace(){
        this.keepPlaying = false;
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
                this.playSpace(this.playSpaceInputData);
            }
        }
    }

}
