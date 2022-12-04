package useCase;

import entities.MusicPlayer;
import entities.Song;
import inputBoundary.NextSongInputBoundary;
import inputBoundary.PlayPlaylistInputBoundary;
import inputData.PlaylistInputData;
import outputBoundary.SongOutputBoundary;

import java.util.ArrayList;
/**
 * Application business rules use case class to skip a song.
 */
public class NextSongInteractor implements NextSongInputBoundary {
    private ArrayList<Song> playlist;
    private String name;
    private final SongOutputBoundary presenter;
    private PlayPlaylistInputBoundary play;

    /**
     * @param presenter the presenter for song output
     * @param play the play playlist interactor
     */
    public NextSongInteractor(SongOutputBoundary presenter, PlayPlaylistInputBoundary play){
        this.presenter = presenter;
        this.play = play;
    }

    /**
     * @param data the new playlist to skip songs on
     */
    @Override
    public void updatePlaylist(PlaylistInputData data){
        this.playlist = data.getSongs();
        this.name = data.getName();
    }

    /**
     * @return the new play playlist interactor
     */
    @Override
    public PlayPlaylistInputBoundary skipSong() {
        MusicPlayer mp = MusicPlayer.getInstance();
        this.play = new PlayPlaylistInteractor(this.presenter);

        int id = playlist.size() - 1;
        if (mp.getCurrentSong() != null){
            // grab the index of the currently playing song
            id = playlist.indexOf(mp.getCurrentSong());
        }

        if (id == playlist.size() - 1){
            presenter.songPlayed(null);
            mp.close();
            return null;
        }

        PlaylistInputData newPlaylist = new PlaylistInputData(name, playlist.subList(id + 1, playlist.size()));
        // play playlist handles presenter call
        this.play.play(newPlaylist);
        return play;
    }
}
