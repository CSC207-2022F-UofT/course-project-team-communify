package outputData;


import entities.Song;

import java.util.ArrayList;
import java.util.List;

/**
 * Application Business Rules layer data structure for receiving search output from use cases.
 */
public class SearchOutputData {
    private final List<Song> foundSongs;

    /**
     * @param foundSongs the list of songs found by the search
     */
    public SearchOutputData(List<Song> foundSongs){
        this.foundSongs = foundSongs;
    }

    /**
     * @return the search results names
     */
    public List<String> getFoundSongsNames() {
        List<String> names = new ArrayList<>();
        for (Song s : foundSongs)
            names.add(s.getName());
        return names;
    }

    /**
     * @return the search results genres
     */
    public List<String> getFoundSongsGenres() {
        List<String> genres = new ArrayList<>();
        for (Song s : foundSongs)
            genres.add(s.getGenre());
        return genres;
    }

    /**
     * @return the search results IDs
     */
    public List<Integer> getFoundSongsID() {
        List<Integer> id = new ArrayList<>();
        for (Song s : foundSongs)
            id.add(s.getID());
        return id;
    }

    /**
     * @return the search results artists
     */
    public List<String[]> getFoundSongsArtists() {
        List<String[]> artists = new ArrayList<>();
        for (Song s : foundSongs)
            artists.add(s.getArtistList());
        return artists;
    }
}
