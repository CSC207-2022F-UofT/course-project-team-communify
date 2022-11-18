package Controller;

import Entities.Song;
import InputBoundary.shufflePlaylistInputBoundary;
import InputData.playlistInputData;
import java.util.LinkedList;

/**
 * Controller for the shufflePlaylist use case
 */
public class playlistController {

    private final shufflePlaylistInputBoundary shufflePlaylistInteractor;

    /**
     * @param shufflePlaylistInteractor shuffle interactor to run shuffle use case
     */
    public playlistController(shufflePlaylistInputBoundary shufflePlaylistInteractor) {
        this.shufflePlaylistInteractor = shufflePlaylistInteractor;
    }

    /**
     * Shuffles a given list of songs by calling the use case.
     * @param name name of the playlist
     * @param songList list of songs to be shuffled
     */
    public void shufflePlaylist(String name, LinkedList<Song> songList) {
        playlistInputData playlistInput = new playlistInputData(name, songList);
        this.shufflePlaylistInteractor.shuffle(playlistInput);
    }

}
