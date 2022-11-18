package InputBoundary;

/**
 * Use case layer input boundary that allows communication between outer layers and the pause song use case.
 */
public interface pauseSongInputBoundary {
    /**
     * Pauses the currently playing song.
     */
    void pause();
}
