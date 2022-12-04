package useCase;

import inputBoundary.ShufflePlaylistInputBoundary;
import inputData.PlaylistInputData;
import java.util.Collections;

/**
 * Application business rules use case class to shuffle a playlist.
 */
public class ShufflePlaylistInteractor implements ShufflePlaylistInputBoundary {

    /**
     * Empty Constructor
     */
    public ShufflePlaylistInteractor() {
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
