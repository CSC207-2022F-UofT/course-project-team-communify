package InputBoundary;

/**
 * Use case layer input boundary that allows communication between outer layers and the play playlist use case.
 */
public interface playPlaylistInputBoundary {
    /**
     * Plays the playlist given in the constructor.
     */
    public void play();

    /**
     * Dequeues the playlist, such that after the currently playing song ends the playlist
     * will not continue. Must be called whenever audio source is switched (eg. user plays new song,
     * different playlist, or space).
     */
    public void stopQueue();
}
