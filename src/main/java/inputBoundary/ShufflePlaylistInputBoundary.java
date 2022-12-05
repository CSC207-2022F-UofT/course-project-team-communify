package inputBoundary;

import inputData.PlaylistInputData;

/**
 * Interface for the shufflePlaylist to implement for the use case
 */
public interface ShufflePlaylistInputBoundary {

    /**
     * Shuffles the order of a playlist.
     *
     * @param playlist the playlist to shuffle
     * @return the new play playlist object
     */
    PlayPlaylistInputBoundary shuffle(PlaylistInputData playlist);
}
