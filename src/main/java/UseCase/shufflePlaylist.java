package UseCase;

import InputBoundary.shufflePlaylistInputBoundary;
import InputData.playlistInputData;
import java.util.Collections;

/**
 * Application business rules use case class to shuffle a playlist.
 */
public class shufflePlaylist implements shufflePlaylistInputBoundary {

    /**
     * Empty Constructor
     */
    public shufflePlaylist() {
    }

    /**
     * Shuffles a given playlist.
     * @param playlist the playlist to shuffle
     */
    @Override
    public void shuffle(playlistInputData playlist) {
        Collections.shuffle(playlist.getSongs());
    }
}
