package InputBoundary;

/**
 * Use case layer input boundary that allows communication between outer layers and the next song use case.
 */
public interface NextSongInputBoundary {
    /**
     * Method to skip to the next song in a playlist, if there is one.
     */
    void skipSong();
}
