package UseCase;

import Entities.MusicPlayer;
import Entities.Song;
import InputBoundary.NextSongInputBoundary;
import InputBoundary.playPlaylistInputBoundary;
import InputData.playlistInputData;
import OutputBoundary.songOutputBoundary;

import java.util.ArrayList;

public class NextSong implements NextSongInputBoundary {
    private final ArrayList<Song> playlist;
    private final String name;
    private final songOutputBoundary presenter;

    public NextSong(playlistInputData data, songOutputBoundary presenter){
        this.playlist = data.getSongs();
        this.presenter = presenter;
        this.name = data.getName();
    }

    @Override
    public void skipSong() {
        MusicPlayer mp = MusicPlayer.getInstance();
        int id = playlist.size() - 1;
        if (mp.getCurrentSong() != null){
            // grab the index of the currently playing song
            id = playlist.indexOf(mp.getCurrentSong());
        }

        if (id == playlist.size() - 1){
            mp.close();
            presenter.songPlayed(null);
            return;
        }

        playlistInputData newPlaylist = new playlistInputData(name, playlist.subList(id + 1, playlist.size() - 1));
        // play playlist handles presenter call
        playPlaylistInputBoundary play = new playPlaylist(newPlaylist, presenter);
        play.play();
    }
}
