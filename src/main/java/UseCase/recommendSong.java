package UseCase;

import Database.GetSongAccessInterface;
import Database.songDsData;
import Database.songLibrary;
import Entities.Song;
import InputBoundary.recommendationInputBoundary;
import InputData.playlistInputData;
import InputData.songInputData;
import OutputBoundary.songOutputBoundary;

import java.util.ArrayList;
import java.util.Random;

/**
 * Application Business Rules layer Use Case Interactor for generating a recommendation based on
 * a given Playlist.
 */
public class recommendSong implements recommendationInputBoundary {
    private final GetSongAccessInterface library;
    private final songOutputBoundary out;

    public recommendSong(songOutputBoundary out){
        this.library = songLibrary.getInstance();
        this.out = out;
    }

    /**
     * Generates a recommendation based on the given Playlist in the constructor.
     */
    @Override
    public void recommendation(playlistInputData data) {
        Random random = new Random();
        ArrayList<Song> playlist = data.getSongs();

        Song randomSong = playlist.get(random.nextInt(playlist.size()));
        String genre = randomSong.getGenre();
        Song rec = null;

        for (songDsData song : library.getLibrary()){
            if (rec == null){
                rec = song.getSong();
            }
            if (genre.equals(song.getGenre()) & !playlist.contains(song.getSong())) {
                rec = song.getSong();
                break;
            }
        }

        playSongInteractor play = new playSongInteractor(out);
        play.playSong(new songInputData(rec));
    }
}
