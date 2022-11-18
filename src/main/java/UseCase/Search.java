package UseCase;

import Entities.Song;
import InputBoundary.searchInputBoundary;
import OutputBoundary.searchOutputBoundary;
import Database.GetSongAccessInterface;
import InputData.searchInputData;
import Database.songDsData;
import OutputData.searchOutputData;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Application business rules use case class to search for a song.
 */
public class Search implements searchInputBoundary {
    private final searchOutputBoundary searchPresenter;

    GetSongAccessInterface songLibrary;

    /**
     * @param songLibrary the library of all songs in the program
     * @param searchPresenter the presenter to output results to the view
     */
    public Search(GetSongAccessInterface songLibrary, searchOutputBoundary searchPresenter){
        this.songLibrary = songLibrary;
        this.searchPresenter = searchPresenter;
    }

    /**
     *
     * @param searchInputData: contains the text to search for
     */
    @Override
    public void search(searchInputData searchInputData){
        String name = searchInputData.getSearchText();
        Collection<songDsData> library = songLibrary.getLibrary();
        List<Song> foundSongs = new ArrayList<>();

        for (songDsData song: library) {
            String currentName = song.getSong().getName();
            if(currentName.equals(name)){
                foundSongs.add(song.getSong());
            }
        }
        searchOutputData outputData = new searchOutputData(foundSongs);
        this.searchPresenter.foundSongs(outputData);
    }
}
