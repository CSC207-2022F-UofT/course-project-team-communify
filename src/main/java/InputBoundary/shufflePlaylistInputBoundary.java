package InputBoundary;

import InputData.playlistInputData;

/**
 * Interface for the shufflePlaylist to implement for the use case
 */
public interface shufflePlaylistInputBoundary {

    /**
     * Shuffles the order of a playlist.
     * @param playlist the playlist to shuffle
     */
    void shuffle(playlistInputData playlist);

}
