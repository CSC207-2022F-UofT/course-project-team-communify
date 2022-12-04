package useCase;

import database.GetSongAccessInterface;
import database.SongDsData;
import database.SongLibrary;
import entities.Song;
import inputBoundary.RecommendationInputBoundary;
import inputData.PlaylistInputData;
import inputData.SongInputData;
import outputBoundary.SongOutputBoundary;

import java.util.ArrayList;
import java.util.Random;

/**
 * Application Business Rules layer Use Case Interactor for generating a recommendation based on
 * a given Playlist.
 */
public class RecommendSongInteractor implements RecommendationInputBoundary {
    private final GetSongAccessInterface library;
    private final SongOutputBoundary out;

    /**
     * @param out the recommendation output presenter
     */
    public RecommendSongInteractor(SongOutputBoundary out){
        this.library = SongLibrary.getInstance();
        this.out = out;
    }

    /**
     * Generates a recommendation based on the given Playlist in the constructor.
     */
    @Override
    public void recommendation(PlaylistInputData data) {
        Random random = new Random();
        ArrayList<Song> playlist = data.getSongs();

        Song randomSong = playlist.get(random.nextInt(playlist.size()));
        String genre = randomSong.getGenre();
        Song rec = null;

        for (SongDsData song : library.getLibrary()){
            if (rec == null){
                rec = song.getSong();
            }
            if (genre.equals(song.getGenre()) & !playlist.contains(song.getSong())) {
                rec = song.getSong();
                break;
            }
        }

        PlaySongInteractor play = new PlaySongInteractor(out);
        play.playSong(new SongInputData(rec));
    }
}
