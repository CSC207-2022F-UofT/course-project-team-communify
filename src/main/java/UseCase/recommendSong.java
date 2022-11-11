package UseCase;

import Database.songAccessInterface;
import Entities.Song;
import InputBoundary.recommendationInputBoundary;
import InputData.playlistInputData;
import OutputBoundary.recommendationOutputBoundary;
import OutputData.songOutputData;

import java.util.ArrayList;
import java.util.Random;

/**
 * Application Business Rules layer Use Case Interactor for generating a recommendation based on
 * a given Playlist.
 */
public class recommendSong implements recommendationInputBoundary {
    songAccessInterface library;
    recommendationOutputBoundary out;

    public recommendSong(songAccessInterface library, recommendationOutputBoundary out){
        this.library = library;
        this.out = out;
    }

    /**
     * Generates a recommendation based on the given Playlist.
     * @param p the Playlist input data on which the recommendation is requested
     */
    @Override
    public void recommendation(playlistInputData p) {
        Random random = new Random();
        ArrayList<Song> playlist = p.getSongs();

        Song randomSong = playlist.get(random.nextInt(playlist.size()));

        // TODO: find another song by the genre of random song, implement once Song and songLibrary are implemented

        Song rec = null;
        out.recommendSong(new songOutputData(rec));
    }
}
