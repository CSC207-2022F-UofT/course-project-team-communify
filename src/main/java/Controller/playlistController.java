package Controller;

import Entities.Song;
import InputBoundary.shufflePlaylistInputBoundary;
import InputData.playlistInputData;
import java.util.LinkedList;

// Adding changes to this file so I can use it for the shuffle method

/**
 * Controller for the shufflePlaylist use case
 */
public class playlistController {

    private final shufflePlaylistInputBoundary shufflePlaylistInteractor;

    public playlistController(shufflePlaylistInputBoundary shufflePlaylistInteractor) {
        this.shufflePlaylistInteractor = shufflePlaylistInteractor;
    }

    public void shufflePlaylist(String name, LinkedList<Song> songList) {
        playlistInputData playlistInput = new playlistInputData(name, songList);
        this.shufflePlaylistInteractor.shuffle(playlistInput);
    }

}
