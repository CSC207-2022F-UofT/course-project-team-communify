package UseCase;

import Database.SongDsData;
import Database.SongLibrary;
import Entities.MusicPlayer;
import InputBoundary.PlaySpaceInputBoundary;
import InputData.PlaySpaceInputData;
import InputData.SongInputData;
import OutputBoundary.SongOutputBoundary;
import OutputBoundary.SpacePlayedOutputBoundary;
import OutputData.SongOutputData;

import java.util.*;

/**
 * use case for playing a space
 */
public class PlaySpaceInteractor implements PlaySpaceInputBoundary {

    // instance of global playlistLibrary
    private final SongLibrary songLibrary;
    private final SpacePlayedOutputBoundary spacePlayedOutputBoundary;
    private final Object sync;
    private PlaySpaceInputData playSpaceInputData;
    private final SongOutputBoundary songOutputBoundary;
    private boolean keepPlaying;

    /**
     * constructor
     */
    public PlaySpaceInteractor(SpacePlayedOutputBoundary spacePlayedOutputBoundary,
                               SongOutputBoundary songOutputBoundary){
        this.spacePlayedOutputBoundary = spacePlayedOutputBoundary;
        this.songLibrary = SongLibrary.getInstance();
        this.sync = MusicPlayer.getInstance().getSync();
        this.keepPlaying = true;
        this.songOutputBoundary = songOutputBoundary;
    }

    /**
     * calls playSong's actuallyPlaySong function
     */
    @Override
    public void playSpace(PlaySpaceInputData playSpaceInputData){
        ArrayList<SongInputData> spaceSongList = playSpaceInputData.getSpaceSongList();
        SongOutputData songToPlay = pickSongToPlay(spaceSongList);

        // open queue
        final Thread thread = new Thread(this::playNextSong);
        thread.start();

        // call presenter
        this.spacePlayedOutputBoundary.spacePlayed();  // update button

        PlaySongInteractor playSongInteractor = new PlaySongInteractor(this.songOutputBoundary);

        playSongInteractor.playSong(new SongInputData(songToPlay.getSong()));
        // play the song; this will also call presenter to update playbar
    }

    private SongOutputData pickSongToPlay(ArrayList<SongInputData> spaceSongList){
        SongOutputData songToPlay;
        if (!spaceSongList.isEmpty()){
            songToPlay = new SongOutputData(spaceSongList.remove(0).getSong());  // remove song to be played
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
                this.playSpace(this.playSpaceInputData);
            }
        }
    }

}
