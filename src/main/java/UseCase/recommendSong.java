package UseCase;

import Database.songAccessInterface;
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
    songAccessInterface library;
    songOutputBoundary out;
    playlistInputData data;

    /**
     * @param data the playlist to recommend a song for
     * @param out the presenter for PlaySong to output to the view
     */
    public recommendSong(playlistInputData data, songOutputBoundary out){
        this.library = songLibrary.getInstance();
        this.out = out;
        this.data = data;
    }

    /**
     * Generates a recommendation based on the given Playlist in the constructor.
     */
    @Override
    public void recommendation() {
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

        playSongInteractor play = new playSongInteractor(new songInputData(rec), out);
        play.playSong();
    }
}
