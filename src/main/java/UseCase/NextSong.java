package UseCase;

import Entities.MusicPlayer;
import Entities.Song;
import InputBoundary.NextSongInputBoundary;
import InputBoundary.PlayPlaylistInputBoundary;
import InputData.PlaylistInputData;
import OutputBoundary.SongOutputBoundary;

import java.util.ArrayList;

public class NextSong implements NextSongInputBoundary {
    private ArrayList<Song> playlist;
    private String name;
    private final SongOutputBoundary presenter;

    public NextSong(SongOutputBoundary presenter){
        this.presenter = presenter;
    }

    public void updatePlaylist(PlaylistInputData data){
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

        PlaylistInputData newPlaylist = new PlaylistInputData(name, playlist.subList(id + 1, playlist.size() - 1));
        // play playlist handles presenter call
        PlayPlaylistInputBoundary play = new PlayPlaylist(presenter);
        play.play(newPlaylist);
    }
}
