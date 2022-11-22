package Presenter;

import Entities.Song;
import OutputBoundary.searchOutputBoundary;
import OutputData.searchOutputData;
import ViewModel.searchViewModel;

import java.util.List;

/**
 * Interface adapters layer presenter for displaying search use case output.
 */
public class searchPresenter implements searchOutputBoundary{

    private final searchViewModel searchViewModel;

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
        String[][] formattedOutput = formatOutput(songs);
        this.searchViewModel.updateOutput(formattedOutput);
    }

    /**
     * Helper function for foundSongs.
     * @param songs is a List of songs
     * @return a 2D array of Strings with the ID, Name, Artist and Genre of every song in songs
     */
    public String[][] formatOutput(List<Song> songs){
        String[][] formattedOutput = new String[songs.size()][4];
        for (int i = 0; i < songs.size(); i++) {
            Song song = songs.get(i);
            String id = Integer.toString(song.getID());
            StringBuilder artists = new StringBuilder();
            for (String artist : song.getArtistList()) {
                artists.append(artist).append(" ");
            }
            String[] row = {id, song.getName(), artists.toString(), song.getGenre()};
            formattedOutput[i] = row;
        }
        return formattedOutput;
    }
}
