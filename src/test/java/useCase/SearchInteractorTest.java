package useCase;

import view.InMemoryUser;
import viewModel.SearchViewModel;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 * Tests the search use case
 */
public class SearchInteractorTest {

    /**
     * Tests searching an exact title
     */
    @Test
    public void testExactSearch(){
        SearchViewModel searchViewModel = new SearchViewModel(new InMemoryUser());
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

    /**
     * tests searching an incomplete title
     */
    @Test
    public void testSearch(){
        SearchViewModel searchViewModel = new SearchViewModel(new InMemoryUser());
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

    /**
     * tests searching nothing
     */
    @Test
    public void testEmptySearch(){
        SearchViewModel searchViewModel = new SearchViewModel(new InMemoryUser());
        searchViewModel.search("");
        String[][] outputSongs = searchViewModel.getOutputSongs();
        int count = 0;
        for (String[] ignored : outputSongs) {
            count++;
        }
        Assertions.assertEquals(outputSongs.length, count);
    }

    /**
     * tests searching for a song that does not exist
     */
    @Test
    public void testNotInDatabaseSearch(){
        SearchViewModel searchViewModel = new SearchViewModel(new InMemoryUser());
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
