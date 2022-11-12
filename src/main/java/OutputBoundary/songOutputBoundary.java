package OutputBoundary;

import OutputData.songOutputData;

public interface songOutputBoundary {

    /**
     * update the playbar when a song starts to play
     * @param songOutputData the song that is being played
     */
    default void songPlayed(songOutputData songOutputData){
    }
}
