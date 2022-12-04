package outputBoundary;

import outputData.SongOutputData;

/**
 * Use case layer output boundary that allows communication between presenters and the play song use case.
 */
public interface SongOutputBoundary {

    /**
     * update the play bar when a song starts to play
     * @param songOutputData the song that is being played
     */
    void songPlayed(SongOutputData songOutputData);
}
