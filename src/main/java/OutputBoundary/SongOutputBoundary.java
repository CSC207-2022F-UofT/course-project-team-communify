package OutputBoundary;

import OutputData.SongOutputData;

public interface SongOutputBoundary {

    /**
     * update the playbar when a song starts to play
     * @param songOutputData the song that is being played
     */
    public void songPlayed(SongOutputData songOutputData);
}
