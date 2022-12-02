package UseCase;

import InputBoundary.ShufflePlaylistInputBoundary;
import InputData.PlaylistInputData;
import java.util.Collections;

/**
 * Application business rules use case class to shuffle a playlist.
 */
public class ShufflePlaylist implements ShufflePlaylistInputBoundary {

    /**
     * Empty Constructor
     */
    public ShufflePlaylist() {
    }

    /**
     * Shuffles a given playlist.
     * @param playlist the playlist to shuffle
     */
    @Override
    public void shuffle(PlaylistInputData playlist) {
        Collections.shuffle(playlist.getSongs());
    }
}
