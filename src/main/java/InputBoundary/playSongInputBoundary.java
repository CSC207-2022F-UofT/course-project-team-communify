package InputBoundary;

import InputData.songInputData;
/**
 * Use case layer input boundary that allows communication between outer layers and the play song use case.
 */
public interface playSongInputBoundary {
    /**
     * Plays a song.
     * @param s the song to play
     */
    void playSong(songInputData s);
}
