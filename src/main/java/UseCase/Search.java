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
    private searchOutputBoundary searchOutputBoundary;

    songAccessInterface songLibrary;

    public Search(songAccessInterface songLibrary, searchOutputBoundary searchOutputBoundary ){
        this.songLibrary = songLibrary;
        this.searchOutputBoundary = searchOutputBoundary;
    }
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
        // TODO: call presenter's foundSong method
    }
}
