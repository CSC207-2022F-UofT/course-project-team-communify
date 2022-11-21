package UseCase;

import Database.GetSongAccessInterface;
import Entities.Song;
import InputBoundary.searchInputBoundary;
import OutputBoundary.searchOutputBoundary;
import InputData.searchInputData;
import Database.songDsData;
import OutputData.searchOutputData;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Search implements searchInputBoundary {
    private final searchOutputBoundary searchPresenter;

    private GetSongAccessInterface songLibrary;

    public Search(searchOutputBoundary searchPresenter){
        this.songLibrary = Database.songLibrary.getInstance();
        this.searchPresenter = searchPresenter;
    }

    /**
     * Method that goes through the database (songLibrary) to get the songs that match what was searched
     * @param searchInputData: contains the text to search for
     */
    @Override
    public void search(searchInputData searchInputData){
        String name = searchInputData.getSearchText().toLowerCase();
        Collection<songDsData> library = songLibrary.getLibrary();
        List<Song> foundSongs = findSongs(name, library);
        searchOutputData outputData = new searchOutputData(foundSongs);
        this.searchPresenter.foundSongs(outputData);
    }

    /**
     * Helper function for search().
     * Goes through database and finds songs that have an exact match or start with the name
     * @param name
     * @param library
     * @return A List with the exact matches at the top and similar songs after
     */
    private static List<Song> findSongs(String name, Collection<songDsData> library) {
        List<Song> foundSongs = new ArrayList<>();
        List<Song> similarSongs = new ArrayList<>();

        for (songDsData song: library) {
            String currentName = song.getSong().getName().toLowerCase();
            if(currentName.equals(name)){
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
