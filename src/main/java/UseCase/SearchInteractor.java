package UseCase;

import Database.SongLibrary;
import Entities.Song;
import InputBoundary.SearchInputBoundary;
import OutputBoundary.SearchOutputBoundary;
import Database.GetSongAccessInterface;
import InputData.SearchInputData;
import Database.SongDsData;
import OutputData.SearchOutputData;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/**
 * Application business rules use case class to search for a song.
 */
public class SearchInteractor implements SearchInputBoundary {
    private final SearchOutputBoundary searchPresenter;

    private final GetSongAccessInterface songLibrary;

    /**
     * @param searchPresenter the search output presenter
     */
    public SearchInteractor(SearchOutputBoundary searchPresenter){
        // import songLibrary instead of passing it in
        this.songLibrary = SongLibrary.getInstance();
        this.searchPresenter = searchPresenter;
    }

    /**
     * Method that goes through the database (songLibrary) to get the songs that match what was searched
     * @param searchInputData: contains the text to search for
     */
    @Override
    public void search(SearchInputData searchInputData){
        String name = searchInputData.getSearchText().toLowerCase();
        Collection<SongDsData> library = songLibrary.getLibrary();
        List<Song> foundSongs = findSongs(name, library);
        SearchOutputData outputData = new SearchOutputData(foundSongs);
        this.searchPresenter.foundSongs(outputData);
    }

    /**
     * Helper function for search().
     * Goes through database and finds songs that have an exact match or start with the name
     * @param name the name of the song to search for
     * @param library the library of all songs
     * @return A List with the exact matches at the top and similar songs after
     */
    private static List<Song> findSongs(String name, Collection<SongDsData> library) {
        List<Song> foundSongs = new ArrayList<>();
        List<Song> similarSongs = new ArrayList<>();

        for (SongDsData song: library) {
            String currentName = song.getSong().getName().toLowerCase();
            if(currentName.substring(0, currentName.length() - 2).equals(name)){
                // take the substring because of a weird icon at the end of song names
                foundSongs.add(song.getSong());
            } else if (currentName.startsWith(name)){
                similarSongs.add(song.getSong());
            } else if (currentName.contains(name)) {
                similarSongs.add(song.getSong());
            }
        }
        foundSongs.addAll(similarSongs);
        return foundSongs;
    }
}
