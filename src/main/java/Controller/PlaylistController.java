package Controller;

import Entities.Song;
import InputBoundary.ShufflePlaylistInputBoundary;
import InputData.PlaylistInputData;
import java.util.LinkedList;

// Adding changes to this file so I can use it for the shuffle method

/**
 * Controller for the shufflePlaylist use case
 */
public class PlaylistController {

    private final ShufflePlaylistInputBoundary shufflePlaylistInteractor;

    public PlaylistController(ShufflePlaylistInputBoundary shufflePlaylistInteractor) {
        this.shufflePlaylistInteractor = shufflePlaylistInteractor;
    }

    public void shufflePlaylist(String name, LinkedList<Song> songList) {
        PlaylistInputData playlistInput = new PlaylistInputData(name, songList);
        this.shufflePlaylistInteractor.shuffle(playlistInput);
    }

}
