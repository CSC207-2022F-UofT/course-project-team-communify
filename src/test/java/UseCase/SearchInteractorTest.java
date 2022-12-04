package useCase;

import viewModel.SearchViewModel;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class SearchInteractorTest {

    @Test
    public void testExactSearch(){
        SearchViewModel searchViewModel = new SearchViewModel();
        searchViewModel.search("Food");
        String[][] outputSongs = searchViewModel.getOutputSongs();
        int count = 0;
        for (String[] outputSong : outputSongs) {
            if (outputSong[1].equals("Food")) {
                count++;
            }
        }
        Assertions.assertEquals(1, count);
    }

    @Test
    public void testSearch(){
        SearchViewModel searchViewModel = new SearchViewModel();
        searchViewModel.search("foo");
        String[][] outputSongs = searchViewModel.getOutputSongs();
        int count = 0;
        for (String[] outputSong : outputSongs) {
            if (outputSong[1].toLowerCase().contains("foo")) {
                count++;
            }
        }
        Assertions.assertEquals(3, count);
    }

    @Test
    public void testEmptySearch(){
        SearchViewModel searchViewModel = new SearchViewModel();
        searchViewModel.search("");
        String[][] outputSongs = searchViewModel.getOutputSongs();
        int count = 0;
        for (String[] ignored : outputSongs) {
            count++;
        }
        Assertions.assertEquals(outputSongs.length, count);
    }

    @Test
    public void testNotInDatabaseSearch(){
        SearchViewModel searchViewModel = new SearchViewModel();
        searchViewModel.search("abc");
        String[][] outputSongs = searchViewModel.getOutputSongs();
        int count = 0;
        for (String[] outputSong : outputSongs) {
            if (outputSong[1].toLowerCase().contains("abc")) {
                count++;
            }
        }
        Assertions.assertEquals(0, count);
    }
}
