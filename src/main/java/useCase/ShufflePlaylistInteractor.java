package useCase;

import entities.Song;
import inputBoundary.PlayPlaylistInputBoundary;
import inputBoundary.ShufflePlaylistInputBoundary;
import inputData.PlaylistInputData;
import outputBoundary.SongOutputBoundary;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Application business rules use case class to shuffle a playlist.
 */
public class ShufflePlaylistInteractor implements ShufflePlaylistInputBoundary {
    private final SongOutputBoundary sp;


    /**
     * @param sp the song presenter object
     */
    public ShufflePlaylistInteractor(SongOutputBoundary sp) {
        this.sp = sp;
    }

    /**
     * Shuffles a given playlist.
     *
     * @param playlist the playlist to shuffle
     * @return the new play playlist object
     */
    @Override
    public PlayPlaylistInputBoundary shuffle(PlaylistInputData playlist) {
        ArrayList<Song> songs = playlist.getSongs();
        Collections.shuffle(songs);
        playlist.setSongList(songs);
        PlayPlaylistInputBoundary playPlaylist = new PlayPlaylistInteractor(sp);
        playPlaylist.play(playlist);
        return playPlaylist;
    }
}
