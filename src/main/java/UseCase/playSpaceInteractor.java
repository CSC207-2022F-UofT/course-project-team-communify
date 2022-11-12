package UseCase;

import Database.songDsData;
import Entities.Song;
import InputBoundary.playSpaceInputBoundary;
import InputData.songInputData;
import OutputData.songOutputData;

import java.util.*;

/**
 * use case for playing a space
 */
public class playSpaceInteractor implements playSpaceInputBoundary {

    // instance of global playlistLibrary
    private final Database.songLibrary songLibrary;

    /**
     * constructor
     */
    public playSpaceInteractor(){
        this.songLibrary = Database.songLibrary.getInstance();
    }

    /**
     * calls playSong's actuallyPlaySong function
     */
    @Override
    public void playSpace(songInputData songInputData){
        // get values
        Song songToPlay = songInputData.getSong();
        playSong.playAudio(songToPlay.getFile());  // play the song
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

}
