package UseCase;

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

public class Search implements SearchInputBoundary {
    private final SearchOutputBoundary searchPresenter;

    GetSongAccessInterface songLibrary;

    public Search(GetSongAccessInterface songLibrary, SearchOutputBoundary searchPresenter){
        this.songLibrary = songLibrary;
        this.searchPresenter = searchPresenter;
    }

    /**
     *
     * @param searchInputData: contains the text to search for
     */
    @Override
    public void search(SearchInputData searchInputData){
        String name = searchInputData.getSearchText();
        Collection<SongDsData> library = songLibrary.getLibrary();
        List<Song> foundSongs = new ArrayList<>();

        for (SongDsData song: library) {
            String currentName = song.getSong().getName();
            if(currentName.equals(name)){
                foundSongs.add(song.getSong());
            }
        }
        SearchOutputData outputData = new SearchOutputData(foundSongs);
        this.searchPresenter.foundSongs(outputData);
    }
}
