package Controller;

import Entities.Song;
import InputBoundary.playSongInputBoundary;
import InputData.songInputData;

/**
 * Controller for the playSong use case
 */
public class playSongController {

    private final playSongInputBoundary playSongInteractor;
    private final songInputData songInputData;

    public playSongController(playSongInputBoundary playSongInteractor, Song song) {
        this.playSongInteractor = playSongInteractor;
        this.songInputData = new songInputData(song);
    }


    public void playSong() {
        this.playSongInteractor.playSong(this.songInputData);
    }

}
