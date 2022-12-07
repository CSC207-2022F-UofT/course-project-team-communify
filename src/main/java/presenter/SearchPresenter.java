package presenter;

import outputBoundary.SearchOutputBoundary;
import outputData.SearchOutputData;
import viewModel.SearchViewModel;
import viewModel.SongDsView;
import viewModel.UserDsView;

import java.util.ArrayList;
import java.util.List;

/**
 * Interface adapters layer presenter for displaying search use case output.
 */
public class SearchPresenter implements SearchOutputBoundary {

    private final SearchViewModel searchViewModel;
    private final UserDsView tempUser;

    /**
     * @param searchViewModel the view model to display search results
     * @param tempUser the empty user to create song objects
     */
    public SearchPresenter(SearchViewModel searchViewModel, UserDsView tempUser){
        this.searchViewModel = searchViewModel;
        this.tempUser = tempUser;
    }

    /**
     *
     * @param searchOutputData contains the List of songs that were found by the user's search
     */
    @Override
    public void foundSongs(SearchOutputData searchOutputData) {
        List<SongDsView> songs = constructList(searchOutputData);
        String[][] formattedOutput = formatOutput(songs);
        this.searchViewModel.updateOutput(formattedOutput);
    }

    /**
     * @param searchOutputData the search results output data
     * @return a formatted list of SongDsView results
     */
    private List<SongDsView> constructList(SearchOutputData searchOutputData) {
        ArrayList<String> names = new ArrayList<>(searchOutputData.getFoundSongsNames());
        ArrayList<String[]> artists = new ArrayList<>(searchOutputData.getFoundSongsArtists());
        ArrayList<Integer> id = new ArrayList<>(searchOutputData.getFoundSongsID());
        ArrayList<String> genres = new ArrayList<>(searchOutputData.getFoundSongsGenres());
        ArrayList<SongDsView> songs = new ArrayList<>();

        for (int i = 0; i < names.size(); i++){
            SongDsView newSong = tempUser.getNewPlaylist().getNewSong();
            newSong.setName(names.get(i));
            newSong.setId(id.get(i));
            newSong.setGenre(genres.get(i));
            newSong.setArtists(artists.get(i));
            songs.add(newSong);
        }
        return songs;
    }

    /**
     * Helper function for foundSongs.
     * @param songs is a List of songs
     * @return a 2D array of Strings with the ID, Name, Artist and Genre of every song in songs
     */
    public String[][] formatOutput(List<SongDsView> songs){
        String[][] formattedOutput = new String[songs.size()][4];
        for (int i = 0; i < songs.size(); i++) {
            SongDsView song = songs.get(i);
            String id = Integer.toString(song.getId());
            StringBuilder artists = new StringBuilder();
            for (String artist : song.getArtists()) {
                artists.append(artist).append(" ");
            }
            String[] row = {id, song.getName(), artists.toString(), song.getGenre()};
            formattedOutput[i] = row;
        }
        return formattedOutput;
    }
}
