package Presenter;

import Entities.Song;
import OutputBoundary.searchOutputBoundary;
import OutputData.searchOutputData;
import ViewModel.searchViewModel;

import java.util.List;

public class searchPresenter implements searchOutputBoundary{

    // TOOD: instance of view model
    private searchViewModel searchViewModel;

    public searchPresenter(searchViewModel searchViewModel){
        this.searchViewModel = searchViewModel;
    }

    /**
     *
     * @param searchOutputData contains the List of songs that were found by the user's search
     */
    @Override
    public void foundSongs(searchOutputData searchOutputData) {
        List<Song> songs = searchOutputData.getFoundSongs();
        String[][] formattedOutput = new String[songs.size()][4];
        for (int i = 0; i < songs.size(); i++) {
            Song song = songs.get(i);
            String id = String.valueOf(song.getID());
            StringBuilder artists = new StringBuilder();
            for (String artist : song.getArtistList()) {
                artists.append(artist).append(" ");
            }
            String[] row = {id, song.getName(), artists.toString(), song.getGenre()};
            formattedOutput[i] = row;
        }
        this.searchViewModel.updateOutput(formattedOutput);
    }
}
