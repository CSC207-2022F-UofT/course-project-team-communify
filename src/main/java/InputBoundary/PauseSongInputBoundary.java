package InputBoundary;
/**
 * Use case layer input boundary that allows communication between outer layers and the pause use case.
 */
public interface PauseSongInputBoundary {
    /**
     * Pauses or resumes the currently playing song.
     */
    void pause();
}
