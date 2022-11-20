package UseCase;

import InputBoundary.ShufflePlaylistInputBoundary;
import InputData.PlaylistInputData;
import java.util.Collections;

/**
 *
 */
public class ShufflePlaylist implements ShufflePlaylistInputBoundary {

    /**
     * Empty Constructor
     */
    public ShufflePlaylist() {
    }

    @Override
    public void shuffle(PlaylistInputData playlist) {
        Collections.shuffle(playlist.getSongs());
    }
}
