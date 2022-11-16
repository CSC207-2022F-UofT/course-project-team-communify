package UseCase;

import InputBoundary.shufflePlaylistInputBoundary;
import InputData.playlistInputData;
import java.util.Collections;

/**
 *
 */
public class shufflePlaylist implements shufflePlaylistInputBoundary {

    /**
     * Empty Constructor
     */
    public shufflePlaylist() {
    }

    @Override
    public void shuffle(playlistInputData playlist) {
        Collections.shuffle(playlist.getSongs());
    }
}
