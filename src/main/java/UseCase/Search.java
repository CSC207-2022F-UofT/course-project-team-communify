package UseCase;

import Entities.Song;
import InputBoundary.searchInputBoundary;
import OutputBoundary.searchOutputBoundary;
import Database.songAccessInterface;
import InputData.searchInputData;
import Database.songDsData;
import OutputData.searchOutputData;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Search implements searchInputBoundary {
    private final searchOutputBoundary searchPresenter;

    songAccessInterface songLibrary;

    public Search(songAccessInterface songLibrary, searchOutputBoundary searchPresenter){
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
        List<Song> foundSongs = new ArrayList<Song>();

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
