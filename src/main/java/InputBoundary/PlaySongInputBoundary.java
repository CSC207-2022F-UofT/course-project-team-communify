package InputBoundary;

import InputData.SongInputData;
/**
 * Use case layer input boundary that allows communication between outer layers and the play song use case.
 */
public interface PlaySongInputBoundary {
    /**
     * Plays a song.
     * @param s the song to play
     */
    void playSong(SongInputData s);
}
