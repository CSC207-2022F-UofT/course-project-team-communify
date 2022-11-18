package UseCase;

import Entities.MusicPlayer;
import Entities.Song;
import InputBoundary.NextSongInputBoundary;
import InputBoundary.playPlaylistInputBoundary;
import InputData.playlistInputData;
import OutputBoundary.songOutputBoundary;

import java.util.ArrayList;

public class NextSong implements NextSongInputBoundary {
    private ArrayList<Song> playlist;
    private String name;
    private final songOutputBoundary presenter;

    public NextSong(songOutputBoundary presenter){
        this.presenter = presenter;
    }

    public void updatePlaylist(playlistInputData data){
        this.playlist = data.getSongs();
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
        playPlaylistInputBoundary play = new playPlaylist(presenter);
        play.play(newPlaylist);
    }
}
