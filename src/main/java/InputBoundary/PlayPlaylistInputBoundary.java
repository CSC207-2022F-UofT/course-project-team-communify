package inputBoundary;

import inputData.PlaylistInputData;

/**
 * Use case layer input boundary that allows communication between outer layers and the play playlist use case.
 */
public interface PlayPlaylistInputBoundary {
    /**
     * Plays the playlist given in the constructor.
     *
     * @param data the input data containing the playlist to play
     * @return whether there are songs left to play
     */
    boolean play(PlaylistInputData data);

    /**
     * Dequeues the playlist, such that after the currently playing song ends the playlist
     * will not continue. Must be called whenever audio source is switched (e.g. user plays new song,
     * different playlist, or space).
     */
    void stopQueue();
}
