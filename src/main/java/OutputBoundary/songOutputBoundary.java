package OutputBoundary;

import OutputData.songOutputData;

/**
 * Use case layer output boundary that allows communication between presenters and the play song use case.
 */
public interface songOutputBoundary {

    /**
     * update the playbar when a song starts to play
     * @param songOutputData the song that is being played
     */
    void songPlayed(songOutputData songOutputData);
}
