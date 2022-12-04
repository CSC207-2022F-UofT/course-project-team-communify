package controller;

import entities.Song;
import inputBoundary.ShufflePlaylistInputBoundary;
import inputData.PlaylistInputData;
import java.util.LinkedList;

/**
 * Controller for the shufflePlaylist use case
 */
public class PlaylistController {

    private final ShufflePlaylistInputBoundary shufflePlaylistInteractor;

    /**
     * @param shufflePlaylistInteractor shuffle interactor to run shuffle use case
     */
    public PlaylistController(ShufflePlaylistInputBoundary shufflePlaylistInteractor) {
        this.shufflePlaylistInteractor = shufflePlaylistInteractor;
    }

    /**
     * Shuffles a given list of songs by calling the use case.
     * @param name name of the playlist
     * @param songList list of songs to be shuffled
     */
    public void shufflePlaylist(String name, LinkedList<Song> songList) {
        PlaylistInputData playlistInput = new PlaylistInputData(name, songList);
        this.shufflePlaylistInteractor.shuffle(playlistInput);
    }

}
